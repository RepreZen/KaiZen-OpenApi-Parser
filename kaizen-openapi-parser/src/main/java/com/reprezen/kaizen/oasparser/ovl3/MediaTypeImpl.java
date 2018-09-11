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
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Schema;

public class MediaTypeImpl extends PropertiesOverlay<MediaType> implements MediaType {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MediaTypeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MediaTypeImpl(MediaType mediaType, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(mediaType, parent, factory, refMgr);
	}

	// Schema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getSchema() {
		return _get("schema", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getSchema(boolean elaborate) {
		return _get("schema", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setSchema(Schema schema) {
		_setScalar("schema", schema, Schema.class);
	}

	// Example
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Example> getExamples() {
		return _getMap("examples", Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Example> getExamples(boolean elaborate) {
		return _getMap("examples", elaborate, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExamples() {
		return _isPresent("examples");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return _getMap("examples", Example.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Example getExample(String name) {
		return _get("examples", name, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExamples(Map<String, Example> examples) {
		_setMap("examples", examples, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		_set("examples", name, example, Example.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExample(String name) {
		_remove("examples", name, Example.class);
	}

	// Example
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExample() {
		return _get("example", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExample(Object example) {
		_setScalar("example", example, Object.class);
	}

	// EncodingProperty
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, EncodingProperty> getEncodingProperties() {
		return _getMap("encodingProperties", EncodingProperty.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, EncodingProperty> getEncodingProperties(boolean elaborate) {
		return _getMap("encodingProperties", elaborate, EncodingProperty.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasEncodingProperties() {
		return _isPresent("encodingProperties");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasEncodingProperty(String name) {
		return _getMap("encodingProperties", EncodingProperty.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public EncodingProperty getEncodingProperty(String name) {
		return _get("encodingProperties", name, EncodingProperty.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEncodingProperties(Map<String, EncodingProperty> encodingProperties) {
		_setMap("encodingProperties", encodingProperties, EncodingProperty.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEncodingProperty(String name, EncodingProperty encodingProperty) {
		_set("encodingProperties", name, encodingProperty, EncodingProperty.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeEncodingProperty(String name) {
		_remove("encodingProperties", name, EncodingProperty.class);
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
	public static final String F_schema = "schema";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_examples = "examples";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_example = "example";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_encodingProperties = "encodingProperties";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("schema", "schema", SchemaImpl.factory);
		_createMap("examples", "examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createScalar("example", "example", ObjectOverlay.factory);
		_createMap("encodingProperties", "encoding", EncodingPropertyImpl.factory, null);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<MediaType> factory = new OverlayFactory<MediaType>() {

		@Override
		protected Class<? extends JsonOverlay<? super MediaType>> getOverlayClass() {
			return MediaTypeImpl.class;
		}

		@Override
		public JsonOverlay<MediaType> _create(MediaType mediaType, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new MediaTypeImpl(mediaType, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<MediaType> castOverlay = (JsonOverlay<MediaType>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<MediaType> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new MediaTypeImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<MediaType> castOverlay = (JsonOverlay<MediaType>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends MediaType> getSubtypeOf(MediaType mediaType) {
		return MediaType.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends MediaType> getSubtypeOf(JsonNode json) {
		return MediaType.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<MediaType> builder(OV modelMember) {
		return new Builder<MediaType>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> MediaType create(OV modelMember) {
		return (MediaType) builder(modelMember).build();
	}
}
