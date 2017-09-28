package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.Contact;

public class ContactImpl extends OpenApiObjectImpl<Contact, IObjectOverlay<Contact>> implements Contact {

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ContactImpl(String key, JsonNode json, JsonOverlay<?> parent) {
		super(key, json, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public ContactImpl(String key, JsonOverlay<?> parent) {
		super(key, parent);
	}

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay name = new StringOverlay("name", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay url = new StringOverlay("url", this);

	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	private StringOverlay email = new StringOverlay("email", this);

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

	// Url
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getUrl() {
		return url.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setUrl(String url) {
		this.url.set(url);
	}

	// Email
	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public String getEmail() {
		return email.get();
	}

	@Override
	@Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
	public void setEmail(String email) {
		this.email.set(email);
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
	public static JsonOverlayFactory<ContactImpl> factory = new JsonOverlayFactory<ContactImpl>() {
		@Override
		public ContactImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
			return isEmptyRecursive(parent, ContactImpl.class) ? null : new ContactImpl(key, json, parent);
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
				return url;
			}
		};
		accessors.add("url", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return email;
			}
		};
		accessors.add("email", null, getter);
		getter = new OverlayGetter() {
			public JsonOverlay<?> get() {
				return extensions;
			}
		};
		accessors.add("", "x-.+", getter);
	}

}
