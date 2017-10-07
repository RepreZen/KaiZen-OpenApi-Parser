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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;

public abstract class JsonOverlay<V> implements IJsonOverlay<V> {

	protected final static ObjectMapper mapper = new ObjectMapper();

	protected V value = null;
	protected JsonOverlay<?> parent;

	protected ReferenceRegistry refReg;

	public JsonOverlay(V value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		this.value = value;
		this.parent = parent;
		this.refReg = refReg;
	}

	public JsonOverlay(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		this.value = fromJson(json);
		this.parent = parent;
		this.refReg = refReg;
	}

	@Override
	public V get() {
		return value;
	}

	@Override
	public boolean isPresent() {
		return value != null;
	}

	
	@Override
	public IJsonOverlay<?> find(JsonPointer path) {
		return path.matches() ? this : _find(path);
	}

	abstract protected IJsonOverlay<?> _find(JsonPointer path);

	@Override
	public IJsonOverlay<?> find(String path) {
		return find(JsonPointer.compile(path));
	}

	public void set(V value) {
		set(value, true);
	}

	protected void set(V value, boolean invalidate) {
		this.value = value;
	}

	public JsonOverlay<?> getParent() {
		return parent;
	}
	
	protected void setParent(JsonOverlay<?> parent) {
		this.parent = parent;
	}
	
	public JsonOverlay<?> getRoot() {
		return parent != null ? parent.getRoot() : this;
	}
	protected abstract V fromJson(JsonNode json);

	public JsonNode toJson() {
		return toJson(false);
	};

	public abstract JsonNode toJson(boolean keepEmpty);

	// some utility classes for overlays

	protected static ObjectNode jsonObject() {
		return JsonNodeFactory.instance.objectNode();
	}

	protected static ArrayNode jsonArray() {
		return JsonNodeFactory.instance.arrayNode();
	}

	protected static TextNode jsonScalar(String s) {
		return JsonNodeFactory.instance.textNode(s);
	}

	protected static ValueNode jsonScalar(int n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(long n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(short n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(byte n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(double n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(float n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(BigInteger n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonScalar(BigDecimal n) {
		return JsonNodeFactory.instance.numberNode(n);
	}

	protected static ValueNode jsonBoolean(boolean b) {
		return JsonNodeFactory.instance.booleanNode(b);
	}

	protected static MissingNode jsonMissing() {
		return MissingNode.getInstance();
	}

	protected static final <T> Iterable<T> iterable(final Iterator<T> iterator) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}

	@Override
	public String toString() {
		return toJson().toString();
	}

}