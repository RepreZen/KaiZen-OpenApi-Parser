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
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Schema;

public class ParameterImpl extends PropertiesOverlay<Parameter> implements Parameter {

	private Overlay<Parameter> overlay = Overlay.of(this);

	@Override
	public String getKey() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ParameterImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ParameterImpl(Parameter parameter, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(parameter, parent, factory, refMgr);
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

	// AllowReserved
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAllowReserved() {
		return _get("allowReserved", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAllowReserved() {
		Boolean bool = _get("allowReserved", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAllowReserved(Boolean allowReserved) {
		_setScalar("allowReserved", allowReserved, Boolean.class);
	}

	// Explode
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getExplode() {
		return _get("explode", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isExplode() {
		Boolean bool = _get("explode", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExplode(Boolean explode) {
		_setScalar("explode", explode, Boolean.class);
	}

	// Style
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getStyle() {
		return _get("style", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setStyle(String style) {
		_setScalar("style", style, String.class);
	}

	// AllowEmptyValue
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAllowEmptyValue() {
		return _get("allowEmptyValue", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAllowEmptyValue() {
		Boolean bool = _get("allowEmptyValue", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAllowEmptyValue(Boolean allowEmptyValue) {
		_setScalar("allowEmptyValue", allowEmptyValue, Boolean.class);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return _get("deprecated", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isDeprecated() {
		Boolean bool = _get("deprecated", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		_setScalar("deprecated", deprecated, Boolean.class);
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

	// In
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getIn() {
		return _get("in", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setIn(String in) {
		_setScalar("in", in, String.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_contentMediaTypes = "contentMediaTypes";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_examples = "examples";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_example = "example";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_schema = "schema";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_allowReserved = "allowReserved";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_explode = "explode";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_style = "style";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_allowEmptyValue = "allowEmptyValue";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_deprecated = "deprecated";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_required = "required";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_name = "name";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_in = "in";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
		_createMap("contentMediaTypes", "content", MediaTypeImpl.factory, null);
		_createMap("examples", "examples", ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		_createScalar("example", "example", ObjectOverlay.factory);
		_createScalar("schema", "schema", SchemaImpl.factory);
		_createScalar("allowReserved", "allowReserved", BooleanOverlay.factory);
		_createScalar("explode", "explode", BooleanOverlay.factory);
		_createScalar("style", "style", StringOverlay.factory);
		_createScalar("allowEmptyValue", "allowEmptyValue", BooleanOverlay.factory);
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createScalar("required", "required", BooleanOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("in", "in", StringOverlay.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Parameter> factory = new OverlayFactory<Parameter>() {

		@Override
		protected Class<? extends JsonOverlay<? super Parameter>> getOverlayClass() {
			return ParameterImpl.class;
		}

		@Override
		public JsonOverlay<Parameter> _create(Parameter parameter, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ParameterImpl(parameter, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Parameter> castOverlay = (JsonOverlay<Parameter>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Parameter> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ParameterImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Parameter> castOverlay = (JsonOverlay<Parameter>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Parameter> getSubtypeOf(Parameter parameter) {
		return Parameter.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Parameter> getSubtypeOf(JsonNode json) {
		return Parameter.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<Parameter> builder(OV modelMember) {
		return new Builder<Parameter>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Parameter create(OV modelMember) {
		return (Parameter) builder(modelMember).build();
	}
}
