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

import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonPath {

	private final Segment[] segments;

	public JsonPath(Segment... segments) {
		this.segments = segments;
	}

	public JsonPath(String path) {
		this(path != null ? getSegments(path.split("/")) : getSegments("*"));
	}

	public JsonPath(JsonPointer path) {
		this(path.toString());
	}

	public void setNode(JsonNode container, JsonNode value) {
		for (int i = 0; i < segments.length - 1; i++) {
			container = addNode(container, segments[i], segments[i + 1]);
		}
		addNode(container, segments[segments.length - 1], value);
	}

	private static Pattern indexPat = Pattern.compile("^[1-9][0-9]*$");

	private static Segment[] getSegments(String... rawSegments) {
		Segment[] segments = new Segment[rawSegments.length];
		for (int i = 0; i < segments.length; i++) {
			if (indexPat.matcher(rawSegments[i]).matches()) {
				segments[i] = new Segment(Integer.parseInt(rawSegments[i]));
			} else {
				segments[i] = new Segment(rawSegments[i]);
			}
		}
		return segments;
	}

	private JsonNode addNode(JsonNode container, Segment segment, Segment nextSegment) {
		if (container.isObject() && segment.isString()) {
			ObjectNode obj = (ObjectNode) container;
			String key = segment.asString();
			if (obj.has(key)) {
				return obj.get(key);
			} else if (nextSegment.isString()) {
				return obj.putObject(key);
			} else {
				ArrayNode array = JsonNodeFactory.instance.arrayNode();
				obj.set(key, array);
				return array;
			}
		} else if (container.isArray() && segment.isInt()) {
			ArrayNode array = (ArrayNode) container;
			int index = segment.asInt();
			if (array.has(index)) {
				return array.get(index);
			} else if (index == -1 || array.has(index - 1)) {
				// tack element onto end of array
				JsonNode newNode = nextSegment.isString() ? JsonNodeFactory.instance.objectNode()
						: JsonNodeFactory.instance.arrayNode();
				array.set(array.size(), newNode);
				return newNode;
			}
		}
		throw new IllegalStateException("Child path incompatible with existing JSON tree");
	}

	private void addNode(JsonNode container, Segment segment, JsonNode json) {
		if (container.isObject() && segment.isString()) {
			((ObjectNode) container).set(segment.asString(), json);
		} else if (container.isArray() && segment.isInt() && segment.asInt() <= container.size()) {
			int index = segment.asInt();
			((ArrayNode) container).set(index >= 0 ? index : container.size(), json);
		}
	}

	private static class Segment {
		private final String string;
		private final Integer integer;

		public Segment(String string) {
			// special case - * means append to end of array
			if (string.equals("*")) {
				this.string = null;
				this.integer = -1;
			} else {
				this.string = string;
				this.integer = null;
			}
		}

		public Segment(Integer integer) {
			this.integer = integer;
			this.string = null;
		}

		public boolean isString() {
			return string != null;
		}

		public boolean isInt() {
			return integer != null;
		}

		public String asString() {
			return string;
		}

		public Integer asInt() {
			return integer;
		}
	}

}
