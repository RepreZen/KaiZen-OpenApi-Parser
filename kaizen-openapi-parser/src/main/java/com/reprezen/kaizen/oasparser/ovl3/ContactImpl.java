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

public class ContactImpl extends PropertiesOverlay<Contact> implements Contact {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ContactImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ContactImpl(Contact contact, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(contact, parent, refReg);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> name;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> url;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildOverlay<String> email;

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// Name
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getName() {
		return name._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setName(String name) {
		this.name._set(name);
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

	// Email
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getEmail() {
		return email._get();
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEmail(String email) {
		this.email._set(email);
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
		name = createChild("name", this, StringOverlay.factory);
		url = createChild("url", this, StringOverlay.factory);
		email = createChild("email", this, StringOverlay.factory);
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Contact> factory = new OverlayFactory<Contact>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Contact>> getOverlayClass() {
			return ContactImpl.class;
		}

		@Override
		public JsonOverlay<Contact> _create(Contact contact, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ContactImpl(contact, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Contact> castOverlay = (JsonOverlay<Contact>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Contact> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new ContactImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Contact> castOverlay = (JsonOverlay<Contact>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Contact> getSubtypeOf(Contact contact) {
		return Contact.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Contact> getSubtypeOf(JsonNode json) {
		return Contact.class;
	}
}
