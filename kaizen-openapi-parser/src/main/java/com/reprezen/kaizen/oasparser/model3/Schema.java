package com.reprezen.kaizen.oasparser.model3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.IModelPart;

public interface Schema extends IJsonOverlay<Schema>, IModelPart<OpenApi3, Schema> {

	String getName();

	// Title
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getTitle();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setTitle(String title);

	// MultipleOf
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Number getMultipleOf();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMultipleOf(Number multipleOf);

	// Maximum
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Number getMaximum();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMaximum(Number maximum);

	// ExclusiveMaximum
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getExclusiveMaximum();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isExclusiveMaximum();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExclusiveMaximum(Boolean exclusiveMaximum);

	// Minimum
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Number getMinimum();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMinimum(Number minimum);

	// ExclusiveMinimum
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getExclusiveMinimum();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isExclusiveMinimum();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExclusiveMinimum(Boolean exclusiveMinimum);

	// MaxLength
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Integer getMaxLength();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMaxLength(Integer maxLength);

	// MinLength
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Integer getMinLength();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMinLength(Integer minLength);

	// Pattern
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getPattern();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setPattern(String pattern);

	// MaxItems
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Integer getMaxItems();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMaxItems(Integer maxItems);

	// MinItems
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Integer getMinItems();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMinItems(Integer minItems);

	// UniqueItems
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getUniqueItems();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isUniqueItems();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setUniqueItems(Boolean uniqueItems);

	// MaxProperties
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Integer getMaxProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMaxProperties(Integer maxProperties);

	// MinProperties
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Integer getMinProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMinProperties(Integer minProperties);

	// RequiredField
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Collection<String> getRequiredFields();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasRequiredFields();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getRequiredField(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequiredFields(Collection<String> requiredFields);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setRequiredField(int index, String requiredField);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addRequiredField(String requiredField);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertRequiredField(int index, String requiredField);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeRequiredField(int index);

	// Enum
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Collection<Object> getEnums();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasEnums();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getEnum(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setEnums(Collection<Object> enums);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setEnum(int index, Object enumValue);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addEnum(Object enumValue);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertEnum(int index, Object enumValue);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeEnum(int index);

	// Type
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getType();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setType(String type);

	// AllOfSchema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Collection<Schema> getAllOfSchemas();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasAllOfSchemas();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getAllOfSchema(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAllOfSchemas(Collection<Schema> allOfSchemas);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAllOfSchema(int index, Schema allOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addAllOfSchema(Schema allOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertAllOfSchema(int index, Schema allOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeAllOfSchema(int index);

	// OneOfSchema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Collection<Schema> getOneOfSchemas();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasOneOfSchemas();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getOneOfSchema(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setOneOfSchemas(Collection<Schema> oneOfSchemas);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setOneOfSchema(int index, Schema oneOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addOneOfSchema(Schema oneOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertOneOfSchema(int index, Schema oneOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeOneOfSchema(int index);

	// AnyOfSchema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Collection<Schema> getAnyOfSchemas();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasAnyOfSchemas();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getAnyOfSchema(int index);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAnyOfSchemas(Collection<Schema> anyOfSchemas);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAnyOfSchema(int index, Schema anyOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void addAnyOfSchema(Schema anyOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void insertAnyOfSchema(int index, Schema anyOfSchema);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeAnyOfSchema(int index);

	// NotSchema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getNotSchema();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getNotSchema(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setNotSchema(Schema notSchema);

	// ItemsSchema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getItemsSchema();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getItemsSchema(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setItemsSchema(Schema itemsSchema);

	// Property
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Schema> getProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasProperty(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getProperty(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setProperties(Map<String, Schema> properties);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setProperty(String name, Schema property);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeProperty(String name);

	// AdditionalPropertiesSchema
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getAdditionalPropertiesSchema();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Schema getAdditionalPropertiesSchema(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema);

	// AdditionalProperties
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getAdditionalProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isAdditionalProperties();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setAdditionalProperties(Boolean additionalProperties);

	// Description
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getDescription();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDescription(String description);

	// Format
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getFormat();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setFormat(String format);

	// Default
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getDefault();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDefault(Object defaultValue);

	// Nullable
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getNullable();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isNullable();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setNullable(Boolean nullable);

	// Discriminator
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	String getDiscriminator();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDiscriminator(String discriminator);

	// ReadOnly
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getReadOnly();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isReadOnly();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setReadOnly(Boolean readOnly);

	// WriteOnly
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getWriteOnly();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isWriteOnly();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setWriteOnly(Boolean writeOnly);

	// Xml
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Xml getXml();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Xml getXml(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setXml(Xml xml);

	// ExternalDocs
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	ExternalDocs getExternalDocs();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	ExternalDocs getExternalDocs(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExternalDocs(ExternalDocs externalDocs);

	// Example
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Example> getExamples();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExample(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Example getExample(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExamples(Map<String, Example> examples);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExample(String name, Example example);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeExample(String name);

	// Example
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getExample();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExample(Object example);

	// Deprecated
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Boolean getDeprecated();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean isDeprecated();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setDeprecated(Boolean deprecated);

	// Extension
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Map<String, Object> getExtensions();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	boolean hasExtension(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	Object getExtension(String name);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExtensions(Map<String, Object> extensions);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setExtension(String name, Object extension);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void removeExtension(String name);
}
