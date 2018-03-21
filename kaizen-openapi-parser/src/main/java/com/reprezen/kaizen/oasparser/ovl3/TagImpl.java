package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.kaizen.oasparser.ovl3.ExternalDocsImpl;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;

public class TagImpl extends PropertiesOverlay<Tag> implements Tag {

    @Generated("com.reprezen.gen.CodeGenerator")
    public TagImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public TagImpl(Tag tag, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(tag, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> name;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> description;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<ExternalDocs> externalDocs;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

    // Name
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getName() {
        return name.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getName(boolean elaborate) {
        return name.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setName(String name) {
        this.name.set(name);
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

    // ExternalDocs
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public ExternalDocs getExternalDocs() {
        return externalDocs.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public ExternalDocs getExternalDocs(boolean elaborate) {
        return externalDocs.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExternalDocs(ExternalDocs externalDocs) {
        this.externalDocs.set(externalDocs);
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
        name = createChild("name", this, StringOverlay.factory);
        description = createChild("description", this, StringOverlay.factory);
        externalDocs = createChild("externalDocs", this, ExternalDocsImpl.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<Tag> factory = new OverlayFactory<Tag>() {

        @Override
        protected Class<? extends IJsonOverlay<? super Tag>> getOverlayClass() {
            return TagImpl.class;
        }

        @Override
        public JsonOverlay<Tag> _create(Tag tag, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new TagImpl(tag, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Tag> castOverlay = (JsonOverlay<Tag>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<Tag> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new TagImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Tag> castOverlay = (JsonOverlay<Tag>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Tag> getSubtypeOf(Tag tag) {
        return Tag.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Tag> getSubtypeOf(JsonNode json) {
        return Tag.class;
    }
}
