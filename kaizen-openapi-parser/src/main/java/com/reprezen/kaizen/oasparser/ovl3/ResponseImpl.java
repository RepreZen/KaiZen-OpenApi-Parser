package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Response;

public class ResponseImpl extends PropertiesOverlay<Response> implements Response {

	private Overlay<Response> overlay = Overlay.of(this);

	@Override
	public String getName() {
		return overlay.getParent() instanceof MapOverlay<?> ? overlay.getPathInParent() : null;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ResponseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ResponseImpl(Response response, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(response, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Header> headers;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<MediaType> contentMediaTypes;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Link> links;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Description
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return description._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description._set(description);
	}

	// Header
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Header> getHeaders() {
		return headers._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasHeader(String name) {
		return headers.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Header getHeader(String name) {
		return headers._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHeaders(Map<String, Header> headers) {
		this.headers._set(headers);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHeader(String name, Header header) {
		headers._set(name, header);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeHeader(String name) {
		headers._remove(name);
	}

	// ContentMediaType
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, MediaType> getContentMediaTypes() {
		return contentMediaTypes._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasContentMediaType(String name) {
		return contentMediaTypes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MediaType getContentMediaType(String name) {
		return contentMediaTypes._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaTypes(Map<String, MediaType> contentMediaTypes) {
		this.contentMediaTypes._set(contentMediaTypes);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaType(String name, MediaType contentMediaType) {
		contentMediaTypes._set(name, contentMediaType);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeContentMediaType(String name) {
		contentMediaTypes._remove(name);
	}

	// Link
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Link> getLinks() {
		return links._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasLink(String name) {
		return links.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Link getLink(String name) {
		return links._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setLinks(Map<String, Link> links) {
		this.links._set(links);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setLink(String name, Link link) {
		links._set(name, link);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeLink(String name) {
		links._remove(name);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		description = createChild("description", this, StringOverlay.factory);
		headers = createChildMap("headers", this, HeaderImpl.factory, null);
		contentMediaTypes = createChildMap("content", this, MediaTypeImpl.factory, null);
		links = createChildMap("links", this, LinkImpl.factory, null);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Response> factory = new OverlayFactory<Response>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Response>> getOverlayClass() {
			return ResponseImpl.class;
		}

		@Override
		public JsonOverlay<Response> _create(Response response, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ResponseImpl(response, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Response> castOverlay = (JsonOverlay<Response>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Response> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ResponseImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Response> castOverlay = (JsonOverlay<Response>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Response> getSubtypeOf(Response response) {
		return Response.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Response> getSubtypeOf(JsonNode json) {
		return Response.class;
	}
}
