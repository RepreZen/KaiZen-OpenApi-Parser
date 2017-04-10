/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.jsonoverlay;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;

public class JsonLoader {

    private static ObjectMapper jsonMapper = new ObjectMapper();
    private static YAMLMapper yamlMapper = new YAMLMapper();
    private static Yaml yaml = new Yaml();

    private static Map<String, JsonNode> cache = Maps.newHashMap();

    private JsonLoader() {
    }

    public static JsonNode load(URL url) throws IOException {
        String urlString = url.toString();
        if (cache.containsKey(urlString)) {
            return cache.get(urlString);
        }
        String json = IOUtils.toString(url.openStream(), Charsets.UTF_8);
        return loadString(url, json);
    }

    public static JsonNode loadString(URL url, String json) throws IOException, JsonProcessingException {
        String trimmed = json.trim();
        JsonNode tree;
        if (trimmed.startsWith("{")) {
            tree = jsonMapper.readTree(trimmed);
        } else {
            Object parsedYaml = yaml.load(trimmed); // this handles aliases - YAMLMapper doesn't
            tree = yamlMapper.convertValue(parsedYaml, JsonNode.class);
        }
        if (url != null) {
            cache.put(url.toString(), tree);
        }
        return tree;
    }

}
