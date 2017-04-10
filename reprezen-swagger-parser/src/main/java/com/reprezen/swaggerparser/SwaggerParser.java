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
package com.reprezen.swaggerparser;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.impl3.Swagger3Impl;
import com.reprezen.swaggerparser.jsonoverlay.JsonLoader;
import com.reprezen.swaggerparser.jsonoverlay.ResolutionBase;
import com.reprezen.swaggerparser.jsonoverlay.Resolver;

public class SwaggerParser {

    public static Swagger parse(String spec, URL resolutionBase) {
        return parse(spec, resolutionBase, true);
    }

    public static Swagger parse(String spec, URL resolutionBase, boolean validate) {
        try {
            JsonNode tree = JsonLoader.loadString(resolutionBase, spec);
            ResolutionBase.register(resolutionBase.toString(), tree);
            return parse(resolutionBase, validate);
        } catch (IOException e) {
            throw new SwaggerParserException("Failed to parse spec as JSON or YAML", e);
        }
    }

    public static Swagger parse(File specFile) {
        return parse(specFile, true);
    }

    public static Swagger parse(File specFile, boolean validate) {
        try {
            return parse(specFile.toURI().toURL(), validate);
        } catch (IOException e) {
            throw new SwaggerParserException("Failed to read spec from file", e);
        }
    }

    public static Swagger parse(URI uri) {
        return parse(uri, true);
    }

    public static Swagger parse(URI uri, boolean validate) {
        try {
            return parse(uri.toURL(), validate);
        } catch (MalformedURLException e) {
            throw new SwaggerParserException("Invalid URI for Swagger spec", e);
        }
    }

    public static Swagger parse(URL resolutionBase) {
        return parse(resolutionBase, true);
    }

    public static Swagger parse(URL resolutionBase, boolean validate) {
        try {
            Resolver.preresolve(resolutionBase);
            JsonNode tree = ResolutionBase.get(resolutionBase.toString()).getJson();
            if (isVersion3(tree)) {
                Swagger3Impl model = new Swagger3Impl(null, tree, null);
                if (validate) {
                    model.validate();
                }
                return (Swagger) model;
            } else {
                throw new SwaggerParserException(
                        "Could not determine OpenApi version - missing or invalid 'openapi' or 'swagger' property");
            }
        } catch (Exception e) {
            // throw new SwaggerParserException("Failed to parse Swagger spec", e);
            throw e;
        }

    }

    private static boolean isVersion3(JsonNode tree) {
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