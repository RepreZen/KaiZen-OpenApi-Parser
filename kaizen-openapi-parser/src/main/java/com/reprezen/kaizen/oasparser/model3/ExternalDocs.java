package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;

public interface ExternalDocs extends IJsonOverlay<ExternalDocs>, IModelPart<OpenApi3, ExternalDocs> {

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Url
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getUrl();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setUrl(String url);

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
