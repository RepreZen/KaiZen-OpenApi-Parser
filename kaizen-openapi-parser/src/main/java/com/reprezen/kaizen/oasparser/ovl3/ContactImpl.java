package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.Builder;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;

public class ContactImpl extends PropertiesOverlay<Contact> implements Contact {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ContactImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, factory, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ContactImpl(Contact contact, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(contact, parent, factory, refMgr);
	}

	// Name
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getName() {
		return _get("name", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setName(String name) {
		_setScalar("name", name, String.class);
	}

	// Url
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getUrl() {
		return _get("url", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setUrl(String url) {
		_setScalar("url", url, String.class);
	}

	// Email
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public String getEmail() {
		return _get("email", String.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setEmail(String email) {
		_setScalar("email", email, String.class);
	}

	// Extension
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions() {
		return _getMap("extensions", Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Map<String, Object> getExtensions(boolean elaborate) {
		return _getMap("extensions", elaborate, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtensions() {
		return _isPresent("extensions");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasExtension(String name) {
		return _getMap("extensions", Object.class).containsKey(name);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Object getExtension(String name) {
		return _get("extensions", name, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtensions(Map<String, Object> extensions) {
		_setMap("extensions", extensions, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setExtension(String name, Object extension) {
		_set("extensions", name, extension, Object.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removeExtension(String name) {
		_remove("extensions", name, Object.class);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_name = "name";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_url = "url";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_email = "email";

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static final String F_extensions = "extensions";

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("name", "name", StringOverlay.factory);
		_createScalar("url", "url", StringOverlay.factory);
		_createScalar("email", "email", StringOverlay.factory);
		_createMap("extensions", "", ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Contact> factory = new OverlayFactory<Contact>() {

		@Override
		protected Class<? extends JsonOverlay<? super Contact>> getOverlayClass() {
			return ContactImpl.class;
		}

		@Override
		public JsonOverlay<Contact> _create(Contact contact, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ContactImpl(contact, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Contact> castOverlay = (JsonOverlay<Contact>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Contact> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ContactImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<Contact> castOverlay = (JsonOverlay<Contact>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
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

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Class<?> _getModelType() {
		return OpenApi3.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Builder<Contact> builder(OV modelMember) {
		return new Builder<Contact>(factory, modelMember);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static <OV extends IJsonOverlay<?>> Contact create(OV modelMember) {
		return (Contact) builder(modelMember).build();
	}
}
