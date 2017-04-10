/*******************************************************************************
 *  Copyright (c) $(date) ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.impl3;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.ListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.BooleanOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.IntegerOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.NumberOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.StringOverlay;
import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.Xml;

public class SchemaImpl extends SwaggerObjectImpl implements Schema {

    @Override
    public Optional<JsonOverlay<?>> getFieldValue(String path) throws IllegalArgumentException, IllegalAccessException {
        if (path.equals("additionalProperties")) {
            if (additionalPropertiesSchema != null && !additionalPropertiesSchema.isMissing()) {
                return Optional.<JsonOverlay<?>> of(additionalPropertiesSchema);
            } else if (additionalProperties != null && !additionalProperties.isMissing()) {
                return Optional.<JsonOverlay<?>> of(additionalProperties);
            } else {
                return Optional.absent();
            }
        } else {
            return super.getFieldValue(path);
        }
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SchemaImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public SchemaImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay title = registerField("title", "title", null, new StringOverlay("title", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private NumberOverlay multipleOf = registerField("multipleOf", "multipleOf", null,
            new NumberOverlay("multipleOf", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private NumberOverlay maximum = registerField("maximum", "maximum", null, new NumberOverlay("maximum", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay exclusiveMaximum = registerField("exclusiveMaximum", "exclusiveMaximum", null,
            new BooleanOverlay("exclusiveMaximum", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private NumberOverlay minimum = registerField("minimum", "minimum", null, new NumberOverlay("minimum", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay exclusiveMinimum = registerField("exclusiveMinimum", "exclusiveMinimum", null,
            new BooleanOverlay("exclusiveMinimum", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private IntegerOverlay maxLength = registerField("maxLength", "maxLength", null,
            new IntegerOverlay("maxLength", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private IntegerOverlay minLength = registerField("minLength", "minLength", null,
            new IntegerOverlay("minLength", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay pattern = registerField("pattern", "pattern", null, new StringOverlay("pattern", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private IntegerOverlay maxItems = registerField("maxItems", "maxItems", null, new IntegerOverlay("maxItems", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private IntegerOverlay minItems = registerField("minItems", "minItems", null, new IntegerOverlay("minItems", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay uniqueItems = registerField("uniqueItems", "uniqueItems", null,
            new BooleanOverlay("uniqueItems", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private IntegerOverlay maxProperties = registerField("maxProperties", "maxProperties", null,
            new IntegerOverlay("maxProperties", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private IntegerOverlay minProperties = registerField("minProperties", "minProperties", null,
            new IntegerOverlay("minProperties", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValListOverlay<String, StringOverlay> requiredFields = registerField("required", "requiredFields", null,
            new ValListOverlay<String, StringOverlay>("required", this, StringOverlay.factory));;

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValListOverlay<Object, AnyObjectOverlay> enums = registerField("enum", "enums", null,
            new ValListOverlay<Object, AnyObjectOverlay>("enum", this, AnyObjectOverlay.factory));;

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay type = registerField("type", "type", null, new StringOverlay("type", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<SchemaImpl> allOfSchemass = registerField("allOf", "allOfSchemass", null,
            new ListOverlay<SchemaImpl>("allOf", this, SchemaImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<SchemaImpl> oneOfSchemass = registerField("oneOf", "oneOfSchemass", null,
            new ListOverlay<SchemaImpl>("oneOf", this, SchemaImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<SchemaImpl> anyOfSchemass = registerField("anyOf", "anyOfSchemass", null,
            new ListOverlay<SchemaImpl>("anyOf", this, SchemaImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private SchemaImpl notSchema = registerField("not", "notSchema", null, SchemaImpl.factory.create("not", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private SchemaImpl itemsSchema = registerField("items", "itemsSchema", null,
            SchemaImpl.factory.create("items", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<SchemaImpl> properties = registerField("properties", "properties", null,
            new MapOverlay<SchemaImpl>("properties", this, SchemaImpl.factory, null));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private SchemaImpl additionalPropertiesSchema = registerField("additionalProperties", "additionalPropertiesSchema",
            null, SchemaImpl.factory.create("additionalProperties", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay additionalProperties = registerField("additionalProperties", "additionalProperties", null,
            new BooleanOverlay("additionalProperties", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay description = registerField("description", "description", null,
            new StringOverlay("description", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay format = registerField("format", "format", null, new StringOverlay("format", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private AnyObjectOverlay defaultValue = registerField("default", "defaultValue", null,
            new AnyObjectOverlay("default", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay nullable = registerField("nullable", "nullable", null, new BooleanOverlay("nullable", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay discriminator = registerField("discriminator", "discriminator", null,
            new StringOverlay("discriminator", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay readOnly = registerField("readOnly", "readOnly", null, new BooleanOverlay("readOnly", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay writeOnly = registerField("writeOnly", "writeOnly", null,
            new BooleanOverlay("writeOnly", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private XmlImpl xml = registerField("xml", "xml", null, XmlImpl.factory.create("xml", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ExternalDocsImpl externalDocs = registerField("externalDocs", "externalDocs", null,
            ExternalDocsImpl.factory.create("externalDocs", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValListOverlay<Object, AnyObjectOverlay> examples = registerField("examples", "examples", null,
            new ValListOverlay<Object, AnyObjectOverlay>("examples", this, AnyObjectOverlay.factory));;

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private AnyObjectOverlay example = registerField("example", "example", null, new AnyObjectOverlay("example", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay deprecated = registerField("deprecated", "deprecated", null,
            new BooleanOverlay("deprecated", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object, AnyObjectOverlay> extensions = registerField("", "extensions", "x-.*",
            new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.*"));

    // Title
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getTitle() {
        return title.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setTitle(String title) {
        this.title.set(title);
    }

    // MultipleOf
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Number getMultipleOf() {
        return multipleOf.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMultipleOf(Number multipleOf) {
        this.multipleOf.set(multipleOf);
    }

    // Maximum
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Number getMaximum() {
        return maximum.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMaximum(Number maximum) {
        this.maximum.set(maximum);
    }

    // ExclusiveMaximum
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isExclusiveMaximum() {
        return exclusiveMaximum.get() != null ? exclusiveMaximum.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum.set(exclusiveMaximum);
    }

    // Minimum
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Number getMinimum() {
        return minimum.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMinimum(Number minimum) {
        this.minimum.set(minimum);
    }

    // ExclusiveMinimum
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isExclusiveMinimum() {
        return exclusiveMinimum.get() != null ? exclusiveMinimum.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum.set(exclusiveMinimum);
    }

    // MaxLength
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Integer getMaxLength() {
        return maxLength.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMaxLength(Integer maxLength) {
        this.maxLength.set(maxLength);
    }

    // MinLength
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Integer getMinLength() {
        return minLength.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMinLength(Integer minLength) {
        this.minLength.set(minLength);
    }

    // Pattern
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getPattern() {
        return pattern.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setPattern(String pattern) {
        this.pattern.set(pattern);
    }

    // MaxItems
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Integer getMaxItems() {
        return maxItems.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMaxItems(Integer maxItems) {
        this.maxItems.set(maxItems);
    }

    // MinItems
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Integer getMinItems() {
        return minItems.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMinItems(Integer minItems) {
        this.minItems.set(minItems);
    }

    // UniqueItems
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getUniqueItems() {
        return uniqueItems.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isUniqueItems() {
        return uniqueItems.get() != null ? uniqueItems.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems.set(uniqueItems);
    }

    // MaxProperties
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Integer getMaxProperties() {
        return maxProperties.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMaxProperties(Integer maxProperties) {
        this.maxProperties.set(maxProperties);
    }

    // MinProperties
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Integer getMinProperties() {
        return minProperties.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setMinProperties(Integer minProperties) {
        this.minProperties.set(minProperties);
    }

    // RequiredField
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<String> getRequiredFields() {
        return requiredFields.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getRequiredField(int index) {
        return requiredFields.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setRequiredFields(Collection<String> requiredFields) {
        this.requiredFields.set(requiredFields);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setRequiredField(int index, String requiredField) {
        requiredFields.set(index, requiredField);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addRequiredField(String requiredField) {
        requiredFields.add(requiredField);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeRequiredField(int index) {
        requiredFields.remove(index);
    }

    // Enum
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Object> getEnums() {
        return enums.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getEnum(int index) {
        return enums.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setEnums(Collection<Object> enums) {
        this.enums.set(enums);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setEnum(int index, Object enumValue) {
        enums.set(index, enumValue);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addEnum(Object enumValue) {
        enums.add(enumValue);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeEnum(int index) {
        enums.remove(index);
    }

    // Type
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getType() {
        return type.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setType(String type) {
        this.type.set(type);
    }

    // AllOfSchemas
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Schema> getAllOfSchemass() {
        return allOfSchemass.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAllOfSchemas(int index) {
        return allOfSchemass.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAllOfSchemass(Collection<? extends Schema> allOfSchemass) {
        @SuppressWarnings("unchecked")
        Collection<SchemaImpl> implAllOfSchemass = (Collection<SchemaImpl>) allOfSchemass;
        this.allOfSchemass.set(implAllOfSchemass);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAllOfSchemas(int index, Schema allOfSchemas) {
        allOfSchemass.set(index, (SchemaImpl) allOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addAllOfSchemas(Schema allOfSchemas) {
        allOfSchemass.add((SchemaImpl) allOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeAllOfSchemas(int index) {
        allOfSchemass.remove(index);
    }

    // OneOfSchemas
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Schema> getOneOfSchemass() {
        return oneOfSchemass.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getOneOfSchemas(int index) {
        return oneOfSchemass.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOneOfSchemass(Collection<? extends Schema> oneOfSchemass) {
        @SuppressWarnings("unchecked")
        Collection<SchemaImpl> implOneOfSchemass = (Collection<SchemaImpl>) oneOfSchemass;
        this.oneOfSchemass.set(implOneOfSchemass);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOneOfSchemas(int index, Schema oneOfSchemas) {
        oneOfSchemass.set(index, (SchemaImpl) oneOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addOneOfSchemas(Schema oneOfSchemas) {
        oneOfSchemass.add((SchemaImpl) oneOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeOneOfSchemas(int index) {
        oneOfSchemass.remove(index);
    }

    // AnyOfSchemas
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Schema> getAnyOfSchemass() {
        return anyOfSchemass.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAnyOfSchemas(int index) {
        return anyOfSchemass.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAnyOfSchemass(Collection<? extends Schema> anyOfSchemass) {
        @SuppressWarnings("unchecked")
        Collection<SchemaImpl> implAnyOfSchemass = (Collection<SchemaImpl>) anyOfSchemass;
        this.anyOfSchemass.set(implAnyOfSchemass);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAnyOfSchemas(int index, Schema anyOfSchemas) {
        anyOfSchemass.set(index, (SchemaImpl) anyOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addAnyOfSchemas(Schema anyOfSchemas) {
        anyOfSchemass.add((SchemaImpl) anyOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeAnyOfSchemas(int index) {
        anyOfSchemass.remove(index);
    }

    // NotSchema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getNotSchema() {
        return notSchema;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setNotSchema(Schema notSchema) {
        this.notSchema.set((SchemaImpl) notSchema);
    }

    // ItemsSchema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getItemsSchema() {
        return itemsSchema;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setItemsSchema(Schema itemsSchema) {
        this.itemsSchema.set((SchemaImpl) itemsSchema);
    }

    // Property
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends Schema> getProperties() {
        return properties.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasProperty(String name) {
        return properties.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getProperty(String name) {
        return properties.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setProperties(Map<String, ? extends Schema> properties) {
        @SuppressWarnings("unchecked")
        Map<String, SchemaImpl> implProperties = (Map<String, SchemaImpl>) properties;
        this.properties.set(implProperties);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setProperty(String name, Schema property) {
        properties.set(name, (SchemaImpl) property);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeProperty(String name) {
        properties.remove(name);
    }

    // AdditionalPropertiesSchema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAdditionalPropertiesSchema() {
        return additionalPropertiesSchema;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
        this.additionalPropertiesSchema.set((SchemaImpl) additionalPropertiesSchema);
    }

    // AdditionalProperties
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getAdditionalProperties() {
        return additionalProperties.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isAdditionalProperties() {
        return additionalProperties.get() != null ? additionalProperties.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAdditionalProperties(Boolean additionalProperties) {
        this.additionalProperties.set(additionalProperties);
    }

    // Description
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Format
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getFormat() {
        return format.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setFormat(String format) {
        this.format.set(format);
    }

    // Default
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getDefault() {
        return defaultValue.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDefault(Object defaultValue) {
        this.defaultValue.set(defaultValue);
    }

    // Nullable
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getNullable() {
        return nullable.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isNullable() {
        return nullable.get() != null ? nullable.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setNullable(Boolean nullable) {
        this.nullable.set(nullable);
    }

    // Discriminator
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public String getDiscriminator() {
        return discriminator.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDiscriminator(String discriminator) {
        this.discriminator.set(discriminator);
    }

    // ReadOnly
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getReadOnly() {
        return readOnly.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isReadOnly() {
        return readOnly.get() != null ? readOnly.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly.set(readOnly);
    }

    // WriteOnly
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getWriteOnly() {
        return writeOnly.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isWriteOnly() {
        return writeOnly.get() != null ? writeOnly.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setWriteOnly(Boolean writeOnly) {
        this.writeOnly.set(writeOnly);
    }

    // Xml
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Xml getXml() {
        return xml;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setXml(Xml xml) {
        this.xml.set((XmlImpl) xml);
    }

    // ExternalDocs
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public ExternalDocs getExternalDocs() {
        return externalDocs;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs.set((ExternalDocsImpl) externalDocs);
    }

    // Example
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Object> getExamples() {
        return examples.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getExample(int index) {
        return examples.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExamples(Collection<Object> examples) {
        this.examples.set(examples);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExample(int index, Object example) {
        examples.set(index, example);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addExample(Object example) {
        examples.add(example);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeExample(int index) {
        examples.remove(index);
    }

    // Example
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getExample() {
        return example.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExample(Object example) {
        this.example.set(example);
    }

    // Deprecated
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getDeprecated() {
        return deprecated.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean isDeprecated() {
        return deprecated.get() != null ? deprecated.get() : false;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setDeprecated(Boolean deprecated) {
        this.deprecated.set(deprecated);
    }

    // Extension
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public static JsonOverlayFactory<SchemaImpl> factory = new JsonOverlayFactory<SchemaImpl>() {
        @Override
        public SchemaImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
            return isEmptyRecursive(parent, SchemaImpl.class) ? null : new SchemaImpl(key, json, parent);
        }
    };

}
