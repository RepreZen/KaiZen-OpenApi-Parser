package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.RequestBody;

public class RequestBodyImpl extends PropertiesOverlay<RequestBody> implements RequestBody {

	private Overlay<RequestBody> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBodyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBodyImpl(RequestBody requestBody, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(requestBody, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<MediaType> contentMediaTypes;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<Boolean> required;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Description
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// ContentMediaType
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, MediaType> getContentMediaTypes() {
		return contentMediaTypes._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasContentMediaType(String name) {
		return contentMediaTypes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MediaType getContentMediaType(String name) {
		return contentMediaTypes._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
		this.contentMediaTypes._set(contentMediaTypes);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaType(String name, MediaType contentMediaType) {
		contentMediaTypes._set(name, contentMediaType);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeContentMediaType(String name) {
		contentMediaTypes._remove(name);
	}

	// Required
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getRequired() {
		return required._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isRequired() {
		return required._get() != null ? required._get() : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequired(Boolean required) {
		this.required._set(required);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		description = createChild("description", this, StringOverlay.factory);
		contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
		required = createChild("required", this, BooleanOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<RequestBody> factory = new OverlayFactory<RequestBody>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super RequestBody>> getOverlayClass() {
			return RequestBodyImpl.class;
		}

		@Override
		public JsonOverlay<RequestBody> _create(RequestBody requestBody, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new RequestBodyImpl(requestBody, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<RequestBody> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new RequestBodyImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends RequestBody> getSubtypeOf(RequestBody requestBody) {
		return RequestBody.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends RequestBody> getSubtypeOf(JsonNode json) {
		return RequestBody.class;
	}
}
