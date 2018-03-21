package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.jsonoverlay.IModelPart;
import com.reprezen.kaizen.oasparser.model3.Xml;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.Example;
import java.util.Collection;
import java.util.Map;
import com.reprezen.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;

public interface Schema extends IPropertiesOverlay<Schema>, IModelPart<OpenApi3, Schema> {

    // Title
    @Generated("com.reprezen.gen.CodeGenerator")
    String getTitle();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getTitle(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setTitle(String title);

    // MultipleOf
    @Generated("com.reprezen.gen.CodeGenerator")
    Number getMultipleOf();

    @Generated("com.reprezen.gen.CodeGenerator")
    Number getMultipleOf(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMultipleOf(Number multipleOf);

    // Maximum
    @Generated("com.reprezen.gen.CodeGenerator")
    Number getMaximum();

    @Generated("com.reprezen.gen.CodeGenerator")
    Number getMaximum(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMaximum(Number maximum);

    // ExclusiveMaximum
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getExclusiveMaximum();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getExclusiveMaximum(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isExclusiveMaximum();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExclusiveMaximum(Boolean exclusiveMaximum);

    // Minimum
    @Generated("com.reprezen.gen.CodeGenerator")
    Number getMinimum();

    @Generated("com.reprezen.gen.CodeGenerator")
    Number getMinimum(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMinimum(Number minimum);

    // ExclusiveMinimum
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getExclusiveMinimum();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getExclusiveMinimum(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isExclusiveMinimum();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExclusiveMinimum(Boolean exclusiveMinimum);

    // MaxLength
    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMaxLength();

    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMaxLength(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMaxLength(Integer maxLength);

    // MinLength
    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMinLength();

    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMinLength(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMinLength(Integer minLength);

    // Pattern
    @Generated("com.reprezen.gen.CodeGenerator")
    String getPattern();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getPattern(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setPattern(String pattern);

    // MaxItems
    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMaxItems();

    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMaxItems(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMaxItems(Integer maxItems);

    // MinItems
    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMinItems();

    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMinItems(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMinItems(Integer minItems);

    // UniqueItems
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getUniqueItems();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getUniqueItems(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isUniqueItems();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setUniqueItems(Boolean uniqueItems);

    // MaxProperties
    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMaxProperties();

    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMaxProperties(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMaxProperties(Integer maxProperties);

    // MinProperties
    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMinProperties();

    @Generated("com.reprezen.gen.CodeGenerator")
    Integer getMinProperties(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setMinProperties(Integer minProperties);

    // RequiredField
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<String> getRequiredFields();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<String> getRequiredFields(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasRequiredFields();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getRequiredField(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setRequiredFields(Collection<String> requiredFields);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setRequiredField(int index, String requiredField);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addRequiredField(String requiredField);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertRequiredField(int index, String requiredField);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeRequiredField(int index);

    // Enum
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Object> getEnums();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Object> getEnums(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasEnums();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getEnum(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setEnums(Collection<Object> enums);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setEnum(int index, Object enumValue);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addEnum(Object enumValue);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertEnum(int index, Object enumValue);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeEnum(int index);

    // Type
    @Generated("com.reprezen.gen.CodeGenerator")
    String getType();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getType(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setType(String type);

    // AllOfSchema
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Schema> getAllOfSchemas();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Schema> getAllOfSchemas(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasAllOfSchemas();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getAllOfSchema(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAllOfSchemas(Collection<Schema> allOfSchemas);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAllOfSchema(int index, Schema allOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addAllOfSchema(Schema allOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertAllOfSchema(int index, Schema allOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeAllOfSchema(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAllOfSchemaReference(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getAllOfSchemaReference(int index);

    // OneOfSchema
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Schema> getOneOfSchemas();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Schema> getOneOfSchemas(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasOneOfSchemas();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getOneOfSchema(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOneOfSchemas(Collection<Schema> oneOfSchemas);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOneOfSchema(int index, Schema oneOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addOneOfSchema(Schema oneOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertOneOfSchema(int index, Schema oneOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeOneOfSchema(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isOneOfSchemaReference(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getOneOfSchemaReference(int index);

    // AnyOfSchema
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Schema> getAnyOfSchemas();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<Schema> getAnyOfSchemas(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasAnyOfSchemas();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getAnyOfSchema(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAnyOfSchemas(Collection<Schema> anyOfSchemas);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAnyOfSchema(int index, Schema anyOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addAnyOfSchema(Schema anyOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertAnyOfSchema(int index, Schema anyOfSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeAnyOfSchema(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAnyOfSchemaReference(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getAnyOfSchemaReference(int index);

    // NotSchema
    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getNotSchema();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getNotSchema(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setNotSchema(Schema notSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isNotSchemaReference();

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getNotSchemaReference();

    // ItemsSchema
    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getItemsSchema();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getItemsSchema(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setItemsSchema(Schema itemsSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isItemsSchemaReference();

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getItemsSchemaReference();

    // Property
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Schema> getProperties();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Schema> getProperties(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasProperty(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getProperty(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setProperties(Map<String, Schema> properties);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setProperty(String name, Schema property);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeProperty(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isPropertyReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getPropertyReference(String name);

    // AdditionalPropertiesSchema
    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getAdditionalPropertiesSchema();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getAdditionalPropertiesSchema(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAdditionalPropertiesSchemaReference();

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getAdditionalPropertiesSchemaReference();

    // AdditionalProperties
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAdditionalProperties();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAdditionalProperties(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAdditionalProperties();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAdditionalProperties(Boolean additionalProperties);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // Format
    @Generated("com.reprezen.gen.CodeGenerator")
    String getFormat();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getFormat(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setFormat(String format);

    // Default
    @Generated("com.reprezen.gen.CodeGenerator")
    Object getDefault();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getDefault(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDefault(Object defaultValue);

    // Nullable
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getNullable();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getNullable(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isNullable();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setNullable(Boolean nullable);

    // Discriminator
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDiscriminator();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDiscriminator(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDiscriminator(String discriminator);

    // ReadOnly
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getReadOnly();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getReadOnly(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isReadOnly();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setReadOnly(Boolean readOnly);

    // WriteOnly
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getWriteOnly();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getWriteOnly(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isWriteOnly();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setWriteOnly(Boolean writeOnly);

    // Xml
    @Generated("com.reprezen.gen.CodeGenerator")
    Xml getXml();

    @Generated("com.reprezen.gen.CodeGenerator")
    Xml getXml(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setXml(Xml xml);

    // ExternalDocs
    @Generated("com.reprezen.gen.CodeGenerator")
    ExternalDocs getExternalDocs();

    @Generated("com.reprezen.gen.CodeGenerator")
    ExternalDocs getExternalDocs(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExternalDocs(ExternalDocs externalDocs);

    // Example
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Example> getExamples();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Example> getExamples(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExample(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Example getExample(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExamples(Map<String, Example> examples);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExample(String name, Example example);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExample(String name);

    // Example
    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExample();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExample(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExample(Object example);

    // Deprecated
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getDeprecated();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getDeprecated(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isDeprecated();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDeprecated(Boolean deprecated);

    // Extension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExtension(String name);
}
