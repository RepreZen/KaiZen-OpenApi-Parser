package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.BooleanOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.RequestBody;

public class RequestBodyImpl extends OpenApiObjectImpl<RequestBody, RequestBodyImpl> implements RequestBody {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public RequestBodyImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public RequestBodyImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay description = new StringOverlay("description", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private MapOverlay<MediaTypeImpl> contentMediaTypes = new MapOverlay<MediaTypeImpl>("content", this,
			MediaTypeImpl.factory, null);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private BooleanOverlay required = new BooleanOverlay("required", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this,
			AnyObjectOverlay.factory, "x-.+");

	// Description
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getDescription() {
		return description.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setDescription(String description) {
		this.description.set(description);
	}

	// ContentMediaType
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, ? extends MediaType> getContentMediaTypes() {
		return contentMediaTypes.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasContentMediaType(String name) {
		return contentMediaTypes.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public MediaType getContentMediaType(String name) {
		return contentMediaTypes.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaTypes(Map<String, ? extends MediaType> contentMediaTypes) {
		@SuppressWarnings("unchecked")
		Map<String, MediaTypeImpl> implContentMediaTypes = (Map<String, MediaTypeImpl>) contentMediaTypes;
		this.contentMediaTypes.set(implContentMediaTypes);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setContentMediaType(String name, MediaType contentMediaType) {
		contentMediaTypes.set(name, (MediaTypeImpl) contentMediaType);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeContentMediaType(String name) {
		contentMediaTypes.remove(name);
	}

	// Required
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Boolean getRequired() {
		return required.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean isRequired() {
		return required.get() != null ? required.get() : false;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setRequired(Boolean required) {
		this.required.set(required);
	}

	// Extension
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions.get(name);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions.set(extensions);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions.set(name, extension);
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions.remove(name);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public static JsonOverlayFactory<RequestBodyImpl> factory = new JsonOverlayFactory<RequestBodyImpl>() {
		@Override
		public RequestBodyImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, RequestBodyImpl.class) ? null : new RequestBodyImpl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return description;
			}
		};
		accessors.add("description", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return contentMediaTypes;
			}
		};
		accessors.add("content", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return required;
			}
		};
		accessors.add("required", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
