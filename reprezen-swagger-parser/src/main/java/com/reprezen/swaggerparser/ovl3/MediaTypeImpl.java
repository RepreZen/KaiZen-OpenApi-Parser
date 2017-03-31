package com.reprezen.swaggerparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlay;
import com.reprezen.swaggerparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.swaggerparser.jsonoverlay.coll.MapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValListOverlay;
import com.reprezen.swaggerparser.jsonoverlay.coll.ValMapOverlay;
import com.reprezen.swaggerparser.jsonoverlay.std.AnyObjectOverlay;
import com.reprezen.swaggerparser.model3.EncodingProperty;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.ovl3.EncodingPropertyImpl;
import com.reprezen.swaggerparser.ovl3.SchemaImpl;
import com.reprezen.swaggerparser.ovl3.SwaggerObjectImpl;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public class MediaTypeImpl extends SwaggerObjectImpl implements MediaType {

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public MediaTypeImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public MediaTypeImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private SchemaImpl schema = registerField("schema", "schema", null, SchemaImpl.factory.create("schema", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValListOverlay<Object, AnyObjectOverlay> examples = registerField("examples", "examples", null, new ValListOverlay<Object, AnyObjectOverlay>("examples", this, AnyObjectOverlay.factory));;

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private AnyObjectOverlay example = registerField("example", "example", null, new AnyObjectOverlay("example", this));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<EncodingPropertyImpl> encodingProperties = registerField("encoding", "encodingProperties", null, new MapOverlay<EncodingPropertyImpl>("encoding", this, EncodingPropertyImpl.factory, null));

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object,AnyObjectOverlay> extensions = registerField("", "extensions", "x-.+", new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+"));

    // Schema
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Schema getSchema() {
        return schema;
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setSchema(Schema schema) {
        this.schema.set((SchemaImpl) schema);
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
        this.examples.set((Collection<Object>) examples);
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

    // EncodingProperty
    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends EncodingProperty> getEncodingProperties() {
        return encodingProperties.get();
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasEncodingProperty(String name) {
        return encodingProperties.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public EncodingProperty getEncodingProperty(String name) {
        return encodingProperties.get(name);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setEncodingProperties(Map<String, ? extends EncodingProperty> encodingProperties) {
        @SuppressWarnings("unchecked")
            Map<String,EncodingPropertyImpl> implEncodingProperties = (Map<String, EncodingPropertyImpl>) encodingProperties;
            this.encodingProperties.set(implEncodingProperties);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void setEncodingProperty(String name, EncodingProperty encodingProperty) {
        encodingProperties.set(name, (EncodingPropertyImpl) encodingProperty);
    }

    @Override
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    public void removeEncodingProperty(String name) {
        encodingProperties.remove(name);
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
    public static JsonOverlayFactory<MediaTypeImpl> factory = new JsonOverlayFactory<MediaTypeImpl>() {
    @Override
    public MediaTypeImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, MediaTypeImpl.class) ? null : new MediaTypeImpl(key, json, parent);
    }
};

}
