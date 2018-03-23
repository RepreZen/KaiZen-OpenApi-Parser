package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ChildOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;

public class ExternalDocsImpl extends PropertiesOverlay<ExternalDocs> implements ExternalDocs {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocsImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExternalDocsImpl(ExternalDocs externalDocs, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(externalDocs, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> url;

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

	// Url
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getUrl() {
		return url._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setUrl(String url) {
		this.url._set(url);
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
		url = createChild("url", this, StringOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<ExternalDocs> factory = new OverlayFactory<ExternalDocs>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super ExternalDocs>> getOverlayClass() {
			return ExternalDocsImpl.class;
		}

		@Override
		public JsonOverlay<ExternalDocs> _create(ExternalDocs externalDocs, JsonOverlay<?> parent,
				ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ExternalDocsImpl(externalDocs, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExternalDocs> castOverlay = (JsonOverlay<ExternalDocs>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ExternalDocs> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ExternalDocsImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExternalDocs> castOverlay = (JsonOverlay<ExternalDocs>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ExternalDocs> getSubtypeOf(ExternalDocs externalDocs) {
		return ExternalDocs.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ExternalDocs> getSubtypeOf(JsonNode json) {
		return ExternalDocs.class;
	}
}
