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
import com.reprezen.kaizen.oasparser.model3.Tag;

public class TagImpl extends PropertiesOverlay<Tag> implements Tag {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public TagImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public TagImpl(Tag tag, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(tag, parent, factory, refMgr);
	}

	// Name
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setName(String name) {
		_setScalar("name", name, String.class);
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

	// ExternalDocs
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return _get("externalDocs", ExternalDocs.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return _get("externalDocs", elaborate, ExternalDocs.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		_setScalar("externalDocs", externalDocs, ExternalDocs.class);
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
	public static final String F_name = "name";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_externalDocs = "externalDocs";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Tag> factory = new OverlayFactory<Tag>() {

		@Override
		protected Class<? extends JsonOverlay<? super Tag>> getOverlayClass() {
			return TagImpl.class;
		}

		@Override
		public JsonOverlay<Tag> _create(Tag tag, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new TagImpl(tag, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Tag> castOverlay = (JsonOverlay<Tag>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Tag> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new TagImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Tag> castOverlay = (JsonOverlay<Tag>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Tag> getSubtypeOf(Tag tag) {
		return Tag.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Tag> getSubtypeOf(JsonNode json) {
		return Tag.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<Tag> builder(OV modelMember) {
		return new Builder<Tag>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Tag create(OV modelMember) {
		return (Tag) builder(modelMember).build();
	}
}
