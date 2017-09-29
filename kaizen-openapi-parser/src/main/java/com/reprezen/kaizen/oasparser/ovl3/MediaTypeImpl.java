package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.ovl3.EncodingPropertyImpl;
import com.reprezen.kaizen.oasparser.ovl3.ExampleImpl;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import com.reprezen.kaizen.oasparser.ovl3.SchemaImpl;
import java.util.Map;
import javax.annotation.Generated;

public class MediaTypeImpl extends OpenApiObjectImpl<MediaType> implements MediaType {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public MediaTypeImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public MediaTypeImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private SchemaImpl schema = SchemaImpl.factory.create("schema", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<ExampleImpl> examples = new MapOverlay<ExampleImpl>("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private AnyObjectOverlay example = new AnyObjectOverlay("example", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<EncodingPropertyImpl> encodingProperties = new MapOverlay<EncodingPropertyImpl>("encoding", this, EncodingPropertyImpl.factory, null);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+");

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

    // EncodingProperty
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends EncodingProperty> getEncodingProperties() {
        return encodingProperties.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasEncodingProperty(String name) {
        return encodingProperties.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public EncodingProperty getEncodingProperty(String name) {
        return encodingProperties.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setEncodingProperties(Map<String, ? extends EncodingProperty> encodingProperties) {
        @SuppressWarnings("unchecked")
            Map<String,EncodingPropertyImpl> implEncodingProperties = (Map<String, EncodingPropertyImpl>) encodingProperties;
            this.encodingProperties.set(implEncodingProperties);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setEncodingProperty(String name, EncodingProperty encodingProperty) {
        encodingProperties.set(name, (EncodingPropertyImpl) encodingProperty);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeEncodingProperty(String name) {
        encodingProperties.remove(name);
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
    public static JsonOverlayFactory<MediaTypeImpl> factory = new JsonOverlayFactory<MediaTypeImpl>() {
    @Override
    public MediaTypeImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, MediaTypeImpl.class) ? null : new MediaTypeImpl(key, json, parent);
    }
};

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void installPropertyAccessors(PropertyAccessors accessors) {
        OverlayGetter getter = null;
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return schema;}};
            accessors.add("schema", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return examples;}};
            accessors.add("examples", "[a-zA-Z0-9\\._-]+", getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return example;}};
            accessors.add("example", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return encodingProperties;}};
            accessors.add("encoding", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return extensions;}};
            accessors.add("", "x-.+", getter);
    }

}
