package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.ChildListOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.IntegerOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.NumberOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Xml;

public class SchemaImpl extends PropertiesOverlay<Schema> implements Schema {

	@Override
	public AbstractJsonOverlay<?> _findInternal(JsonPointer path) {
		if (path.matchesProperty("additionalProperties")) {
			return path.tail().matches() ? additionalProperties : additionalPropertiesSchema._find(path.tail());
		} else {
			return super._findInternal(path);
		}
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public SchemaImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public SchemaImpl(Schema schema, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(schema, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> title;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Number> multipleOf;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Number> maximum;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> exclusiveMaximum;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Number> minimum;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> exclusiveMinimum;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Integer> maxLength;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Integer> minLength;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> pattern;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Integer> maxItems;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Integer> minItems;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> uniqueItems;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Integer> maxProperties;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Integer> minProperties;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<String> requiredFields;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Object> enums;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> type;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Schema> allOfSchemas;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Schema> oneOfSchemas;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildListOverlay<Schema> anyOfSchemas;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Schema> notSchema;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Schema> itemsSchema;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Schema> properties;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Schema> additionalPropertiesSchema;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> additionalProperties;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> format;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Object> defaultValue;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> nullable;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> discriminator;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> readOnly;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> writeOnly;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Xml> xml;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<ExternalDocs> externalDocs;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Example> examples;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Object> example;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<Boolean> deprecated;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Title
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getTitle() {
		return title._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getTitle(boolean elaborate) {
		return title._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setTitle(String title) {
		this.title._set(title);
	}

	// MultipleOf
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Number getMultipleOf() {
		return multipleOf._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Number getMultipleOf(boolean elaborate) {
		return multipleOf._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMultipleOf(Number multipleOf) {
		this.multipleOf._set(multipleOf);
	}

	// Maximum
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Number getMaximum() {
		return maximum._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Number getMaximum(boolean elaborate) {
		return maximum._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMaximum(Number maximum) {
		this.maximum._set(maximum);
	}

	// ExclusiveMaximum
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExclusiveMaximum() {
		return exclusiveMaximum._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExclusiveMaximum(boolean elaborate) {
		return exclusiveMaximum._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isExclusiveMaximum() {
		return exclusiveMaximum._get() != null ? exclusiveMaximum._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExclusiveMaximum(Boolean exclusiveMaximum) {
		this.exclusiveMaximum._set(exclusiveMaximum);
	}

	// Minimum
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Number getMinimum() {
		return minimum._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Number getMinimum(boolean elaborate) {
		return minimum._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMinimum(Number minimum) {
		this.minimum._set(minimum);
	}

	// ExclusiveMinimum
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExclusiveMinimum() {
		return exclusiveMinimum._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getExclusiveMinimum(boolean elaborate) {
		return exclusiveMinimum._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isExclusiveMinimum() {
		return exclusiveMinimum._get() != null ? exclusiveMinimum._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExclusiveMinimum(Boolean exclusiveMinimum) {
		this.exclusiveMinimum._set(exclusiveMinimum);
	}

	// MaxLength
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMaxLength() {
		return maxLength._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMaxLength(boolean elaborate) {
		return maxLength._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMaxLength(Integer maxLength) {
		this.maxLength._set(maxLength);
	}

	// MinLength
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMinLength() {
		return minLength._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMinLength(boolean elaborate) {
		return minLength._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMinLength(Integer minLength) {
		this.minLength._set(minLength);
	}

	// Pattern
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getPattern() {
		return pattern._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getPattern(boolean elaborate) {
		return pattern._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setPattern(String pattern) {
		this.pattern._set(pattern);
	}

	// MaxItems
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMaxItems() {
		return maxItems._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMaxItems(boolean elaborate) {
		return maxItems._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMaxItems(Integer maxItems) {
		this.maxItems._set(maxItems);
	}

	// MinItems
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMinItems() {
		return minItems._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMinItems(boolean elaborate) {
		return minItems._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMinItems(Integer minItems) {
		this.minItems._set(minItems);
	}

	// UniqueItems
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getUniqueItems() {
		return uniqueItems._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getUniqueItems(boolean elaborate) {
		return uniqueItems._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isUniqueItems() {
		return uniqueItems._get() != null ? uniqueItems._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setUniqueItems(Boolean uniqueItems) {
		this.uniqueItems._set(uniqueItems);
	}

	// MaxProperties
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMaxProperties() {
		return maxProperties._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMaxProperties(boolean elaborate) {
		return maxProperties._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMaxProperties(Integer maxProperties) {
		this.maxProperties._set(maxProperties);
	}

	// MinProperties
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMinProperties() {
		return minProperties._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Integer getMinProperties(boolean elaborate) {
		return minProperties._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setMinProperties(Integer minProperties) {
		this.minProperties._set(minProperties);
	}

	// RequiredField
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<String> getRequiredFields() {
		return requiredFields._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<String> getRequiredFields(boolean elaborate) {
		return requiredFields._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasRequiredFields() {
		return requiredFields._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getRequiredField(int index) {
		return requiredFields._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequiredFields(Collection<String> requiredFields) {
		this.requiredFields._set(requiredFields);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setRequiredField(int index, String requiredField) {
		requiredFields._set(index, requiredField);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addRequiredField(String requiredField) {
		requiredFields._add(requiredField);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertRequiredField(int index, String requiredField) {
		requiredFields._insert(index, requiredField);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeRequiredField(int index) {
		requiredFields._remove(index);
	}

	// Enum
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Object> getEnums() {
		return enums._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Object> getEnums(boolean elaborate) {
		return enums._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasEnums() {
		return enums._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getEnum(int index) {
		return enums._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setEnums(Collection<Object> enums) {
		this.enums._set(enums);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setEnum(int index, Object enumValue) {
		enums._set(index, enumValue);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addEnum(Object enumValue) {
		enums._add(enumValue);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertEnum(int index, Object enumValue) {
		enums._insert(index, enumValue);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeEnum(int index) {
		enums._remove(index);
	}

	// Type
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getType() {
		return type._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getType(boolean elaborate) {
		return type._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setType(String type) {
		this.type._set(type);
	}

	// AllOfSchema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Schema> getAllOfSchemas() {
		return allOfSchemas._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Schema> getAllOfSchemas(boolean elaborate) {
		return allOfSchemas._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasAllOfSchemas() {
		return allOfSchemas._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getAllOfSchema(int index) {
		return allOfSchemas._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAllOfSchemas(Collection<Schema> allOfSchemas) {
		this.allOfSchemas._set(allOfSchemas);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAllOfSchema(int index, Schema allOfSchema) {
		allOfSchemas._set(index, allOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addAllOfSchema(Schema allOfSchema) {
		allOfSchemas._add(allOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertAllOfSchema(int index, Schema allOfSchema) {
		allOfSchemas._insert(index, allOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeAllOfSchema(int index) {
		allOfSchemas._remove(index);
	}

	// OneOfSchema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Schema> getOneOfSchemas() {
		return oneOfSchemas._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Schema> getOneOfSchemas(boolean elaborate) {
		return oneOfSchemas._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasOneOfSchemas() {
		return oneOfSchemas._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getOneOfSchema(int index) {
		return oneOfSchemas._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOneOfSchemas(Collection<Schema> oneOfSchemas) {
		this.oneOfSchemas._set(oneOfSchemas);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setOneOfSchema(int index, Schema oneOfSchema) {
		oneOfSchemas._set(index, oneOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addOneOfSchema(Schema oneOfSchema) {
		oneOfSchemas._add(oneOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertOneOfSchema(int index, Schema oneOfSchema) {
		oneOfSchemas._insert(index, oneOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeOneOfSchema(int index) {
		oneOfSchemas._remove(index);
	}

	// AnyOfSchema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Schema> getAnyOfSchemas() {
		return anyOfSchemas._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Collection<Schema> getAnyOfSchemas(boolean elaborate) {
		return anyOfSchemas._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasAnyOfSchemas() {
		return anyOfSchemas._isPresent();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getAnyOfSchema(int index) {
		return anyOfSchemas._get(index);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAnyOfSchemas(Collection<Schema> anyOfSchemas) {
		this.anyOfSchemas._set(anyOfSchemas);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAnyOfSchema(int index, Schema anyOfSchema) {
		anyOfSchemas._set(index, anyOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void addAnyOfSchema(Schema anyOfSchema) {
		anyOfSchemas._add(anyOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void insertAnyOfSchema(int index, Schema anyOfSchema) {
		anyOfSchemas._insert(index, anyOfSchema);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeAnyOfSchema(int index) {
		anyOfSchemas._remove(index);
	}

	// NotSchema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getNotSchema() {
		return notSchema._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getNotSchema(boolean elaborate) {
		return notSchema._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setNotSchema(Schema notSchema) {
		this.notSchema._set(notSchema);
	}

	// ItemsSchema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getItemsSchema() {
		return itemsSchema._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getItemsSchema(boolean elaborate) {
		return itemsSchema._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setItemsSchema(Schema itemsSchema) {
		this.itemsSchema._set(itemsSchema);
	}

	// Property
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Schema> getProperties() {
		return properties._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Schema> getProperties(boolean elaborate) {
		return properties._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasProperty(String name) {
		return properties.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getProperty(String name) {
		return properties._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setProperties(Map<String, Schema> properties) {
		this.properties._set(properties);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setProperty(String name, Schema property) {
		properties._set(name, property);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeProperty(String name) {
		properties._remove(name);
	}

	// AdditionalPropertiesSchema
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getAdditionalPropertiesSchema() {
		return additionalPropertiesSchema._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Schema getAdditionalPropertiesSchema(boolean elaborate) {
		return additionalPropertiesSchema._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
		this.additionalPropertiesSchema._set(additionalPropertiesSchema);
	}

	// AdditionalProperties
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAdditionalProperties() {
		return additionalProperties._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getAdditionalProperties(boolean elaborate) {
		return additionalProperties._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isAdditionalProperties() {
		return additionalProperties._get() != null ? additionalProperties._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setAdditionalProperties(Boolean additionalProperties) {
		this.additionalProperties._set(additionalProperties);
	}

	// Description
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDescription(boolean elaborate) {
		return description._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// Format
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getFormat() {
		return format._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getFormat(boolean elaborate) {
		return format._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setFormat(String format) {
		this.format._set(format);
	}

	// Default
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getDefault() {
		return defaultValue._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getDefault(boolean elaborate) {
		return defaultValue._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDefault(Object defaultValue) {
		this.defaultValue._set(defaultValue);
	}

	// Nullable
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getNullable() {
		return nullable._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getNullable(boolean elaborate) {
		return nullable._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isNullable() {
		return nullable._get() != null ? nullable._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setNullable(Boolean nullable) {
		this.nullable._set(nullable);
	}

	// Discriminator
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDiscriminator() {
		return discriminator._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getDiscriminator(boolean elaborate) {
		return discriminator._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDiscriminator(String discriminator) {
		this.discriminator._set(discriminator);
	}

	// ReadOnly
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getReadOnly() {
		return readOnly._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getReadOnly(boolean elaborate) {
		return readOnly._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isReadOnly() {
		return readOnly._get() != null ? readOnly._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setReadOnly(Boolean readOnly) {
		this.readOnly._set(readOnly);
	}

	// WriteOnly
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getWriteOnly() {
		return writeOnly._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getWriteOnly(boolean elaborate) {
		return writeOnly._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isWriteOnly() {
		return writeOnly._get() != null ? writeOnly._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setWriteOnly(Boolean writeOnly) {
		this.writeOnly._set(writeOnly);
	}

	// Xml
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Xml getXml() {
		return xml._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Xml getXml(boolean elaborate) {
		return xml._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setXml(Xml xml) {
		this.xml._set(xml);
	}

	// ExternalDocs
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return externalDocs._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public ExternalDocs getExternalDocs(boolean elaborate) {
		return externalDocs._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		this.externalDocs._set(externalDocs);
	}

	// Example
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Example> getExamples() {
		return examples._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Example> getExamples(boolean elaborate) {
		return examples._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExample(String name) {
		return examples.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Example getExample(String name) {
		return examples._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExamples(Map<String, Example> examples) {
		this.examples._set(examples);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExample(String name, Example example) {
		examples._set(name, example);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExample(String name) {
		examples._remove(name);
	}

	// Example
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExample() {
		return example._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExample(boolean elaborate) {
		return example._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExample(Object example) {
		this.example._set(example);
	}

	// Deprecated
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getDeprecated() {
		return deprecated._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Boolean getDeprecated(boolean elaborate) {
		return deprecated._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean isDeprecated() {
		return deprecated._get() != null ? deprecated._get() : false;
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setDeprecated(Boolean deprecated) {
		this.deprecated._set(deprecated);
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
		title = createChild("title", this, StringOverlay.factory);
		multipleOf = createChild("multipleOf", this, NumberOverlay.factory);
		maximum = createChild("maximum", this, NumberOverlay.factory);
		exclusiveMaximum = createChild("exclusiveMaximum", this, BooleanOverlay.factory);
		minimum = createChild("minimum", this, NumberOverlay.factory);
		exclusiveMinimum = createChild("exclusiveMinimum", this, BooleanOverlay.factory);
		maxLength = createChild("maxLength", this, IntegerOverlay.factory);
		minLength = createChild("minLength", this, IntegerOverlay.factory);
		pattern = createChild("pattern", this, StringOverlay.factory);
		maxItems = createChild("maxItems", this, IntegerOverlay.factory);
		minItems = createChild("minItems", this, IntegerOverlay.factory);
		uniqueItems = createChild("uniqueItems", this, BooleanOverlay.factory);
		maxProperties = createChild("maxProperties", this, IntegerOverlay.factory);
		minProperties = createChild("minProperties", this, IntegerOverlay.factory);
		requiredFields = createChildList("required", this, StringOverlay.factory);
		enums = createChildList("enum", this, ObjectOverlay.factory);
		type = createChild("type", this, StringOverlay.factory);
		allOfSchemas = createChildList("allOf", this, SchemaImpl.factory);
		oneOfSchemas = createChildList("oneOf", this, SchemaImpl.factory);
		anyOfSchemas = createChildList("anyOf", this, SchemaImpl.factory);
		notSchema = createChild("not", this, SchemaImpl.factory);
		itemsSchema = createChild("items", this, SchemaImpl.factory);
		properties = createChildMap("properties", this, SchemaImpl.factory, null);
		additionalPropertiesSchema = createChild(json.at("/additionalProperties").isObject(), "additionalProperties",
				this, SchemaImpl.factory);
		additionalProperties = createChild(json.at("/additionalProperties").isBoolean(), "additionalProperties", this,
				BooleanOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		format = createChild("format", this, StringOverlay.factory);
		defaultValue = createChild("default", this, ObjectOverlay.factory);
		nullable = createChild("nullable", this, BooleanOverlay.factory);
		discriminator = createChild("discriminator", this, StringOverlay.factory);
		readOnly = createChild("readOnly", this, BooleanOverlay.factory);
		writeOnly = createChild("writeOnly", this, BooleanOverlay.factory);
		xml = createChild("xml", this, XmlImpl.factory);
		externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
		examples = createChildMap("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
		example = createChild("example", this, ObjectOverlay.factory);
		deprecated = createChild("deprecated", this, BooleanOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<Schema> factory = new OverlayFactory<Schema>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Schema>> getOverlayClass() {
			return SchemaImpl.class;
		}

		@Override
		public JsonOverlay<Schema> _create(Schema schema, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new SchemaImpl(schema, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Schema> castOverlay = (JsonOverlay<Schema>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Schema> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new SchemaImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Schema> castOverlay = (JsonOverlay<Schema>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Schema> getSubtypeOf(Schema schema) {
		return Schema.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Schema> getSubtypeOf(JsonNode json) {
		return Schema.class;
	}
}
