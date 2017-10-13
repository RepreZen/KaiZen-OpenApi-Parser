package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Optional;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IntegerOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ListOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.NumberOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.ovl3.ExampleImpl;
import com.reprezen.kaizen.oasparser.ovl3.ExternalDocsImpl;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import com.reprezen.kaizen.oasparser.ovl3.SchemaImpl;
import com.reprezen.kaizen.oasparser.ovl3.XmlImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class SchemaImpl extends OpenApiObjectImpl<OpenApi3, Schema> implements Schema {

    @Override
    public IJsonOverlay<?> find(JsonPointer path) {
        if (path.matchesProperty("additionalProperties")) {
            return path.tail().matches() ? additionalProperties : additionalPropertiesSchema.find(path.tail());
        } else {
            return super.find(path);
        }
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SchemaImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public SchemaImpl(Schema schema, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(schema, parent, refReg);
            super.maybeElaborateChildrenAtCreation();
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> title = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Number, NumberOverlay> multipleOf = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Number, NumberOverlay> maximum = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> exclusiveMaximum = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Number, NumberOverlay> minimum = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> exclusiveMinimum = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Integer, IntegerOverlay> maxLength = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Integer, IntegerOverlay> minLength = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> pattern = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Integer, IntegerOverlay> maxItems = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Integer, IntegerOverlay> minItems = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> uniqueItems = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Integer, IntegerOverlay> maxProperties = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Integer, IntegerOverlay> minProperties = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<String, StringOverlay> requiredFields = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Object, ObjectOverlay> enums = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> type = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Schema, SchemaImpl> allOfSchemas = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Schema, SchemaImpl> oneOfSchemas = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildListOverlay<Schema, SchemaImpl> anyOfSchemas = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Schema, SchemaImpl> notSchema = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Schema, SchemaImpl> itemsSchema = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Schema, SchemaImpl> properties = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Schema, SchemaImpl> additionalPropertiesSchema = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> additionalProperties = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> description = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> format = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Object, ObjectOverlay> defaultValue = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> nullable = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<String, StringOverlay> discriminator = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> readOnly = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> writeOnly = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Xml, XmlImpl> xml = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<ExternalDocs, ExternalDocsImpl> externalDocs = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Example, ExampleImpl> examples = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Object, ObjectOverlay> example = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildOverlay<Boolean, BooleanOverlay> deprecated = null;

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ChildMapOverlay<Object, ObjectOverlay> extensions = null;

    // Title
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getTitle() {
        return title.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getTitle(boolean elaborate) {
        return title.get(elaborate);
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
    public Number getMultipleOf(boolean elaborate) {
        return multipleOf.get(elaborate);
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
    public Number getMaximum(boolean elaborate) {
        return maximum.get(elaborate);
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
    public Boolean getExclusiveMaximum(boolean elaborate) {
        return exclusiveMaximum.get(elaborate);
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
    public Number getMinimum(boolean elaborate) {
        return minimum.get(elaborate);
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
    public Boolean getExclusiveMinimum(boolean elaborate) {
        return exclusiveMinimum.get(elaborate);
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
    public Integer getMaxLength(boolean elaborate) {
        return maxLength.get(elaborate);
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
    public Integer getMinLength(boolean elaborate) {
        return minLength.get(elaborate);
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
    public String getPattern(boolean elaborate) {
        return pattern.get(elaborate);
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
    public Integer getMaxItems(boolean elaborate) {
        return maxItems.get(elaborate);
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
    public Integer getMinItems(boolean elaborate) {
        return minItems.get(elaborate);
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
    public Boolean getUniqueItems(boolean elaborate) {
        return uniqueItems.get(elaborate);
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
    public Integer getMaxProperties(boolean elaborate) {
        return maxProperties.get(elaborate);
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
    public Integer getMinProperties(boolean elaborate) {
        return minProperties.get(elaborate);
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
    public Collection<String> getRequiredFields(boolean elaborate) {
        return requiredFields.get(elaborate);
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
    public void insertRequiredField(int index, String requiredField) {
        requiredFields.insert(index, requiredField);
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
    public Collection<Object> getEnums(boolean elaborate) {
        return enums.get(elaborate);
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
    public void insertEnum(int index, Object enumValue) {
        enums.insert(index, enumValue);
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
    public String getType(boolean elaborate) {
        return type.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setType(String type) {
        this.type.set(type);
    }

    // AllOfSchema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Schema> getAllOfSchemas() {
        return allOfSchemas.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Schema> getAllOfSchemas(boolean elaborate) {
        return allOfSchemas.get(elaborate);
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
    public void setAllOfSchemas(Collection<Schema> allOfSchemas) {
        this.allOfSchemas.set((Collection<Schema>) allOfSchemas);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAllOfSchema(int index, Schema allOfSchema) {
        allOfSchemas.set(index, allOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void addAllOfSchema(Schema allOfSchema) {
        allOfSchemas.add(allOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void insertAllOfSchema(int index, Schema allOfSchema) {
        allOfSchemas.insert(index, allOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeAllOfSchema(int index) {
        allOfSchemas.remove(index);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isAllOfSchemaReference(int index) {
        return allOfSchemas.getChild(index).isReference();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getAllOfSchemaReference(int index) {
        return allOfSchemas.getChild(index).getReference();
    }

    // OneOfSchema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Schema> getOneOfSchemas() {
        return oneOfSchemas.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Schema> getOneOfSchemas(boolean elaborate) {
        return oneOfSchemas.get(elaborate);
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
    public void setOneOfSchemas(Collection<Schema> oneOfSchemas) {
        this.oneOfSchemas.set((Collection<Schema>) oneOfSchemas);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setOneOfSchema(int index, Schema oneOfSchema) {
        oneOfSchemas.set(index, oneOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void addOneOfSchema(Schema oneOfSchema) {
        oneOfSchemas.add(oneOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void insertOneOfSchema(int index, Schema oneOfSchema) {
        oneOfSchemas.insert(index, oneOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeOneOfSchema(int index) {
        oneOfSchemas.remove(index);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isOneOfSchemaReference(int index) {
        return oneOfSchemas.getChild(index).isReference();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getOneOfSchemaReference(int index) {
        return oneOfSchemas.getChild(index).getReference();
    }

    // AnyOfSchema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Schema> getAnyOfSchemas() {
        return anyOfSchemas.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Collection<Schema> getAnyOfSchemas(boolean elaborate) {
        return anyOfSchemas.get(elaborate);
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
    public void setAnyOfSchemas(Collection<Schema> anyOfSchemas) {
        this.anyOfSchemas.set((Collection<Schema>) anyOfSchemas);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAnyOfSchema(int index, Schema anyOfSchema) {
        anyOfSchemas.set(index, anyOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void addAnyOfSchema(Schema anyOfSchema) {
        anyOfSchemas.add(anyOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void insertAnyOfSchema(int index, Schema anyOfSchema) {
        anyOfSchemas.insert(index, anyOfSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeAnyOfSchema(int index) {
        anyOfSchemas.remove(index);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isAnyOfSchemaReference(int index) {
        return anyOfSchemas.getChild(index).isReference();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getAnyOfSchemaReference(int index) {
        return anyOfSchemas.getChild(index).getReference();
    }

    // NotSchema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getNotSchema() {
        return notSchema.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getNotSchema(boolean elaborate) {
        return notSchema.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setNotSchema(Schema notSchema) {
        this.notSchema.set(notSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isNotSchemaReference() {
        return notSchema != null ? notSchema.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getNotSchemaReference() {
        return notSchema != null ? notSchema.getReference() : null;
    }

    // ItemsSchema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getItemsSchema() {
        return itemsSchema.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getItemsSchema(boolean elaborate) {
        return itemsSchema.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setItemsSchema(Schema itemsSchema) {
        this.itemsSchema.set(itemsSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isItemsSchemaReference() {
        return itemsSchema != null ? itemsSchema.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getItemsSchemaReference() {
        return itemsSchema != null ? itemsSchema.getReference() : null;
    }

    // Property
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Schema> getProperties() {
        return properties.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Schema> getProperties(boolean elaborate) {
        return properties.get(elaborate);
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
    public void setProperties(Map<String, Schema> properties) {
        this.properties.set(properties);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setProperty(String name, Schema property) {
        properties.set(name, property);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeProperty(String name) {
        properties.remove(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isPropertyReference(String key) {
        ChildOverlay<Schema, SchemaImpl> child = properties.getChild(key);
            return child != null ? child.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getPropertyReference(String key) {
        ChildOverlay<Schema, SchemaImpl> child = properties.getChild(key);
            return child != null ? child.getReference() : null;
    }

    // AdditionalPropertiesSchema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAdditionalPropertiesSchema() {
        return additionalPropertiesSchema.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getAdditionalPropertiesSchema(boolean elaborate) {
        return additionalPropertiesSchema.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAdditionalPropertiesSchema(Schema additionalPropertiesSchema) {
        this.additionalPropertiesSchema.set(additionalPropertiesSchema);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isAdditionalPropertiesSchemaReference() {
        return additionalPropertiesSchema != null ? additionalPropertiesSchema.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Reference getAdditionalPropertiesSchemaReference() {
        return additionalPropertiesSchema != null ? additionalPropertiesSchema.getReference() : null;
    }

    // AdditionalProperties
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getAdditionalProperties() {
        return additionalProperties.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getAdditionalProperties(boolean elaborate) {
        return additionalProperties.get(elaborate);
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
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
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
    public String getFormat(boolean elaborate) {
        return format.get(elaborate);
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
    public Object getDefault(boolean elaborate) {
        return defaultValue.get(elaborate);
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
    public Boolean getNullable(boolean elaborate) {
        return nullable.get(elaborate);
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
    public String getDiscriminator(boolean elaborate) {
        return discriminator.get(elaborate);
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
    public Boolean getReadOnly(boolean elaborate) {
        return readOnly.get(elaborate);
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
    public Boolean getWriteOnly(boolean elaborate) {
        return writeOnly.get(elaborate);
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
        return xml.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Xml getXml(boolean elaborate) {
        return xml.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setXml(Xml xml) {
        this.xml.set(xml);
    }

    // ExternalDocs
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ExternalDocs getExternalDocs() {
        return externalDocs.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ExternalDocs getExternalDocs(boolean elaborate) {
        return externalDocs.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs.set(externalDocs);
    }

    // Example
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Example> getExamples() {
        return examples.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Example> getExamples(boolean elaborate) {
        return examples.get(elaborate);
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
    public void setExamples(Map<String, Example> examples) {
        this.examples.set(examples);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExample(String name, Example example) {
        examples.set(name, example);
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
    public Object getExample(boolean elaborate) {
        return example.get(elaborate);
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
    public Boolean getDeprecated(boolean elaborate) {
        return deprecated.get(elaborate);
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
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
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

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void elaborateChildren() {
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
            refables.put("allOf", allOfSchemas);
            oneOfSchemas = createChildList("oneOf", this, SchemaImpl.factory);
            refables.put("oneOf", oneOfSchemas);
            anyOfSchemas = createChildList("anyOf", this, SchemaImpl.factory);
            refables.put("anyOf", anyOfSchemas);
            notSchema = createChild("not", this, SchemaImpl.factory);
            refables.put("not", notSchema);
            itemsSchema = createChild("items", this, SchemaImpl.factory);
            refables.put("items", itemsSchema);
            properties = createChildMap("properties", this, SchemaImpl.factory, null);
            refables.put("properties", properties);
            additionalPropertiesSchema = createChild(json.at("/additionalProperties").isObject(), "additionalProperties", this, SchemaImpl.factory);
            refables.put("additionalProperties", additionalPropertiesSchema);
            additionalProperties = createChild(json.at("/additionalProperties").isBoolean(), "additionalProperties", this, BooleanOverlay.factory);
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

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<Schema, SchemaImpl> factory = new OverlayFactory<Schema, SchemaImpl>() {
    @Override
    protected Class<? super SchemaImpl> getOverlayClass() {
         return SchemaImpl.class;
    }

    @Override
    public SchemaImpl _create(Schema schema, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new SchemaImpl(schema, parent, refReg);
    }

    @Override
    public SchemaImpl _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        return new SchemaImpl(json, parent, refReg);
    }
};

}
