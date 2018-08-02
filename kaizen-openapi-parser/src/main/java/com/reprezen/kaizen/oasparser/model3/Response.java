package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Link;

public interface Response extends IJsonOverlay<Response>, IModelPart<OpenApi3, Response> {

    String getName();

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Header
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Header> getHeaders();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Header> getHeaders(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasHeaders();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasHeader(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Header getHeader(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHeaders(Map<String, Header> headers);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHeader(String name, Header header);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeHeader(String name);

    // ContentMediaType
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, MediaType> getContentMediaTypes();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, MediaType> getContentMediaTypes(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasContentMediaTypes();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasContentMediaType(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    MediaType getContentMediaType(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setContentMediaTypes(Map<String, MediaType> contentMediaTypes);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setContentMediaType(String name, MediaType contentMediaType);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeContentMediaType(String name);

    // Link
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Link> getLinks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Link> getLinks(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLinks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLink(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Link getLink(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLinks(Map<String, Link> links);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLink(String name, Link link);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeLink(String name);

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
