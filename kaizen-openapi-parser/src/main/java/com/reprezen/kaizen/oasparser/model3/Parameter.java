package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Example;
import java.util.Map;
import com.reprezen.jsonoverlay.Reference;

public interface Parameter extends IPropertiesOverlay<Parameter>, IModelPart<OpenApi3, Parameter> {

    // Name
    @Generated("com.reprezen.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getName(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setName(String name);

    // In
    @Generated("com.reprezen.gen.CodeGenerator")
    String getIn();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getIn(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setIn(String in);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // Required
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getRequired();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getRequired(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isRequired();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setRequired(Boolean required);

    // Deprecated
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getDeprecated();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getDeprecated(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isDeprecated();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDeprecated(Boolean deprecated);

    // AllowEmptyValue
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAllowEmptyValue();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAllowEmptyValue(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAllowEmptyValue();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAllowEmptyValue(Boolean allowEmptyValue);

    // Style
    @Generated("com.reprezen.gen.CodeGenerator")
    String getStyle();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getStyle(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setStyle(String style);

    // Explode
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getExplode();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getExplode(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isExplode();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExplode(Boolean explode);

    // AllowReserved
    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAllowReserved();

    @Generated("com.reprezen.gen.CodeGenerator")
    Boolean getAllowReserved(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isAllowReserved();

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAllowReserved(Boolean allowReserved);

    // Schema
    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getSchema();

    @Generated("com.reprezen.gen.CodeGenerator")
    Schema getSchema(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setSchema(Schema schema);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isSchemaReference();

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getSchemaReference();

    // Example
    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExample();

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExample(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExample(Object example);

    // Example
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Example> getExamples();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Example> getExamples(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExample(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Example getExample(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExamples(Map<String, Example> examples);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExample(String name, Example example);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExample(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isExampleReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getExampleReference(String name);

    // ContentMediaType
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, MediaType> getContentMediaTypes();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, MediaType> getContentMediaTypes(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasContentMediaType(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    MediaType getContentMediaType(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setContentMediaType(String name, MediaType contentMediaType);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeContentMediaType(String name);

    // Extension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExtension(String name);
}
