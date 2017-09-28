package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IntegerOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.NumberOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Xml;

public class SchemaImpl extends OpenApiObjectImpl<Schema, SchemaImpl> implements Schema {

	@Override
	public IJsonOverlay<?> find(JsonPointer path) {
		if (path.matchesProperty("additionalProperties")) {
			return path.tail().matches() ? additionalProperties : additionalPropertiesSchema.find(path.tail());
		} else {
			return super.find(path);
		}
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SchemaImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public SchemaImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay title = new StringOverlay("title", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private NumberOverlay multipleOf = new NumberOverlay("multipleOf", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private NumberOverlay maximum = new NumberOverlay("maximum", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay exclusiveMaximum = new BooleanOverlay("exclusiveMaximum", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private NumberOverlay minimum = new NumberOverlay("minimum", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay exclusiveMinimum = new BooleanOverlay("exclusiveMinimum", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private IntegerOverlay maxLength = new IntegerOverlay("maxLength", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private IntegerOverlay minLength = new IntegerOverlay("minLength", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay pattern = new StringOverlay("pattern", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private IntegerOverlay maxItems = new IntegerOverlay("maxItems", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private IntegerOverlay minItems = new IntegerOverlay("minItems", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay uniqueItems = new BooleanOverlay("uniqueItems", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private IntegerOverlay maxProperties = new IntegerOverlay("maxProperties", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private IntegerOverlay minProperties = new IntegerOverlay("minProperties", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValListOverlay<String, StringOverlay> requiredFields = new ValListOverlay<String, StringOverlay>("required",
			this, StringOverlay.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValListOverlay<Object, AnyObjectOverlay> enums = new ValListOverlay<Object, AnyObjectOverlay>("enum", this,
			AnyObjectOverlay.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay type = new StringOverlay("type", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<SchemaImpl> allOfSchemas = new ListOverlay<SchemaImpl>("allOf", this, SchemaImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<SchemaImpl> oneOfSchemas = new ListOverlay<SchemaImpl>("oneOf", this, SchemaImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ListOverlay<SchemaImpl> anyOfSchemas = new ListOverlay<SchemaImpl>("anyOf", this, SchemaImpl.factory);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private SchemaImpl notSchema = SchemaImpl.factory.create("not", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private SchemaImpl itemsSchema = SchemaImpl.factory.create("items", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<SchemaImpl> properties = new MapOverlay<SchemaImpl>("properties", this, SchemaImpl.factory,
			null);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private SchemaImpl additionalPropertiesSchema = SchemaImpl.factory.create("additionalProperties", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay additionalProperties = new BooleanOverlay("additionalProperties", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay description = new StringOverlay("description", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay format = new StringOverlay("format", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private AnyObjectOverlay defaultValue = new AnyObjectOverlay("default", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay nullable = new BooleanOverlay("nullable", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay discriminator = new StringOverlay("discriminator", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay readOnly = new BooleanOverlay("readOnly", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay writeOnly = new BooleanOverlay("writeOnly", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private XmlImpl xml = XmlImpl.factory.create("xml", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ExternalDocsImpl externalDocs = ExternalDocsImpl.factory.create("externalDocs", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<ExampleImpl> examples = new MapOverlay<ExampleImpl>("examples", this, ExampleImpl.factory,
			"[a-zA-Z0-9\\._-]+");

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private AnyObjectOverlay example = new AnyObjectOverlay("example", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay deprecated = new BooleanOverlay("deprecated", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this,
			AnyObjectOverlay.factory, "x-.+");

	// Title
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getTitle() {
		return title.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setTitle(String title) {
		this.title.set(title);
	}

	// MultipleOf
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Number getMultipleOf() {
		return multipleOf.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMultipleOf(Number multipleOf) {
		this.multipleOf.set(multipleOf);
	}

	// Maximum
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Number getMaximum() {
		return maximum.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMaximum(Number maximum) {
		this.maximum.set(maximum);
	}

	// ExclusiveMaximum
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getExclusiveMaximum() {
		return exclusiveMaximum.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isExclusiveMaximum() {
		return exclusiveMaximum.get() != null ? exclusiveMaximum.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExclusiveMaximum(Boolean exclusiveMaximum) {
		this.exclusiveMaximum.set(exclusiveMaximum);
	}

	// Minimum
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Number getMinimum() {
		return minimum.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMinimum(Number minimum) {
		this.minimum.set(minimum);
	}

	// ExclusiveMinimum
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getExclusiveMinimum() {
		return exclusiveMinimum.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isExclusiveMinimum() {
		return exclusiveMinimum.get() != null ? exclusiveMinimum.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExclusiveMinimum(Boolean exclusiveMinimum) {
		this.exclusiveMinimum.set(exclusiveMinimum);
	}

	// MaxLength
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Integer getMaxLength() {
		return maxLength.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMaxLength(Integer maxLength) {
		this.maxLength.set(maxLength);
	}

	// MinLength
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Integer getMinLength() {
		return minLength.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMinLength(Integer minLength) {
		this.minLength.set(minLength);
	}

	// Pattern
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getPattern() {
		return pattern.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setPattern(String pattern) {
		this.pattern.set(pattern);
	}

	// MaxItems
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Integer getMaxItems() {
		return maxItems.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMaxItems(Integer maxItems) {
		this.maxItems.set(maxItems);
	}

	// MinItems
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Integer getMinItems() {
		return minItems.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMinItems(Integer minItems) {
		this.minItems.set(minItems);
	}

	// UniqueItems
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getUniqueItems() {
		return uniqueItems.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isUniqueItems() {
		return uniqueItems.get() != null ? uniqueItems.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setUniqueItems(Boolean uniqueItems) {
		this.uniqueItems.set(uniqueItems);
	}

	// MaxProperties
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Integer getMaxProperties() {
		return maxProperties.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMaxProperties(Integer maxProperties) {
		this.maxProperties.set(maxProperties);
	}

	// MinProperties
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Integer getMinProperties() {
		return minProperties.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setMinProperties(Integer minProperties) {
		this.minProperties.set(minProperties);
	}

	// RequiredField
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<String> getRequiredFields() {
		return requiredFields.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasRequiredFields() {
		return requiredFields.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getRequiredField(int index) {
		return requiredFields.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequiredFields(Collection<String> requiredFields) {
		this.requiredFields.set((Collection<String>) requiredFields);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequiredField(int index, String requiredField) {
		requiredFields.set(index, requiredField);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addRequiredField(String requiredField) {
		requiredFields.add(requiredField);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeRequiredField(int index) {
		requiredFields.remove(index);
	}

	// Enum
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<Object> getEnums() {
		return enums.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasEnums() {
		return enums.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getEnum(int index) {
		return enums.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setEnums(Collection<Object> enums) {
		this.enums.set((Collection<Object>) enums);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setEnum(int index, Object enumValue) {
		enums.set(index, enumValue);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addEnum(Object enumValue) {
		enums.add(enumValue);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeEnum(int index) {
		enums.remove(index);
	}

	// Type
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getType() {
		return type.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setType(String type) {
		this.type.set(type);
	}

	// AllOfSchema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<? extends Schema> getAllOfSchemas() {
		return allOfSchemas.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasAllOfSchemas() {
		return allOfSchemas.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getAllOfSchema(int index) {
		return allOfSchemas.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAllOfSchemas(Collection<? extends Schema> allOfSchemas) {
		@SuppressWarnings("unchecked")
		Collection<SchemaImpl> implAllOfSchemas = (Collection<SchemaImpl>) allOfSchemas;
		this.allOfSchemas.set(implAllOfSchemas);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAllOfSchema(int index, Schema allOfSchema) {
		allOfSchemas.set(index, (SchemaImpl) allOfSchema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addAllOfSchema(Schema allOfSchema) {
		allOfSchemas.add((SchemaImpl) allOfSchema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeAllOfSchema(int index) {
		allOfSchemas.remove(index);
	}

	// OneOfSchema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<? extends Schema> getOneOfSchemas() {
		return oneOfSchemas.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasOneOfSchemas() {
		return oneOfSchemas.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getOneOfSchema(int index) {
		return oneOfSchemas.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setOneOfSchemas(Collection<? extends Schema> oneOfSchemas) {
		@SuppressWarnings("unchecked")
		Collection<SchemaImpl> implOneOfSchemas = (Collection<SchemaImpl>) oneOfSchemas;
		this.oneOfSchemas.set(implOneOfSchemas);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setOneOfSchema(int index, Schema oneOfSchema) {
		oneOfSchemas.set(index, (SchemaImpl) oneOfSchema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addOneOfSchema(Schema oneOfSchema) {
		oneOfSchemas.add((SchemaImpl) oneOfSchema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeOneOfSchema(int index) {
		oneOfSchemas.remove(index);
	}

	// AnyOfSchema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Collection<? extends Schema> getAnyOfSchemas() {
		return anyOfSchemas.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasAnyOfSchemas() {
		return anyOfSchemas.isPresent();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getAnyOfSchema(int index) {
		return anyOfSchemas.get(index);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAnyOfSchemas(Collection<? extends Schema> anyOfSchemas) {
		@SuppressWarnings("unchecked")
		Collection<SchemaImpl> implAnyOfSchemas = (Collection<SchemaImpl>) anyOfSchemas;
		this.anyOfSchemas.set(implAnyOfSchemas);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAnyOfSchema(int index, Schema anyOfSchema) {
		anyOfSchemas.set(index, (SchemaImpl) anyOfSchema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void addAnyOfSchema(Schema anyOfSchema) {
		anyOfSchemas.add((SchemaImpl) anyOfSchema);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeAnyOfSchema(int index) {
		anyOfSchemas.remove(index);
	}

	// NotSchema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getNotSchema() {
		return notSchema;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setNotSchema(Schema notSchema) {
		this.notSchema.set((SchemaImpl) notSchema);
	}

	// ItemsSchema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getItemsSchema() {
		return itemsSchema;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setItemsSchema(Schema itemsSchema) {
		this.itemsSchema.set((SchemaImpl) itemsSchema);
	}

	// Property
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Schema> getProperties() {
		return properties.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasProperty(String name) {
		return properties.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getProperty(String name) {
		return properties.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setProperties(Map<String, ? extends Schema> properties) {
		@SuppressWarnings("unchecked")
		Map<String, SchemaImpl> implProperties = (Map<String, SchemaImpl>) properties;
		this.properties.set(implProperties);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setProperty(String name, Schema property) {
		properties.set(name, (SchemaImpl) property);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeProperty(String name) {
		properties.remove(name);
	}

	// AdditionalPropertiesSchema
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Schema getAdditionalPropertiesSchema() {
		return additionalPropertiesSchema;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
		this.additionalPropertiesSchema.set((SchemaImpl) additionalPropertiesSchema);
	}

	// AdditionalProperties
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getAdditionalProperties() {
		return additionalProperties.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isAdditionalProperties() {
		return additionalProperties.get() != null ? additionalProperties.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setAdditionalProperties(Boolean additionalProperties) {
		this.additionalProperties.set(additionalProperties);
	}

	// Description
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return description.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description.set(description);
	}

	// Format
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getFormat() {
		return format.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setFormat(String format) {
		this.format.set(format);
	}

	// Default
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getDefault() {
		return defaultValue.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDefault(Object defaultValue) {
		this.defaultValue.set(defaultValue);
	}

	// Nullable
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getNullable() {
		return nullable.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isNullable() {
		return nullable.get() != null ? nullable.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setNullable(Boolean nullable) {
		this.nullable.set(nullable);
	}

	// Discriminator
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getDiscriminator() {
		return discriminator.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDiscriminator(String discriminator) {
		this.discriminator.set(discriminator);
	}

	// ReadOnly
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getReadOnly() {
		return readOnly.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isReadOnly() {
		return readOnly.get() != null ? readOnly.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setReadOnly(Boolean readOnly) {
		this.readOnly.set(readOnly);
	}

	// WriteOnly
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getWriteOnly() {
		return writeOnly.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isWriteOnly() {
		return writeOnly.get() != null ? writeOnly.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setWriteOnly(Boolean writeOnly) {
		this.writeOnly.set(writeOnly);
	}

	// Xml
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Xml getXml() {
		return xml;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setXml(Xml xml) {
		this.xml.set((XmlImpl) xml);
	}

	// ExternalDocs
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return externalDocs;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		this.externalDocs.set((ExternalDocsImpl) externalDocs);
	}

	// Example
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends Example> getExamples() {
		return examples.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return examples.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Example getExample(String name) {
		return examples.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExamples(Map<String, ? extends Example> examples) {
		@SuppressWarnings("unchecked")
		Map<String, ExampleImpl> implExamples = (Map<String, ExampleImpl>) examples;
		this.examples.set(implExamples);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		examples.set(name, (ExampleImpl) example);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeExample(String name) {
		examples.remove(name);
	}

	// Example
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getExample() {
		return example.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExample(Object example) {
		this.example.set(example);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return deprecated.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isDeprecated() {
		return deprecated.get() != null ? deprecated.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		this.deprecated.set(deprecated);
	}

	// Extension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions.set(extensions);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions.set(name, extension);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions.remove(name);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public static JsonOverlayFactory<SchemaImpl> factory = new JsonOverlayFactory<SchemaImpl>() {
		@Override
		public SchemaImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, SchemaImpl.class) ? null : new SchemaImpl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return title;
			}
		};
		accessors.add("title", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return multipleOf;
			}
		};
		accessors.add("multipleOf", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return maximum;
			}
		};
		accessors.add("maximum", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return exclusiveMaximum;
			}
		};
		accessors.add("exclusiveMaximum", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return minimum;
			}
		};
		accessors.add("minimum", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return exclusiveMinimum;
			}
		};
		accessors.add("exclusiveMinimum", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return maxLength;
			}
		};
		accessors.add("maxLength", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return minLength;
			}
		};
		accessors.add("minLength", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return pattern;
			}
		};
		accessors.add("pattern", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return maxItems;
			}
		};
		accessors.add("maxItems", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return minItems;
			}
		};
		accessors.add("minItems", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return uniqueItems;
			}
		};
		accessors.add("uniqueItems", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return maxProperties;
			}
		};
		accessors.add("maxProperties", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return minProperties;
			}
		};
		accessors.add("minProperties", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return requiredFields;
			}
		};
		accessors.add("required", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return enums;
			}
		};
		accessors.add("enum", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return type;
			}
		};
		accessors.add("type", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return allOfSchemas;
			}
		};
		accessors.add("allOf", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return oneOfSchemas;
			}
		};
		accessors.add("oneOf", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return anyOfSchemas;
			}
		};
		accessors.add("anyOf", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return notSchema;
			}
		};
		accessors.add("not", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return itemsSchema;
			}
		};
		accessors.add("items", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return properties;
			}
		};
		accessors.add("properties", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return additionalPropertiesSchema;
			}
		};
		accessors.add("additionalProperties", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return additionalProperties;
			}
		};
		accessors.add("additionalProperties", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return description;
			}
		};
		accessors.add("description", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return format;
			}
		};
		accessors.add("format", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return defaultValue;
			}
		};
		accessors.add("default", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return nullable;
			}
		};
		accessors.add("nullable", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return discriminator;
			}
		};
		accessors.add("discriminator", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return readOnly;
			}
		};
		accessors.add("readOnly", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return writeOnly;
			}
		};
		accessors.add("writeOnly", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return xml;
			}
		};
		accessors.add("xml", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return externalDocs;
			}
		};
		accessors.add("externalDocs", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return examples;
			}
		};
		accessors.add("examples", "[a-zA-Z0-9\\._-]+", getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return example;
			}
		};
		accessors.add("example", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return deprecated;
			}
		};
		accessors.add("deprecated", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
