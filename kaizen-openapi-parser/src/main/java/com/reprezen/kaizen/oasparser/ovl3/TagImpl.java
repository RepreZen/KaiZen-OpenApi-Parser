package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Tag;

public class TagImpl extends OpenApiObjectImpl<Tag, TagImpl> implements Tag {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public TagImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public TagImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay name = new StringOverlay("name", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay description = new StringOverlay("description", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ExternalDocsImpl externalDocs = ExternalDocsImpl.factory.create("externalDocs", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this,
			AnyObjectOverlay.factory, "x-.+");

	// Name
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getName() {
		return name.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setName(String name) {
		this.name.set(name);
	}

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

	// ExternalDocs
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ExternalDocs getExternalDocs() {
		return externalDocs;
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setExternalDocs(ExternalDocs externalDocs) {
		this.externalDocs.set((ExternalDocsImpl) externalDocs);
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
	public static JsonOverlayFactory<TagImpl> factory = new JsonOverlayFactory<TagImpl>() {
		@Override
		public TagImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, TagImpl.class) ? null : new TagImpl(key, json, parent);
		}
	};

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	protected void installPropertyAccessors(PropertyAccessors accessors) {
		OverlayGetter getter = null;
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return name;
			}
		};
		accessors.add("name", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return description;
			}
		};
		accessors.add("description", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return externalDocs;
			}
		};
		accessors.add("externalDocs", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
