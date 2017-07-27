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

public class ResolutionBaseRegistry {

    private Map<String, ResolutionBase> instances = Maps.newConcurrentMap();
    private final JsonLoader jsonLoader;
    
    public ResolutionBaseRegistry(JsonLoader jsonLoader) {
        this.jsonLoader = jsonLoader;
    }
    
    public ResolutionBase of(URL baseUrl, boolean resolve) {
        return of(baseUrl, baseUrl.toString(), resolve);
    }

    public Collection<ResolutionBase> getAllBases() {
        Set<ResolutionBase> allBases = Sets.newHashSet(); // cull duplicates caused by aliased entries
        allBases.addAll(instances.values());
        return allBases;
    }

    public ResolutionBase get(String urlString) {
        return instances.get(urlString);
    }

    public ResolutionBase of(String rawUrlString, boolean resolve) {
        URL url;
        try {
            url = new URL(rawUrlString);
            return of(url, rawUrlString, resolve);
        } catch (MalformedURLException e) {
            return new ResolutionBase(rawUrlString, new ResolutionException("Invalid URL: " + rawUrlString, e), this);
        }
    }

    public ResolutionBase register(String urlString, JsonNode json) {
        ResolutionBase base = new ResolutionBase(urlString, json, this);
        instances.put(urlString, base);
        return base;
    }
    
    public JsonLoader getJsonLoader() {
        return jsonLoader;
    }

    private ResolutionBase of(URL baseUrl, String rawUrlString, boolean resolve) {
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
                base = new ResolutionBase(urlString, this);
                instances.put(urlString, base);
                instances.put(baseUrl.toString(), base);
            }
            if (resolve && !base.isResolved()) {
                base.resolve();
            }
            return base;
        } catch (ResolutionException e) {
            if (!instances.containsKey(rawUrlString)) {
                instances.put(rawUrlString, new ResolutionBase(rawUrlString, e, this));
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


}
