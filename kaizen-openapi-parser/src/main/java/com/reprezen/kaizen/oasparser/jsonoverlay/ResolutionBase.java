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
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ResolutionBase {

    private static Map<String, ResolutionBase> instances = Maps.newConcurrentMap();
    
    private String urlString;
    private Boolean isValid = null;
    private ResolutionException error = null;
    private JsonNode json = null;

    private ResolutionBase(String urlString) {
        this.urlString = urlString;
        this.isValid = null;
    }

    private ResolutionBase(String urlString, ResolutionException e) {
        this.urlString = urlString;
        this.isValid = false;
        this.error = e;
    }

    private ResolutionBase(String urlString, JsonNode json) {
        this.urlString = urlString;
        this.json = json;
        this.isValid = true;
    }

    public static ResolutionBase of(URL baseUrl, boolean resolve) {
        return of(baseUrl, baseUrl.toString(), resolve);
    }

    public static Collection<ResolutionBase> getAllBases() {
        Set<ResolutionBase> allBases = Sets.newHashSet(); // cull duplicates caused by aliased entries
        allBases.addAll(instances.values());
        return allBases;
    }

    public static ResolutionBase get(String urlString) {
        return instances.get(urlString);
    }

    public static ResolutionBase of(String rawUrlString, boolean resolve) {
        URL url;
        try {
            url = new URL(rawUrlString);
            return of(url, rawUrlString, resolve);
        } catch (MalformedURLException e) {
            return new ResolutionBase(rawUrlString, new ResolutionException("Invalid URL: " + rawUrlString, e));
        }
    }

    public static ResolutionBase register(String urlString, JsonNode json) {
        ResolutionBase base = new ResolutionBase(urlString, json);
        instances.put(urlString, base);
        return base;
    }

    private static ResolutionBase of(URL baseUrl, String rawUrlString, boolean resolve) {
        if (instances.containsKey(rawUrlString)) {
            return instances.get(rawUrlString);
        }
        try {
            String urlString = normalizeUrlString(baseUrl);
            ResolutionBase base;
            if (instances.containsKey(urlString)) {
                base = instances.get(urlString);
                instances.put(rawUrlString, base);
            } else {
                base = new ResolutionBase(urlString);
                instances.put(urlString, base);
                instances.put(baseUrl.toString(), base);
            }
            if (resolve && !base.isResolved()) {
                base.resolve();
            }
            return base;
        } catch (ResolutionException e) {
            if (!instances.containsKey(rawUrlString)) {
                instances.put(rawUrlString, new ResolutionBase(rawUrlString, e));
            }
            return instances.get(rawUrlString);
        }
    }

    private static String normalizeUrlString(URL url) {
        String urlString = url.toString();
        if (urlString.contains("#")) {
            urlString = urlString.substring(0, urlString.indexOf('#'));
        }
        try {
            URI uri = new URI(urlString).normalize();
            return uri.toString();
        } catch (URISyntaxException e) {
            throw new ResolutionException("Invalid document URI", e);
        }
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
                json = JsonLoader.load(new URL(urlString));
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
}
