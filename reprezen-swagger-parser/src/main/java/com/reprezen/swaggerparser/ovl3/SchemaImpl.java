package com.reprezen.swaggerparser.ovl3;

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
    private ListOverlay<SchemaImpl> allOfSchemas = registerField("allOf", "allOfSchemas", null,
            new ListOverlay<SchemaImpl>("allOf", this, SchemaImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<SchemaImpl> oneOfSchemas = registerField("oneOf", "oneOfSchemas", null,
            new ListOverlay<SchemaImpl>("oneOf", this, SchemaImpl.factory));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ListOverlay<SchemaImpl> anyOfSchemas = registerField("anyOf", "anyOfSchemas", null,
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
    private ValMapOverlay<Object, AnyObjectOverlay> extensions = registerField("", "extensions", "x-.+",
            new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+"));

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
    public boolean hasRequiredFields() {
        return !requiredFields.isMissing();
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
    public boolean hasEnums() {
        return !enums.isMissing();
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

    // AllOfSchema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Schema> getAllOfSchemas() {
        return allOfSchemas.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasAllOfSchemas() {
        return !allOfSchemas.isMissing();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAllOfSchema(int index) {
        return allOfSchemas.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAllOfSchemas(Collection<? extends Schema> allOfSchemas) {
        @SuppressWarnings("unchecked")
        Collection<SchemaImpl> implAllOfSchemas = (Collection<SchemaImpl>) allOfSchemas;
        this.allOfSchemas.set(implAllOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAllOfSchema(int index, Schema allOfSchema) {
        allOfSchemas.set(index, (SchemaImpl) allOfSchema);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addAllOfSchema(Schema allOfSchema) {
        allOfSchemas.add((SchemaImpl) allOfSchema);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeAllOfSchema(int index) {
        allOfSchemas.remove(index);
    }

    // OneOfSchema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Schema> getOneOfSchemas() {
        return oneOfSchemas.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasOneOfSchemas() {
        return !oneOfSchemas.isMissing();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getOneOfSchema(int index) {
        return oneOfSchemas.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOneOfSchemas(Collection<? extends Schema> oneOfSchemas) {
        @SuppressWarnings("unchecked")
        Collection<SchemaImpl> implOneOfSchemas = (Collection<SchemaImpl>) oneOfSchemas;
        this.oneOfSchemas.set(implOneOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setOneOfSchema(int index, Schema oneOfSchema) {
        oneOfSchemas.set(index, (SchemaImpl) oneOfSchema);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addOneOfSchema(Schema oneOfSchema) {
        oneOfSchemas.add((SchemaImpl) oneOfSchema);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeOneOfSchema(int index) {
        oneOfSchemas.remove(index);
    }

    // AnyOfSchema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Collection<? extends Schema> getAnyOfSchemas() {
        return anyOfSchemas.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasAnyOfSchemas() {
        return !anyOfSchemas.isMissing();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAnyOfSchema(int index) {
        return anyOfSchemas.get(index);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAnyOfSchemas(Collection<? extends Schema> anyOfSchemas) {
        @SuppressWarnings("unchecked")
        Collection<SchemaImpl> implAnyOfSchemas = (Collection<SchemaImpl>) anyOfSchemas;
        this.anyOfSchemas.set(implAnyOfSchemas);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setAnyOfSchema(int index, Schema anyOfSchema) {
        anyOfSchemas.set(index, (SchemaImpl) anyOfSchema);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void addAnyOfSchema(Schema anyOfSchema) {
        anyOfSchemas.add((SchemaImpl) anyOfSchema);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeAnyOfSchema(int index) {
        anyOfSchemas.remove(index);
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
    public boolean hasExamples() {
        return !examples.isMissing();
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
