package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Map;
import javax.annotation.Generated;

public interface ExternalDocs extends SwaggerObject {

    // Description
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Url
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getUrl();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setUrl(String url);

    // Extension
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);

}
