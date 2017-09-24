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
package com.reprezen.kaizen.oasparser.jsonoverlay.coll;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.Pair;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.common.collect.Maps;

public class JsonPointerTrie<T> {

	private Map<Pattern, T> patternMap = Maps.newHashMap();

	private Map<String, JsonPointerTrie<T>> children = Maps.newHashMap();

	public void add(JsonPointer path, Pattern pattern, T value) {
		if (path.matches()) {
			// note: pattern = null works with HashMap and is how a path that terminates in
			// this object will be handled. When pattern is not null, a nonempty path will
			// have its head segment matched against non-null patterns to choose the value.
			patternMap.put(pattern, value);
		} else {
			String childKey = path.getMatchingProperty();
			if (!children.containsKey(childKey)) {
				children.put(childKey, new JsonPointerTrie<T>());
			}
			children.get(childKey).add(path.tail(), pattern, value);
		}
	}

	public Pair<T, JsonPointer> find(JsonPointer path) {
		if (path.matches()) {
			return Pair.of(patternMap.get(null), null);
		} else {
			String key = path.getMatchingProperty();
			if (children.containsKey(key)) {
				return children.get(key).find(path.tail());
			}
			// see if any non-null pattern matches key, return our T value with the same
			// JsonPointer. This case addresses objects that implenent maps with
			// pattern-constrained keys. We resolve to that map-like object, and the
			// remaining path starts with a key into that map.
			for (Pattern pat : patternMap.keySet()) {
				if (pat.matcher(key).matches()) {
					return Pair.of(patternMap.get(pat), path);
				}
			}
			// no non-null patterns matched - return our null-pattern value, with the
			// remaining path to be applied to it.
			return Pair.of(patternMap.get(null), path);
		}
	}
}
