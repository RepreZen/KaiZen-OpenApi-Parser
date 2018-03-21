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

public class ContactImpl extends PropertiesOverlay<Contact> implements Contact {

    @Generated("com.reprezen.gen.CodeGenerator")
    public ContactImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public ContactImpl(Contact contact, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(contact, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> name;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> url;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> email;

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

    // Url
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getUrl() {
        return url.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getUrl(boolean elaborate) {
        return url.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setUrl(String url) {
        this.url.set(url);
    }

    // Email
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getEmail() {
        return email.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getEmail(boolean elaborate) {
        return email.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setEmail(String email) {
        this.email.set(email);
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
        url = createChild("url", this, StringOverlay.factory);
        email = createChild("email", this, StringOverlay.factory);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<Contact> factory = new OverlayFactory<Contact>() {

        @Override
        protected Class<? extends IJsonOverlay<? super Contact>> getOverlayClass() {
            return ContactImpl.class;
        }

        @Override
        public JsonOverlay<Contact> _create(Contact contact, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new ContactImpl(contact, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Contact> castOverlay = (JsonOverlay<Contact>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<Contact> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new ContactImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Contact> castOverlay = (JsonOverlay<Contact>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Contact> getSubtypeOf(Contact contact) {
        return Contact.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Contact> getSubtypeOf(JsonNode json) {
        return Contact.class;
    }
}
