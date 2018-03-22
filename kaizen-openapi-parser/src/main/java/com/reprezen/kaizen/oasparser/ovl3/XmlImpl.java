package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Xml;

public class XmlImpl extends PropertiesOverlay<Xml> implements Xml {

	@Generated("com.reprezen.gen.CodeGenerator")
	public XmlImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public XmlImpl(Xml xml, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(xml, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> name;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> namespace;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> prefix;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> attribute;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> wrapped;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Name
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName() {
		return name._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName(boolean elaborate) {
		return name._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setName(String name) {
		this.name._set(name);
	}

	// Namespace
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getNamespace() {
		return namespace._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getNamespace(boolean elaborate) {
		return namespace._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setNamespace(String namespace) {
		this.namespace._set(namespace);
	}

	// Prefix
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getPrefix() {
		return prefix._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getPrefix(boolean elaborate) {
		return prefix._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPrefix(String prefix) {
		this.prefix._set(prefix);
	}

	// Attribute
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAttribute() {
		return attribute._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAttribute(boolean elaborate) {
		return attribute._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isAttribute() {
		return attribute._get() != null ? attribute._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAttribute(Boolean attribute) {
		this.attribute._set(attribute);
	}

	// Wrapped
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getWrapped() {
		return wrapped._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getWrapped(boolean elaborate) {
		return wrapped._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isWrapped() {
		return wrapped._get() != null ? wrapped._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setWrapped(Boolean wrapped) {
		this.wrapped._set(wrapped);
	}

	// Extension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return extensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		name = createChild("name", this, StringOverlay.factory);
		namespace = createChild("namespace", this, StringOverlay.factory);
		prefix = createChild("prefix", this, StringOverlay.factory);
		attribute = createChild("attribute", this, BooleanOverlay.factory);
		wrapped = createChild("wrapped", this, BooleanOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<Xml> factory = new OverlayFactory<Xml>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Xml>> getOverlayClass() {
			return XmlImpl.class;
		}

		@Override
		public JsonOverlay<Xml> _create(Xml xml, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new XmlImpl(xml, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Xml> castOverlay = (JsonOverlay<Xml>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Xml> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new XmlImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Xml> castOverlay = (JsonOverlay<Xml>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Xml> getSubtypeOf(Xml xml) {
		return Xml.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Xml> getSubtypeOf(JsonNode json) {
		return Xml.class;
	}
}
