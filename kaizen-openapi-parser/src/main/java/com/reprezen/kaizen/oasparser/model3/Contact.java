package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;

public interface Contact extends IJsonOverlay<Contact>, IModelPart<OpenApi3, Contact> {

    // Name
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setName(String name);

    // Url
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getUrl();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setUrl(String url);

    // Email
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getEmail();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setEmail(String email);

    // Extension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);
}
