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
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;

public class EncodingPropertyImpl extends PropertiesOverlay<EncodingProperty> implements EncodingProperty {

	@Generated("com.reprezen.gen.CodeGenerator")
	public EncodingPropertyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public EncodingPropertyImpl(EncodingProperty encodingProperty, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(encodingProperty, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> contentType;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<String> headers;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> style;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> explode;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// ContentType
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getContentType() {
		return contentType._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getContentType(boolean elaborate) {
		return contentType._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setContentType(String contentType) {
		this.contentType._set(contentType);
	}

	// Header
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, String> getHeaders() {
		return headers._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, String> getHeaders(boolean elaborate) {
		return headers._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasHeader(String name) {
		return headers.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getHeader(String name) {
		return headers._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setHeaders(Map<String, String> headers) {
		this.headers._set(headers);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setHeader(String name, String header) {
		headers._set(name, header);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeHeader(String name) {
		headers._remove(name);
	}

	// Style
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getStyle() {
		return style._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getStyle(boolean elaborate) {
		return style._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setStyle(String style) {
		this.style._set(style);
	}

	// Explode
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExplode() {
		return explode._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExplode(boolean elaborate) {
		return explode._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isExplode() {
		return explode._get() != null ? explode._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExplode(Boolean explode) {
		this.explode._set(explode);
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
		contentType = createChild("contentType", this, StringOverlay.factory);
		headers = createChildMap("headers", this, StringOverlay.factory, null);
		style = createChild("style", this, StringOverlay.factory);
		explode = createChild("explode", this, BooleanOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<EncodingProperty> factory = new OverlayFactory<EncodingProperty>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super EncodingProperty>> getOverlayClass() {
			return EncodingPropertyImpl.class;
		}

		@Override
		public JsonOverlay<EncodingProperty> _create(EncodingProperty encodingProperty, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new EncodingPropertyImpl(encodingProperty, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<EncodingProperty> castOverlay = (JsonOverlay<EncodingProperty>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<EncodingProperty> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new EncodingPropertyImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<EncodingProperty> castOverlay = (JsonOverlay<EncodingProperty>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends EncodingProperty> getSubtypeOf(EncodingProperty encodingProperty) {
		return EncodingProperty.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends EncodingProperty> getSubtypeOf(JsonNode json) {
		return EncodingProperty.class;
	}
}
