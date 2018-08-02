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
import com.reprezen.jsonoverlay.JsonLoader;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
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
			JsonNode tree = new JsonLoader().loadString(resolutionBase, spec);
			return parse(tree, resolutionBase, validate);
		} catch (IOException e) {
			throw new OpenApiParserException("Failed to parse spec as JSON or YAML", e);
		}
	}

	public OpenApi<?> parse(File specFile) throws Exception {
		return parse(specFile, true);
	}

	public OpenApi<?> parse(File specFile, boolean validate) throws Exception {
		try {
			return parse(specFile.toURI().toURL(), validate);
		} catch (IOException e) {
			throw new OpenApiParserException("Failed to read spec from file", e);
		}
	}

	public OpenApi<?> parse(URI uri) throws Exception {
		return parse(uri, true);
	}

	public OpenApi<?> parse(URI uri, boolean validate) throws Exception {
		try {
			return parse(uri.toURL(), validate);
		} catch (MalformedURLException e) {
			throw new OpenApiParserException("Invalid URI for Swagger spec", e);
		}
	}

	public OpenApi<?> parse(URL resolutionBase) throws Exception {
		return parse(resolutionBase, true);
	}

	public OpenApi<?> parse(URL resolutionBase, boolean validate) throws Exception {
		ReferenceManager manager = new ReferenceManager(resolutionBase);
		return parse(manager, validate);
	}

	public OpenApi<?> parse(JsonNode tree, URL resolutionBase) {
		return parse(tree, resolutionBase, true);
	}

	public OpenApi<?> parse(JsonNode tree, URL resolutionBase, boolean validate) {
		ReferenceManager manager = new ReferenceManager(resolutionBase, tree);
		return parse(manager, validate);
	}

	private OpenApi<?> parse(ReferenceManager manager, boolean validate) {
		JsonNode tree;
		try {
			tree = manager.loadDoc();
			if (isVersion3(tree)) {
				OpenApi3 model = (OpenApi3) OpenApi3Impl.factory.create(tree, null, manager);
				injector.injectMembers(model);
				if (validate) {
					model.validate();
				}
				return model;
			} else {
				throw new OpenApiParserException(
						"Could not determine OpenApi version from model: no 'openapi' property");
			}
		} catch (IOException e) {
			throw new OpenApiParserException("Failed to parse model", e);
		}
	}

	protected boolean isVersion3(JsonNode tree) {
		JsonNode versionNode = tree.path("openapi");
		return versionNode.isTextual() && versionNode.asText().startsWith("3.");
	}

	public static class OpenApiParserException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public OpenApiParserException() {
			super();
		}

		public OpenApiParserException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public OpenApiParserException(String message, Throwable cause) {
			super(message, cause);
		}

		public OpenApiParserException(String message) {
			super(message);
		}

		public OpenApiParserException(Throwable cause) {
			super(cause);
		}
	}
}