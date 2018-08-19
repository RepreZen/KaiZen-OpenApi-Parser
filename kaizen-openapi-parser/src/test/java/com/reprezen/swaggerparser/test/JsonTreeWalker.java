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
package com.reprezen.swaggerparser.test;

import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class JsonTreeWalker {

	public static void walkTree(JsonNode tree, Predicate<JsonNode> nodeFilter, WalkMethod walkMethod) {
		if (nodeFilter == null) {
			nodeFilter = Predicates.alwaysTrue();
		}
		new JsonTreeWalker(nodeFilter, walkMethod).walk(tree, JsonPointer.compile(""));
	}

	private Predicate<JsonNode> nodeFilter;
	private WalkMethod walkMethod;

	public JsonTreeWalker(Predicate<JsonNode> nodeFilter, WalkMethod walkMethod) {
		this.nodeFilter = nodeFilter;
		this.walkMethod = walkMethod;
	}

	private void walk(JsonNode node, JsonPointer path) {
		if (nodeFilter.apply(node)) {
			visit(node, path);
		}
		walkChildren(node, path);
	}

	private void visit(JsonNode node, JsonPointer path) {
		walkMethod.run(node, path);
	}

	private void walkChildren(JsonNode node, JsonPointer path) {
		if (node instanceof ObjectNode) {
			for (Entry<String, JsonNode> field : iterable(node.fields())) {
				walk(field.getValue(), childPointer(path, field.getKey()));
			}
		} else if (node instanceof ArrayNode) {
			for (int i = 0; i < node.size(); i++) {
				walk(node.get(i), childPointer(path, i));
			}
		}
	}

	private JsonPointer childPointer(JsonPointer path, String childKey) {
		return JsonPointer.compile(path + "/" + quote(childKey));
	}

	private JsonPointer childPointer(JsonPointer path, int index) {
		return childPointer(path, Integer.toString(index));
	}

	public String quote(String key) {
		return key.replaceAll("~", "~0").replaceAll("/", "~1");
	}

	public static interface WalkMethod {
		void run(JsonNode node, JsonPointer path);
	}

	private <T> Iterable<T> iterable(final Iterator<T> iterator) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}
}
