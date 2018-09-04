package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;

public class ExternalDocsImpl extends PropertiesOverlay<ExternalDocs> implements ExternalDocs {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocsImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocsImpl(ExternalDocs externalDocs, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(externalDocs, parent, factory, refMgr);
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

	// Url
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getUrl() {
		return _get("url", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setUrl(String url) {
		_setScalar("url", url, String.class);
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
	public static final String F_url = "url";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("url", "url", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<ExternalDocs> factory = new OverlayFactory<ExternalDocs>() {

		@Override
		protected Class<? extends JsonOverlay<? super ExternalDocs>> getOverlayClass() {
			return ExternalDocsImpl.class;
		}

		@Override
		public JsonOverlay<ExternalDocs> _create(ExternalDocs externalDocs, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExternalDocsImpl(externalDocs, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExternalDocs> castOverlay = (JsonOverlay<ExternalDocs>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ExternalDocs> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExternalDocsImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExternalDocs> castOverlay = (JsonOverlay<ExternalDocs>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ExternalDocs> getSubtypeOf(ExternalDocs externalDocs) {
		return ExternalDocs.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ExternalDocs> getSubtypeOf(JsonNode json) {
		return ExternalDocs.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<ExternalDocs> builder(OV modelMember) {
		return new Builder<ExternalDocs>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> ExternalDocs create(OV modelMember) {
		return (ExternalDocs) builder(modelMember).build();
	}
}
