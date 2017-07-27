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
package com.reprezen.kaizen.oasparser.jsonoverlay;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;

public class ResolutionBase {

    private String urlString;
    private Boolean isValid = null;
    private ResolutionException error = null;
    private JsonNode json = null;
    private final ResolutionBaseRegistry resolutionBaseRegistry;
    
    /*package*/ ResolutionBase(String urlString, ResolutionBaseRegistry resolutionBaseRegistry) {
        this.urlString = urlString;
        this.isValid = null;
        this.resolutionBaseRegistry = resolutionBaseRegistry;
    }

    /*package*/ ResolutionBase(String urlString, ResolutionException e, ResolutionBaseRegistry resolutionBaseRegistry) {
        this.urlString = urlString;
        this.isValid = false;
        this.error = e;
        this.resolutionBaseRegistry = resolutionBaseRegistry;
    }

    /*package*/ ResolutionBase(String urlString, JsonNode json, ResolutionBaseRegistry resolutionBaseRegistry) {
        this.urlString = urlString;
        this.json = json;
        this.isValid = true;
        this.resolutionBaseRegistry = resolutionBaseRegistry;
    }

    public JsonNode getJson() {
        return json;
    }

    public String getUrlString() {
        return urlString;
    }

    public boolean isResolved() {
        return isValid != null;
    }

    public boolean isValid() {
        return isValid != null && isValid;
    }

    public boolean isInvalid() {
        return isValid != null && !isValid;
    }

    public ResolutionException getError() {
        return error;
    }

    public String getErrorReason() {
        return error != null ? error.getLocalizedMessage() : null;
    }

    public JsonNode resolve() {
        if (isValid == null) {
            try {
                json = resolutionBaseRegistry.getJsonLoader().load(new URL(urlString));
                isValid = true;
            } catch (IOException e) {
                isValid = false;
                error = new ResolutionException(String.format("Failed to load document from '%s'", urlString), e);
                throw error;
            }
        } else if (isInvalid()) {
            throw error;
        }
        return json;
    }

    public String comprehend(String basedUrlString) {
        String fragment = "";
        if (basedUrlString.contains("#")) {
            int pos = basedUrlString.indexOf('#');
            fragment = basedUrlString.substring(pos);
            basedUrlString = basedUrlString.substring(0, pos);
        }
        try {
            URL url = new URL(new URL(urlString), basedUrlString);
            return url.toString() + fragment;
        } catch (MalformedURLException e) {
            throw new ResolutionException(
                    String.format("Failed to comprehend reference string '%s' relative to resolution base '%s'",
                            basedUrlString + fragment, urlString),
                    e);
        }
    }
    
    public ResolutionBaseRegistry getResolutionBaseRegistry() {
        return resolutionBaseRegistry;
    }
}
