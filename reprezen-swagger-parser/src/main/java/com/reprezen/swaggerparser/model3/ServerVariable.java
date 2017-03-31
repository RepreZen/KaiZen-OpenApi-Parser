package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface ServerVariable extends SwaggerObject {

    // EnumValue
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<Object> getEnumValues();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getEnumValue(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setEnumValues(Collection<Object> enumValues);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setEnumValue(int index, Object enumValue);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addEnumValue(Object enumValue);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeEnumValue(int index);

    // Default
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getDefault();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDefault(Object defaultValue);

    // Description
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

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
