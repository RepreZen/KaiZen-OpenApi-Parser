package com.reprezen.kaizen.oasparser.ovl3;

import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.IntegerOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.NumberOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Discriminator;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Xml;

public class SchemaImpl extends PropertiesOverlay<Schema> implements Schema {

	private Overlay<Schema> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Override
	public JsonOverlay<?> _findInternal(JsonPointer path) {
		if (path.matchesProperty("additionalProperties")) {
			return path.tail().matches() ? _getOverlay("additionalProperties", BooleanOverlay.class)
					: _get("additionalPropertiesSchema", SchemaImpl.class)._findInternal(path.tail());
		} else {
			return super._findInternal(path);
		}
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public SchemaImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public SchemaImpl(Schema schema, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(schema, parent, factory, refMgr);
	}

	// Title
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getTitle() {
		return _get("title", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTitle(String title) {
		_setScalar("title", title, String.class);
	}

	// MultipleOf
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Number getMultipleOf() {
		return _get("multipleOf", Number.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMultipleOf(Number multipleOf) {
		_setScalar("multipleOf", multipleOf, Number.class);
	}

	// Maximum
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Number getMaximum() {
		return _get("maximum", Number.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMaximum(Number maximum) {
		_setScalar("maximum", maximum, Number.class);
	}

	// ExclusiveMaximum
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getExclusiveMaximum() {
		return _get("exclusiveMaximum", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isExclusiveMaximum() {
		Boolean bool = _get("exclusiveMaximum", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExclusiveMaximum(Boolean exclusiveMaximum) {
		_setScalar("exclusiveMaximum", exclusiveMaximum, Boolean.class);
	}

	// Minimum
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Number getMinimum() {
		return _get("minimum", Number.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMinimum(Number minimum) {
		_setScalar("minimum", minimum, Number.class);
	}

	// ExclusiveMinimum
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getExclusiveMinimum() {
		return _get("exclusiveMinimum", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isExclusiveMinimum() {
		Boolean bool = _get("exclusiveMinimum", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExclusiveMinimum(Boolean exclusiveMinimum) {
		_setScalar("exclusiveMinimum", exclusiveMinimum, Boolean.class);
	}

	// MaxLength
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Integer getMaxLength() {
		return _get("maxLength", Integer.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMaxLength(Integer maxLength) {
		_setScalar("maxLength", maxLength, Integer.class);
	}

	// MinLength
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Integer getMinLength() {
		return _get("minLength", Integer.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMinLength(Integer minLength) {
		_setScalar("minLength", minLength, Integer.class);
	}

	// Pattern
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getPattern() {
		return _get("pattern", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPattern(String pattern) {
		_setScalar("pattern", pattern, String.class);
	}

	// MaxItems
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Integer getMaxItems() {
		return _get("maxItems", Integer.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMaxItems(Integer maxItems) {
		_setScalar("maxItems", maxItems, Integer.class);
	}

	// MinItems
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Integer getMinItems() {
		return _get("minItems", Integer.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMinItems(Integer minItems) {
		_setScalar("minItems", minItems, Integer.class);
	}

	// UniqueItems
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getUniqueItems() {
		return _get("uniqueItems", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isUniqueItems() {
		Boolean bool = _get("uniqueItems", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setUniqueItems(Boolean uniqueItems) {
		_setScalar("uniqueItems", uniqueItems, Boolean.class);
	}

	// MaxProperties
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Integer getMaxProperties() {
		return _get("maxProperties", Integer.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMaxProperties(Integer maxProperties) {
		_setScalar("maxProperties", maxProperties, Integer.class);
	}

	// MinProperties
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Integer getMinProperties() {
		return _get("minProperties", Integer.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMinProperties(Integer minProperties) {
		_setScalar("minProperties", minProperties, Integer.class);
	}

	// RequiredField
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<String> getRequiredFields() {
		return _getList("requiredFields", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<String> getRequiredFields(boolean elaborate) {
		return _getList("requiredFields", elaborate, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasRequiredFields() {
		return _isPresent("requiredFields");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getRequiredField(int index) {
		return _get("requiredFields", index, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequiredFields(List<String> requiredFields) {
		_setList("requiredFields", requiredFields, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequiredField(int index, String requiredField) {
		_set("requiredFields", index, requiredField, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addRequiredField(String requiredField) {
		_add("requiredFields", requiredField, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertRequiredField(int index, String requiredField) {
		_insert("requiredFields", index, requiredField, String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeRequiredField(int index) {
		_remove("requiredFields", index, String.class);
	}

	// Enum
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Object> getEnums() {
		return _getList("enums", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Object> getEnums(boolean elaborate) {
		return _getList("enums", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasEnums() {
		return _isPresent("enums");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getEnum(int index) {
		return _get("enums", index, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEnums(List<Object> enums) {
		_setList("enums", enums, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEnum(int index, Object enumValue) {
		_set("enums", index, enumValue, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addEnum(Object enumValue) {
		_add("enums", enumValue, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertEnum(int index, Object enumValue) {
		_insert("enums", index, enumValue, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeEnum(int index) {
		_remove("enums", index, Object.class);
	}

	// Type
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getType() {
		return _get("type", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setType(String type) {
		_setScalar("type", type, String.class);
	}

	// AllOfSchema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Schema> getAllOfSchemas() {
		return _getList("allOfSchemas", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Schema> getAllOfSchemas(boolean elaborate) {
		return _getList("allOfSchemas", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasAllOfSchemas() {
		return _isPresent("allOfSchemas");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getAllOfSchema(int index) {
		return _get("allOfSchemas", index, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAllOfSchemas(List<Schema> allOfSchemas) {
		_setList("allOfSchemas", allOfSchemas, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAllOfSchema(int index, Schema allOfSchema) {
		_set("allOfSchemas", index, allOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addAllOfSchema(Schema allOfSchema) {
		_add("allOfSchemas", allOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertAllOfSchema(int index, Schema allOfSchema) {
		_insert("allOfSchemas", index, allOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeAllOfSchema(int index) {
		_remove("allOfSchemas", index, Schema.class);
	}

	// OneOfSchema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Schema> getOneOfSchemas() {
		return _getList("oneOfSchemas", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Schema> getOneOfSchemas(boolean elaborate) {
		return _getList("oneOfSchemas", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasOneOfSchemas() {
		return _isPresent("oneOfSchemas");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getOneOfSchema(int index) {
		return _get("oneOfSchemas", index, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOneOfSchemas(List<Schema> oneOfSchemas) {
		_setList("oneOfSchemas", oneOfSchemas, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setOneOfSchema(int index, Schema oneOfSchema) {
		_set("oneOfSchemas", index, oneOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addOneOfSchema(Schema oneOfSchema) {
		_add("oneOfSchemas", oneOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertOneOfSchema(int index, Schema oneOfSchema) {
		_insert("oneOfSchemas", index, oneOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeOneOfSchema(int index) {
		_remove("oneOfSchemas", index, Schema.class);
	}

	// AnyOfSchema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Schema> getAnyOfSchemas() {
		return _getList("anyOfSchemas", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<Schema> getAnyOfSchemas(boolean elaborate) {
		return _getList("anyOfSchemas", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasAnyOfSchemas() {
		return _isPresent("anyOfSchemas");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getAnyOfSchema(int index) {
		return _get("anyOfSchemas", index, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAnyOfSchemas(List<Schema> anyOfSchemas) {
		_setList("anyOfSchemas", anyOfSchemas, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAnyOfSchema(int index, Schema anyOfSchema) {
		_set("anyOfSchemas", index, anyOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addAnyOfSchema(Schema anyOfSchema) {
		_add("anyOfSchemas", anyOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertAnyOfSchema(int index, Schema anyOfSchema) {
		_insert("anyOfSchemas", index, anyOfSchema, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeAnyOfSchema(int index) {
		_remove("anyOfSchemas", index, Schema.class);
	}

	// NotSchema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getNotSchema() {
		return _get("notSchema", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getNotSchema(boolean elaborate) {
		return _get("notSchema", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setNotSchema(Schema notSchema) {
		_setScalar("notSchema", notSchema, Schema.class);
	}

	// ItemsSchema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getItemsSchema() {
		return _get("itemsSchema", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getItemsSchema(boolean elaborate) {
		return _get("itemsSchema", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setItemsSchema(Schema itemsSchema) {
		_setScalar("itemsSchema", itemsSchema, Schema.class);
	}

	// Property
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Schema> getProperties() {
		return _getMap("properties", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Schema> getProperties(boolean elaborate) {
		return _getMap("properties", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasProperties() {
		return _isPresent("properties");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasProperty(String name) {
		return _getMap("properties", Schema.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getProperty(String name) {
		return _get("properties", name, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setProperties(Map<String, Schema> properties) {
		_setMap("properties", properties, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setProperty(String name, Schema property) {
		_set("properties", name, property, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeProperty(String name) {
		_remove("properties", name, Schema.class);
	}

	// AdditionalPropertiesSchema
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getAdditionalPropertiesSchema() {
		return _get("additionalPropertiesSchema", Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Schema getAdditionalPropertiesSchema(boolean elaborate) {
		return _get("additionalPropertiesSchema", elaborate, Schema.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
		_setScalar("additionalPropertiesSchema", additionalPropertiesSchema, Schema.class);
	}

	// AdditionalProperties
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAdditionalProperties() {
		return _get("additionalProperties", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAdditionalProperties() {
		Boolean bool = _get("additionalProperties", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAdditionalProperties(Boolean additionalProperties) {
		_setScalar("additionalProperties", additionalProperties, Boolean.class);
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

	// Format
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getFormat() {
		return _get("format", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setFormat(String format) {
		_setScalar("format", format, String.class);
	}

	// Default
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getDefault() {
		return _get("defaultValue", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDefault(Object defaultValue) {
		_setScalar("defaultValue", defaultValue, Object.class);
	}

	// Nullable
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getNullable() {
		return _get("nullable", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isNullable() {
		Boolean bool = _get("nullable", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setNullable(Boolean nullable) {
		_setScalar("nullable", nullable, Boolean.class);
	}

	// Discriminator
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Discriminator getDiscriminator() {
		return _get("discriminator", Discriminator.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Discriminator getDiscriminator(boolean elaborate) {
		return _get("discriminator", elaborate, Discriminator.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDiscriminator(Discriminator discriminator) {
		_setScalar("discriminator", discriminator, Discriminator.class);
	}

	// ReadOnly
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getReadOnly() {
		return _get("readOnly", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isReadOnly() {
		Boolean bool = _get("readOnly", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setReadOnly(Boolean readOnly) {
		_setScalar("readOnly", readOnly, Boolean.class);
	}

	// WriteOnly
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getWriteOnly() {
		return _get("writeOnly", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isWriteOnly() {
		Boolean bool = _get("writeOnly", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setWriteOnly(Boolean writeOnly) {
		_setScalar("writeOnly", writeOnly, Boolean.class);
	}

	// Xml
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Xml getXml() {
		return _get("xml", Xml.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Xml getXml(boolean elaborate) {
		return _get("xml", elaborate, Xml.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setXml(Xml xml) {
		_setScalar("xml", xml, Xml.class);
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
	public static final String F_title = "title";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_multipleOf = "multipleOf";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_maximum = "maximum";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_exclusiveMaximum = "exclusiveMaximum";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_minimum = "minimum";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_exclusiveMinimum = "exclusiveMinimum";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_maxLength = "maxLength";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_minLength = "minLength";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_pattern = "pattern";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_maxItems = "maxItems";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_minItems = "minItems";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_uniqueItems = "uniqueItems";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_maxProperties = "maxProperties";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_minProperties = "minProperties";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_requiredFields = "requiredFields";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_enums = "enums";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_type = "type";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_allOfSchemas = "allOfSchemas";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_oneOfSchemas = "oneOfSchemas";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_anyOfSchemas = "anyOfSchemas";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_notSchema = "notSchema";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_itemsSchema = "itemsSchema";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_properties = "properties";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_additionalPropertiesSchema = "additionalPropertiesSchema";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_additionalProperties = "additionalProperties";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_description = "description";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_format = "format";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_defaultValue = "defaultValue";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_nullable = "nullable";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_discriminator = "discriminator";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_readOnly = "readOnly";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_writeOnly = "writeOnly";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_xml = "xml";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_externalDocs = "externalDocs";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_example = "example";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_deprecated = "deprecated";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("title", "title", StringOverlay.factory);
		_createScalar("multipleOf", "multipleOf", NumberOverlay.factory);
		_createScalar("maximum", "maximum", NumberOverlay.factory);
		_createScalar("exclusiveMaximum", "exclusiveMaximum", BooleanOverlay.factory);
		_createScalar("minimum", "minimum", NumberOverlay.factory);
		_createScalar("exclusiveMinimum", "exclusiveMinimum", BooleanOverlay.factory);
		_createScalar("maxLength", "maxLength", IntegerOverlay.factory);
		_createScalar("minLength", "minLength", IntegerOverlay.factory);
		_createScalar("pattern", "pattern", StringOverlay.factory);
		_createScalar("maxItems", "maxItems", IntegerOverlay.factory);
		_createScalar("minItems", "minItems", IntegerOverlay.factory);
		_createScalar("uniqueItems", "uniqueItems", BooleanOverlay.factory);
		_createScalar("maxProperties", "maxProperties", IntegerOverlay.factory);
		_createScalar("minProperties", "minProperties", IntegerOverlay.factory);
		_createList("requiredFields", "required", StringOverlay.factory);
		_createList("enums", "enum", ObjectOverlay.factory);
		_createScalar("type", "type", StringOverlay.factory);
		_createList("allOfSchemas", "allOf", SchemaImpl.factory);
		_createList("oneOfSchemas", "oneOf", SchemaImpl.factory);
		_createList("anyOfSchemas", "anyOf", SchemaImpl.factory);
		_createScalar("notSchema", "not", SchemaImpl.factory);
		_createScalar("itemsSchema", "items", SchemaImpl.factory);
		_createMap("properties", "properties", SchemaImpl.factory, null);
		_createScalar("additionalPropertiesSchema", "additionalProperties", SchemaImpl.factory);
		_createScalar("additionalProperties", "additionalProperties", BooleanOverlay.factory);
		_createScalar("description", "description", StringOverlay.factory);
		_createScalar("format", "format", StringOverlay.factory);
		_createScalar("defaultValue", "default", ObjectOverlay.factory);
		_createScalar("nullable", "nullable", BooleanOverlay.factory);
		_createScalar("discriminator", "discriminator", DiscriminatorImpl.factory);
		_createScalar("readOnly", "readOnly", BooleanOverlay.factory);
		_createScalar("writeOnly", "writeOnly", BooleanOverlay.factory);
		_createScalar("xml", "xml", XmlImpl.factory);
		_createScalar("externalDocs", "externalDocs", ExternalDocsImpl.factory);
		_createScalar("example", "example", ObjectOverlay.factory);
		_createScalar("deprecated", "deprecated", BooleanOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Schema> factory = new OverlayFactory<Schema>() {

		@Override
		protected Class<? extends JsonOverlay<? super Schema>> getOverlayClass() {
			return SchemaImpl.class;
		}

		@Override
		public JsonOverlay<Schema> _create(Schema schema, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SchemaImpl(schema, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Schema> castOverlay = (JsonOverlay<Schema>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Schema> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new SchemaImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Schema> castOverlay = (JsonOverlay<Schema>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Schema> getSubtypeOf(Schema schema) {
		return Schema.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Schema> getSubtypeOf(JsonNode json) {
		return Schema.class;
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
	public static <OV extends IJsonOverlay<?>> Builder<Schema> builder(OV modelMember) {
		return new Builder<Schema>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Schema create(OV modelMember) {
		return (Schema) builder(modelMember).build();
	}
}
