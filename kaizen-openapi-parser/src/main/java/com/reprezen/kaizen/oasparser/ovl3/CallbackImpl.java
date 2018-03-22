package com.reprezen.kaizen.oasparser.ovl3;

import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.AbstractJsonOverlay;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.Path;

public class CallbackImpl extends PropertiesOverlay<Callback> implements Callback {

	@Generated("com.reprezen.gen.CodeGenerator")
	public CallbackImpl(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public CallbackImpl(Callback callback, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(callback, parent, refReg);
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Path> callbackPaths;

	@Generated("com.reprezen.gen.CodeGenerator")
	private ChildMapOverlay<Object> extensions;

	// CallbackPath
	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Path> getCallbackPaths() {
		return callbackPaths._get();
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Map<String, Path> getCallbackPaths(boolean elaborate) {
		return callbackPaths._get(elaborate);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public boolean hasCallbackPath(String expression) {
		return callbackPaths.containsKey(expression);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public Path getCallbackPath(String expression) {
		return callbackPaths._get(expression);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setCallbackPaths(Map<String, Path> callbackPaths) {
		this.callbackPaths._set(callbackPaths);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void setCallbackPath(String expression, Path callbackPath) {
		callbackPaths._set(expression, callbackPath);
	}

	@Override
	@Generated("com.reprezen.gen.CodeGenerator")
	public void removeCallbackPath(String expression) {
		callbackPaths._remove(expression);
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
		callbackPaths = createChildMap("", this, PathImpl.factory, "(?!x-).*");
		extensions = createChildMap("", this, ObjectOverlay.factory, "x-.+");
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	public static OverlayFactory<Callback> factory = new OverlayFactory<Callback>() {

		@Override
		protected Class<? extends AbstractJsonOverlay<? super Callback>> getOverlayClass() {
			return CallbackImpl.class;
		}

		@Override
		public JsonOverlay<Callback> _create(Callback callback, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new CallbackImpl(callback, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Callback> castOverlay = (JsonOverlay<Callback>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Callback> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			AbstractJsonOverlay<?> overlay;
			overlay = new CallbackImpl(json, parent, refReg);
			@SuppressWarnings("unchecked")
			JsonOverlay<Callback> castOverlay = (JsonOverlay<Callback>) overlay;
			return castOverlay;
		}
	};

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Callback> getSubtypeOf(Callback callback) {
		return Callback.class;
	}

	@Generated("com.reprezen.gen.CodeGenerator")
	private static Class<? extends Callback> getSubtypeOf(JsonNode json) {
		return Callback.class;
	}
}
