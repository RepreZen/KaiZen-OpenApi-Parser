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
import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.License;

public class InfoImpl extends PropertiesOverlay<Info> implements Info {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public InfoImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public InfoImpl(Info info, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(info, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> title;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> description;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> termsOfService;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<Contact> contact;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<License> license;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> version;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Title
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getTitle() {
		return title._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTitle(String title) {
		this.title._set(title);
	}

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

	// TermsOfService
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getTermsOfService() {
		return termsOfService._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setTermsOfService(String termsOfService) {
		this.termsOfService._set(termsOfService);
	}

	// Contact
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Contact getContact() {
		return contact._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Contact getContact(boolean elaborate) {
		return contact._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContact(Contact contact) {
		this.contact._set(contact);
	}

	// License
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public License getLicense() {
		return license._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public License getLicense(boolean elaborate) {
		return license._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setLicense(License license) {
		this.license._set(license);
	}

	// Version
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getVersion() {
		return version._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setVersion(String version) {
		this.version._set(version);
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
		title = createChild("title", this, StringOverlay.factory);
		description = createChild("description", this, StringOverlay.factory);
		termsOfService = createChild("termsOfService", this, StringOverlay.factory);
		contact = createChild("contact", this, ContactImpl.factory);
		license = createChild("license", this, LicenseImpl.factory);
		version = createChild("version", this, StringOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Info> factory = new OverlayFactory<Info>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Info>> getOverlayClass() {
			return InfoImpl.class;
		}

		@Override
		public JsonOverlay<Info> _create(Info info, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new InfoImpl(info, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Info> castOverlay = (JsonOverlay<Info>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Info> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new InfoImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Info> castOverlay = (JsonOverlay<Info>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Info> getSubtypeOf(Info info) {
		return Info.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Info> getSubtypeOf(JsonNode json) {
		return Info.class;
	}
}
