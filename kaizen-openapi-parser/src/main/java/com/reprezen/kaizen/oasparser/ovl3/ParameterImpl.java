package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.ovl3.ExampleImpl;
import com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import com.reprezen.kaizen.oasparser.ovl3.SchemaImpl;
import java.util.Map;
import javax.annotation.Generated;

public class ParameterImpl extends OpenApiObjectImpl<Parameter> implements Parameter {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ParameterImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ParameterImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay name = new StringOverlay("name", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay in = new StringOverlay("in", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay description = new StringOverlay("description", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay required = new BooleanOverlay("required", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay deprecated = new BooleanOverlay("deprecated", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay allowEmptyValue = new BooleanOverlay("allowEmptyValue", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay style = new StringOverlay("style", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay explode = new BooleanOverlay("explode", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private BooleanOverlay allowReserved = new BooleanOverlay("allowReserved", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private SchemaImpl schema = SchemaImpl.factory.create("schema", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private AnyObjectOverlay example = new AnyObjectOverlay("example", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<ExampleImpl> examples = new MapOverlay<ExampleImpl>("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<MediaTypeImpl> contentMediaTypes = new MapOverlay<MediaTypeImpl>("content", this, MediaTypeImpl.factory, null);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+");

    // Name
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getName() {
        return name.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setName(String name) {
        this.name.set(name);
    }

    // In
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getIn() {
        return in.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setIn(String in) {
        this.in.set(in);
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

    // Required
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getRequired() {
        return required.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isRequired() {
        return required.get() != null ? required.get() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setRequired(Boolean required) {
        this.required.set(required);
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

    // AllowEmptyValue
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getAllowEmptyValue() {
        return allowEmptyValue.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isAllowEmptyValue() {
        return allowEmptyValue.get() != null ? allowEmptyValue.get() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        this.allowEmptyValue.set(allowEmptyValue);
    }

    // Style
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public String getStyle() {
        return style.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setStyle(String style) {
        this.style.set(style);
    }

    // Explode
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getExplode() {
        return explode.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isExplode() {
        return explode.get() != null ? explode.get() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setExplode(Boolean explode) {
        this.explode.set(explode);
    }

    // AllowReserved
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Boolean getAllowReserved() {
        return allowReserved.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean isAllowReserved() {
        return allowReserved.get() != null ? allowReserved.get() : false;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setAllowReserved(Boolean allowReserved) {
        this.allowReserved.set(allowReserved);
    }

    // Schema
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Schema getSchema() {
        return schema;
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setSchema(Schema schema) {
        this.schema.set((SchemaImpl) schema);
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
            Map<String,ExampleImpl> implExamples = (Map<String, ExampleImpl>) examples;
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

    // ContentMediaType
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends MediaType> getContentMediaTypes() {
        return contentMediaTypes.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasContentMediaType(String name) {
        return contentMediaTypes.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public MediaType getContentMediaType(String name) {
        return contentMediaTypes.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setContentMediaTypes(Map<String, ? extends MediaType> contentMediaTypes) {
        @SuppressWarnings("unchecked")
            Map<String,MediaTypeImpl> implContentMediaTypes = (Map<String, MediaTypeImpl>) contentMediaTypes;
            this.contentMediaTypes.set(implContentMediaTypes);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setContentMediaType(String name, MediaType contentMediaType) {
        contentMediaTypes.set(name, (MediaTypeImpl) contentMediaType);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeContentMediaType(String name) {
        contentMediaTypes.remove(name);
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
    public static JsonOverlayFactory<ParameterImpl> factory = new JsonOverlayFactory<ParameterImpl>() {
    @Override
    public ParameterImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, ParameterImpl.class) ? null : new ParameterImpl(key, json, parent);
    }
};

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void installPropertyAccessors(PropertyAccessors accessors) {
        OverlayGetter getter = null;
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return name;}};
            accessors.add("name", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return in;}};
            accessors.add("in", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return description;}};
            accessors.add("description", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return required;}};
            accessors.add("required", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return deprecated;}};
            accessors.add("deprecated", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return allowEmptyValue;}};
            accessors.add("allowEmptyValue", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return style;}};
            accessors.add("style", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return explode;}};
            accessors.add("explode", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return allowReserved;}};
            accessors.add("allowReserved", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return schema;}};
            accessors.add("schema", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return example;}};
            accessors.add("example", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return examples;}};
            accessors.add("examples", "[a-zA-Z0-9\\._-]+", getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return contentMediaTypes;}};
            accessors.add("content", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return extensions;}};
            accessors.add("", "x-.+", getter);
    }

}
