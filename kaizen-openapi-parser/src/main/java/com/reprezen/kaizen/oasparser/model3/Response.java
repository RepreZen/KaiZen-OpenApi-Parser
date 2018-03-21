package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.model3.Link;

public interface Response extends IPropertiesOverlay<Response>, IModelPart<OpenApi3, Response> {

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // Header
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Header> getHeaders();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Header> getHeaders(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasHeader(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Header getHeader(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setHeaders(Map<String, Header> headers);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setHeader(String name, Header header);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeHeader(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isHeaderReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getHeaderReference(String name);

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

    // Link
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Link> getLinks();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Link> getLinks(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasLink(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Link getLink(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setLinks(Map<String, Link> links);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setLink(String name, Link link);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeLink(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean isLinkReference(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Reference getLinkReference(String name);

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
