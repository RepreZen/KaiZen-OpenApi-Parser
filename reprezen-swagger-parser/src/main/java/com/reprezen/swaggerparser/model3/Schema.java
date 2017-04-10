/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.SwaggerObject;
import com.reprezen.swaggerparser.model3.Xml;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface Schema extends SwaggerObject {

    // Title
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getTitle();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setTitle(String title);

    // MultipleOf
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Number getMultipleOf();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMultipleOf(Number multipleOf);

    // Maximum
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Number getMaximum();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMaximum(Number maximum);

    // ExclusiveMaximum
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getExclusiveMaximum();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isExclusiveMaximum();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExclusiveMaximum(Boolean exclusiveMaximum);

    // Minimum
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Number getMinimum();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMinimum(Number minimum);

    // ExclusiveMinimum
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getExclusiveMinimum();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isExclusiveMinimum();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExclusiveMinimum(Boolean exclusiveMinimum);

    // MaxLength
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Integer getMaxLength();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMaxLength(Integer maxLength);

    // MinLength
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Integer getMinLength();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMinLength(Integer minLength);

    // Pattern
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getPattern();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setPattern(String pattern);

    // MaxItems
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Integer getMaxItems();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMaxItems(Integer maxItems);

    // MinItems
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Integer getMinItems();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMinItems(Integer minItems);

    // UniqueItems
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getUniqueItems();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isUniqueItems();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setUniqueItems(Boolean uniqueItems);

    // MaxProperties
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Integer getMaxProperties();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMaxProperties(Integer maxProperties);

    // MinProperties
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Integer getMinProperties();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setMinProperties(Integer minProperties);

    // RequiredField
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<String> getRequiredFields();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getRequiredField(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setRequiredFields(Collection<String> requiredFields);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setRequiredField(int index, String requiredField);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addRequiredField(String requiredField);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeRequiredField(int index);

    // Enum
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<Object> getEnums();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getEnum(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setEnums(Collection<Object> enums);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setEnum(int index, Object enumValue);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addEnum(Object enumValue);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeEnum(int index);

    // Type
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getType();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setType(String type);

    // AllOfSchemas
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<? extends Schema> getAllOfSchemass();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getAllOfSchemas(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAllOfSchemass(Collection<? extends Schema> allOfSchemass);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAllOfSchemas(int index, Schema allOfSchemas);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addAllOfSchemas(Schema allOfSchemas);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeAllOfSchemas(int index);

    // OneOfSchemas
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<? extends Schema> getOneOfSchemass();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getOneOfSchemas(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setOneOfSchemass(Collection<? extends Schema> oneOfSchemass);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setOneOfSchemas(int index, Schema oneOfSchemas);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addOneOfSchemas(Schema oneOfSchemas);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeOneOfSchemas(int index);

    // AnyOfSchemas
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<? extends Schema> getAnyOfSchemass();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getAnyOfSchemas(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAnyOfSchemass(Collection<? extends Schema> anyOfSchemass);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAnyOfSchemas(int index, Schema anyOfSchemas);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addAnyOfSchemas(Schema anyOfSchemas);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeAnyOfSchemas(int index);

    // NotSchema
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getNotSchema();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setNotSchema(Schema notSchema);

    // ItemsSchema
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getItemsSchema();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setItemsSchema(Schema itemsSchema);

    // Property
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, ? extends Schema> getProperties();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasProperty(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getProperty(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setProperties(Map<String, ? extends Schema> properties);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setProperty(String name, Schema property);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeProperty(String name);

    // AdditionalPropertiesSchema
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getAdditionalPropertiesSchema();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema);

    // AdditionalProperties
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getAdditionalProperties();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isAdditionalProperties();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAdditionalProperties(Boolean additionalProperties);

    // Description
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Format
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getFormat();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setFormat(String format);

    // Default
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getDefault();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDefault(Object defaultValue);

    // Nullable
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getNullable();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isNullable();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setNullable(Boolean nullable);

    // Discriminator
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDiscriminator();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDiscriminator(String discriminator);

    // ReadOnly
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getReadOnly();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isReadOnly();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setReadOnly(Boolean readOnly);

    // WriteOnly
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getWriteOnly();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isWriteOnly();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setWriteOnly(Boolean writeOnly);

    // Xml
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Xml getXml();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setXml(Xml xml);

    // ExternalDocs
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    ExternalDocs getExternalDocs();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExternalDocs(ExternalDocs externalDocs);

    // Example
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<Object> getExamples();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExample(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExamples(Collection<Object> examples);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExample(int index, Object example);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addExample(Object example);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeExample(int index);

    // Example
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExample();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExample(Object example);

    // Deprecated
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getDeprecated();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isDeprecated();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDeprecated(Boolean deprecated);

    // Extension
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);

}
