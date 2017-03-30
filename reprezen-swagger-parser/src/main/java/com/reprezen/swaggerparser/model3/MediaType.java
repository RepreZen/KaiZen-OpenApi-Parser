package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.EncodingProperty;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Generated;

public interface MediaType extends SwaggerObject {

    // Schema
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Schema getSchema();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setSchema(Schema schema);

    // Example
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<Object> getExamples();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExample(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExamples(Collection<Object> examples);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExample(int index, Object example);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addExample(Object example);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeExample(int index);

    // Example
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExample();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExample(Object example);

    // EncodingProperty
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, ? extends EncodingProperty> getEncodingProperties();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasEncodingProperty(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    EncodingProperty getEncodingProperty(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setEncodingProperties(Map<String, ? extends EncodingProperty> encodingProperties);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setEncodingProperty(String name, EncodingProperty encodingProperty);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeEncodingProperty(String name);

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
