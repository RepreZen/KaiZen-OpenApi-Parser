/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.kaizen.oasparser;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonLoader;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.ResolutionBaseRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.Resolver;
import com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl;
import com.reprezen.kaizen.oasparser.val3.ValidationConfigurator;
import com.reprezen.kaizen.oasparser.val3.ovl.OverlayValidationConfigurator;

public class OpenApiParser {

	private Injector injector;

	public OpenApiParser() {
		this(new OverlayValidationConfigurator());
	}

	public OpenApiParser(ValidationConfigurator validationConfigurator) {
		this.injector = Guice.createInjector(validationConfigurator);
	}

	public OpenApi<?> parse(String spec, URL resolutionBase) {
		return parse(spec, resolutionBase, true);
	}

	public OpenApi<?> parse(String spec, URL resolutionBase, boolean validate) {
		try {
			JsonLoader jsonLoader = new JsonLoader();
			JsonNode tree = jsonLoader.loadString(resolutionBase, spec);
			ResolutionBaseRegistry resolutionBaseRegistry = new ResolutionBaseRegistry(jsonLoader);
			resolutionBaseRegistry.register(resolutionBase.toString(), tree);
			return parse(resolutionBase, validate, resolutionBaseRegistry);
		} catch (IOException e) {
			throw new SwaggerParserException("Failed to parse spec as JSON or YAML", e);
		}
	}

	public OpenApi<?> parse(File specFile) {
		return parse(specFile, true);
	}

	public OpenApi<?> parse(File specFile, boolean validate) {
		try {
			return parse(specFile.toURI().toURL(), validate);
		} catch (IOException e) {
			throw new SwaggerParserException("Failed to read spec from file", e);
		}
	}

	public OpenApi<?> parse(URI uri) {
		return parse(uri, true);
	}

	public OpenApi<?> parse(URI uri, boolean validate) {
		try {
			return parse(uri.toURL(), validate);
		} catch (MalformedURLException e) {
			throw new SwaggerParserException("Invalid URI for Swagger spec", e);
		}
	}

	public OpenApi<?> parse(URL resolutionBase) {
		return parse(resolutionBase, true);
	}

	public OpenApi<?> parse(URL resolutionBase, boolean validate) {
		return parse(resolutionBase, validate, new ResolutionBaseRegistry(new JsonLoader()));
	}

	protected OpenApi<?> parse(URL resolutionBase, boolean validate, ResolutionBaseRegistry resolutionBaseRegistry) {
		try {
			ReferenceRegistry referenceRegistry = new ReferenceRegistry();
			new Resolver(referenceRegistry, resolutionBaseRegistry).preresolve(resolutionBase);
			JsonNode tree = resolutionBaseRegistry.get(resolutionBase.toString()).getJson();
			if (isVersion3(tree)) {
				OpenApi3Impl model = new OpenApi3Impl(tree, null, referenceRegistry);
				injector.injectMembers(model);
				if (validate) {
					model.validate();
				}
				return model;
			} else {
				throw new SwaggerParserException(
						"Could not determine OpenApi version - missing or invalid 'openapi' or 'swagger' property");
			}
		} catch (Exception e) {
			// throw new SwaggerParserException("Failed to parse Swagger spec", e);
			throw e;
		}

	}

	protected boolean isVersion3(JsonNode tree) {
		JsonNode versionNode = tree.path("openapi");
		return versionNode.isTextual() && versionNode.asText().startsWith("3.");
	}

	public static class SwaggerParserException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public SwaggerParserException() {
			super();
		}

		public SwaggerParserException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public SwaggerParserException(String message, Throwable cause) {
			super(message, cause);
		}

		public SwaggerParserException(String message) {
			super(message);
		}

		public SwaggerParserException(Throwable cause) {
			super(cause);
		}
	}
}