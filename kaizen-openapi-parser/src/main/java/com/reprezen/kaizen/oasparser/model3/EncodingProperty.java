package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Map;
import com.reprezen.jsonoverlay.Reference;

public interface EncodingProperty extends IPropertiesOverlay<EncodingProperty>, IModelPart<OpenApi3, EncodingProperty> {

    // ContentType
    @Generated("com.reprezen.gen.CodeGenerator")
    String getContentType();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getContentType(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setContentType(String contentType);

    // Header
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, String> getHeaders();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, String> getHeaders(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasHeader(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    String getHeader(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setHeaders(Map<String, String> headers);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setHeader(String name, String header);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeHeader(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isHeaderReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getHeaderReference(String name);

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
