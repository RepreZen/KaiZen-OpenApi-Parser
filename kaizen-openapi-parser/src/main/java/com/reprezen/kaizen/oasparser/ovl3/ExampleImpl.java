package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.ChildOverlay;

public class ExampleImpl extends PropertiesOverlay<Example> implements Example {

    @Generated("com.reprezen.gen.CodeGenerator")
    public ExampleImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public ExampleImpl(Example example, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(example, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> summary;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> description;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<Object> value;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> externalValue;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

    // Summary
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getSummary() {
        return summary.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getSummary(boolean elaborate) {
        return summary.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setSummary(String summary) {
        this.summary.set(summary);
    }

    // Description
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Value
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getValue() {
        return value.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getValue(boolean elaborate) {
        return value.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setValue(Object value) {
        this.value.set(value);
    }

    // ExternalValue
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getExternalValue() {
        return externalValue.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getExternalValue(boolean elaborate) {
        return externalValue.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExternalValue(String externalValue) {
        this.externalValue.set(externalValue);
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
        summary = createChild("summary", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        value = createChild("value", this, ObjectOverlay.factory);
        externalValue = createChild("externalValue", this, StringOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<Example> factory = new OverlayFactory<Example>() {

        @Override
        protected Class<? extends IJsonOverlay<? super Example>> getOverlayClass() {
            return ExampleImpl.class;
        }

        @Override
        public JsonOverlay<Example> _create(Example example, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new ExampleImpl(example, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Example> castOverlay = (JsonOverlay<Example>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<Example> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new ExampleImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Example> castOverlay = (JsonOverlay<Example>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Example> getSubtypeOf(Example example) {
        return Example.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Example> getSubtypeOf(JsonNode json) {
        return Example.class;
    }
}
