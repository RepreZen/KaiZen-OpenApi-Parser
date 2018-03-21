package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.ovl3.HeaderImpl;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl;
import com.reprezen.jsonoverlay.Reference;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.kaizen.oasparser.ovl3.LinkImpl;

public class ResponseImpl extends PropertiesOverlay<Response> implements Response {

    @Generated("com.reprezen.gen.CodeGenerator")
    public ResponseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(json, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public ResponseImpl(Response response, JsonOverlay<?> parent, ReferenceRegistry refReg) {
        super(response, parent, refReg);
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildOverlay<String> description;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Header> headers;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<MediaType> contentMediaTypes;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Link> links;

    @Generated("com.reprezen.gen.CodeGenerator")
    private ChildMapOverlay<Object> extensions;

    // Description
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getDescription() {
        return description.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public String getDescription(boolean elaborate) {
        return description.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setDescription(String description) {
        this.description.set(description);
    }

    // Header
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Header> getHeaders() {
        return headers.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Header> getHeaders(boolean elaborate) {
        return headers.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasHeader(String name) {
        return headers.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Header getHeader(String name) {
        return headers.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setHeaders(Map<String, Header> headers) {
        this.headers.set(headers);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setHeader(String name, Header header) {
        headers.set(name, header);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeHeader(String name) {
        headers.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean isHeaderReference(String name) {
        ChildOverlay<Header> child = headers.getChild(name);
        return child != null ? child.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Reference getHeaderReference(String name) {
        ChildOverlay<Header> child = headers.getChild(name);
        return child != null ? child.getReference() : null;
    }

    // ContentMediaType
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, MediaType> getContentMediaTypes() {
        return contentMediaTypes.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, MediaType> getContentMediaTypes(boolean elaborate) {
        return contentMediaTypes.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasContentMediaType(String name) {
        return contentMediaTypes.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public MediaType getContentMediaType(String name) {
        return contentMediaTypes.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
        this.contentMediaTypes.set(contentMediaTypes);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setContentMediaType(String name, MediaType contentMediaType) {
        contentMediaTypes.set(name, contentMediaType);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeContentMediaType(String name) {
        contentMediaTypes.remove(name);
    }

    // Link
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Link> getLinks() {
        return links.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Link> getLinks(boolean elaborate) {
        return links.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasLink(String name) {
        return links.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Link getLink(String name) {
        return links.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setLinks(Map<String, Link> links) {
        this.links.set(links);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setLink(String name, Link link) {
        links.set(name, link);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeLink(String name) {
        links.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean isLinkReference(String name) {
        ChildOverlay<Link> child = links.getChild(name);
        return child != null ? child.isReference() : false;
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Reference getLinkReference(String name) {
        ChildOverlay<Link> child = links.getChild(name);
        return child != null ? child.getReference() : null;
    }

    // Extension
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    protected void elaborateChildren() {
        super.elaborateChildren();
        description = createChild("description", this, StringOverlay.factory);
        headers = createChildMap("headers", this, HeaderImpl.factory, null);
        refables.put("headers", headers);
        contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
        links = createChildMap("links", this, LinkImpl.factory, null);
        refables.put("links", links);
        extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    public static OverlayFactory<Response> factory = new OverlayFactory<Response>() {

        @Override
        protected Class<? extends IJsonOverlay<? super Response>> getOverlayClass() {
            return ResponseImpl.class;
        }

        @Override
        public JsonOverlay<Response> _create(Response response, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new ResponseImpl(response, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Response> castOverlay = (JsonOverlay<Response>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<Response> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new ResponseImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Response> castOverlay = (JsonOverlay<Response>) overlay;
            return castOverlay;
        }
    };

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Response> getSubtypeOf(Response response) {
        return Response.class;
    }

    @Generated("com.reprezen.gen.CodeGenerator")
    private static Class<? extends Response> getSubtypeOf(JsonNode json) {
        return Response.class;
    }
}
