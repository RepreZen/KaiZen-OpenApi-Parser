package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;

public interface Xml extends IJsonOverlay<Xml>, IModelPart<OpenApi3, Xml> {

    // Name
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setName(String name);

    // Namespace
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getNamespace();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setNamespace(String namespace);

    // Prefix
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getPrefix();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPrefix(String prefix);

    // Attribute
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getAttribute();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isAttribute();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setAttribute(Boolean attribute);

    // Wrapped
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getWrapped();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isWrapped();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setWrapped(Boolean wrapped);

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
