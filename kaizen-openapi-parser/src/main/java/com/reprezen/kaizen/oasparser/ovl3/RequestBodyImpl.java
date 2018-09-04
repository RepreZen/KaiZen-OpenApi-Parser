package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.RequestBody;

public class RequestBodyImpl extends PropertiesOverlay<RequestBody> implements RequestBody {

	private Overlay<RequestBody> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBodyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public RequestBodyImpl(RequestBody requestBody, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(requestBody, parent, factory, refMgr);
	}

	// Description
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return _get("description", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		_setScalar("description", description, String.class);
	}

	// ContentMediaType
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, MediaType> getContentMediaTypes() {
		return _getMap("contentMediaTypes", MediaType.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, MediaType> getContentMediaTypes(boolean elaborate) {
		return _getMap("contentMediaTypes", elaborate, MediaType.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasContentMediaTypes() {
		return _isPresent("contentMediaTypes");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasContentMediaType(String name) {
		return _getMap("contentMediaTypes", MediaType.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MediaType getContentMediaType(String name) {
		return _get("contentMediaTypes", name, MediaType.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
		_setMap("contentMediaTypes", contentMediaTypes, MediaType.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaType(String name, MediaType contentMediaType) {
		_set("contentMediaTypes", name, contentMediaType, MediaType.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeContentMediaType(String name) {
		_remove("contentMediaTypes", name, MediaType.class);
	}

	// Required
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getRequired() {
		return _get("required", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isRequired() {
		Boolean bool = _get("required", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequired(Boolean required) {
		_setScalar("required", required, Boolean.class);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_contentMediaTypes = "contentMediaTypes";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_required = "required";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("description", "description", StringOverlay.factory);
		_createMap("contentMediaTypes", "content", MediaTypeImpl.factory, null);
		_createScalar("required", "required", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<RequestBody> factory = new OverlayFactory<RequestBody>() {

		@Override
		protected Class<? extends JsonOverlay<? super RequestBody>> getOverlayClass() {
			return RequestBodyImpl.class;
		}

		@Override
		public JsonOverlay<RequestBody> _create(RequestBody requestBody, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new RequestBodyImpl(requestBody, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<RequestBody> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new RequestBodyImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<RequestBody> castOverlay = (JsonOverlay<RequestBody>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
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

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Builder<RequestBody> builder(OV modelMember) {
		return new Builder<RequestBody>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> RequestBody create(OV modelMember) {
		return (RequestBody) builder(modelMember).build();
	}
}
