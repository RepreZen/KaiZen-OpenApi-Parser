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
import com.reprezen.kaizen.oasparser.model3.License;

public class LicenseImpl extends PropertiesOverlay<License> implements License {

	JsonNode initJson = jsonMissing();

	@Generated("com.reprezen.gen.CodeGenerator")
	public LicenseImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public LicenseImpl(License license, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(license, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> name;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildOverlay<String> url;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Name
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName() {
		return name._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getName(boolean elaborate) {
		return name._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setName(String name) {
		this.name._set(name);
	}

	// Url
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getUrl() {
		return url._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public String getUrl(boolean elaborate) {
		return url._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setUrl(String url) {
		this.url._set(url);
	}

	// Extension
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return extensions._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return extensions._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return extensions.containsKey(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Object getExtension(String name) {
		return extensions._get(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		this.extensions._set(extensions);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		extensions._set(name, extension);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeExtension(String name) {
		extensions._remove(name);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	protected void elaborateChildren() {
		super.elaborateChildren();
		name = createChild("name", this, StringOverlay.factory);
		url = createChild("url", this, StringOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<License> factory = new OverlayFactory<License>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super License>> getOverlayClass() {
			return LicenseImpl.class;
		}

		@Override
		public JsonOverlay<License> _create(License license, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new LicenseImpl(license, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<License> castOverlay = (JsonOverlay<License>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<License> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new LicenseImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<License> castOverlay = (JsonOverlay<License>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends License> getSubtypeOf(License license) {
		return License.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends License> getSubtypeOf(JsonNode json) {
		return License.class;
	}
}
