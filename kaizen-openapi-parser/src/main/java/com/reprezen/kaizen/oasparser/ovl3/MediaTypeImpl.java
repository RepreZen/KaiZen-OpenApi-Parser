package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.ovl3.ExampleImpl;
import com.reprezen.jsonoverlay.Reference;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.kaizen.oasparser.ovl3.EncodingPropertyImpl;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.kaizen.oasparser.ovl3.SchemaImpl;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;

public class MediaTypeImpl extends PropertiesOverlay<MediaType> implements MediaType {

    @Generated("com.reprezen.gen.CodeGenerator")
    public MediaTypeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public MediaTypeImpl(MediaType mediaType, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(mediaType, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<Schema> schema;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Example> examples;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<Object> example;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<EncodingProperty> encodingProperties;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

    // Schema
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Schema getSchema() {
        return schema.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Schema getSchema(boolean elaborate) {
        return schema.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setSchema(Schema schema) {
        this.schema.set(schema);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean isSchemaReference() {
        return schema != null ? schema.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Reference getSchemaReference() {
        return schema != null ? schema.getReference() : null;
    }

    // Example
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Example> getExamples() {
        return examples.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Example> getExamples(boolean elaborate) {
        return examples.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasExample(String name) {
        return examples.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Example getExample(String name) {
        return examples.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExamples(Map<String, Example> examples) {
        this.examples.set(examples);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExample(String name, Example example) {
        examples.set(name, example);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeExample(String name) {
        examples.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean isExampleReference(String name) {
        ChildOverlay<Example> child = examples.getChild(name);
        return child != null ? child.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Reference getExampleReference(String name) {
        ChildOverlay<Example> child = examples.getChild(name);
        return child != null ? child.getReference() : null;
    }

    // Example
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getExample() {
        return example.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getExample(boolean elaborate) {
        return example.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExample(Object example) {
        this.example.set(example);
    }

    // EncodingProperty
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, EncodingProperty> getEncodingProperties() {
        return encodingProperties.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, EncodingProperty> getEncodingProperties(boolean elaborate) {
        return encodingProperties.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasEncodingProperty(String name) {
        return encodingProperties.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public EncodingProperty getEncodingProperty(String name) {
        return encodingProperties.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setEncodingProperties(Map<String, EncodingProperty> encodingProperties) {
        this.encodingProperties.set(encodingProperties);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setEncodingProperty(String name, EncodingProperty encodingProperty) {
        encodingProperties.set(name, encodingProperty);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeEncodingProperty(String name) {
        encodingProperties.remove(name);
    }

    // Extension
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    protected void elaborateChildren() {
        super.elaborateChildren();
        schema = createChild("schema", this, SchemaImpl.factory);
        refables.put("schema", schema);
        examples = createChildMap("examples", this, ExampleImpl.factory, "[a-zA-Z0-9\\._-]+");
        refables.put("examples", examples);
        example = createChild("example", this, ObjectOverlay.factory);
        encodingProperties = createChildMap("encoding", this, EncodingPropertyImpl.factory, null);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<MediaType> factory = new OverlayFactory<MediaType>() {

        @Override
        protected Class<? extends IJsonOverlay<? super MediaType>> getOverlayClass() {
            return MediaTypeImpl.class;
        }

        @Override
        public JsonOverlay<MediaType> _create(MediaType mediaType, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new MediaTypeImpl(mediaType, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<MediaType> castOverlay = (JsonOverlay<MediaType>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<MediaType> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new MediaTypeImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<MediaType> castOverlay = (JsonOverlay<MediaType>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends MediaType> getSubtypeOf(MediaType mediaType) {
        return MediaType.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends MediaType> getSubtypeOf(JsonNode json) {
        return MediaType.class;
    }
}
