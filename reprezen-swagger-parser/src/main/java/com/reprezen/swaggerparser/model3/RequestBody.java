package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Map;
import javax.annotation.Generated;

public interface RequestBody extends SwaggerObject {

    // Description
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // ContentMediaType
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, ? extends MediaType> getContentMediaTypes();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasContentMediaType(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    MediaType getContentMediaType(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setContentMediaTypes(Map<String, ? extends MediaType> contentMediaTypes);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setContentMediaType(String name, MediaType contentMediaType);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeContentMediaType(String name);

    // Required
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Boolean getRequired();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean isRequired();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setRequired(Boolean required);

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
