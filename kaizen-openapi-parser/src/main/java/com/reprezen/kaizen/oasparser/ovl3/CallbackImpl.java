package com.reprezen.kaizen.oasparser.ovl3;

import com.reprezen.jsonoverlay.ReferenceRegistry;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.jsonoverlay.ChildMapOverlay;
import com.reprezen.jsonoverlay.ObjectOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.ovl3.PathImpl;
import java.util.stream.Collectors;
import com.reprezen.kaizen.oasparser.model3.*;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.PropertiesOverlay;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.IJsonOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;

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
        return callbackPaths.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Path> getCallbackPaths(boolean elaborate) {
        return callbackPaths.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasCallbackPath(String expression) {
        return callbackPaths.containsKey(expression);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Path getCallbackPath(String expression) {
        return callbackPaths.get(expression);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setCallbackPaths(Map<String, Path> callbackPaths) {
        this.callbackPaths.set(callbackPaths);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setCallbackPath(String expression, Path callbackPath) {
        callbackPaths.set(expression, callbackPath);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeCallbackPath(String expression) {
        callbackPaths.remove(expression);
    }

    // Extension
    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions() {
        return extensions.get();
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Map<String, Object> getExtensions(boolean elaborate) {
        return extensions.get(elaborate);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public boolean hasExtension(String name) {
        return extensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public Object getExtension(String name) {
        return extensions.get(name);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions.set(extensions);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void setExtension(String name, Object extension) {
        extensions.set(name, extension);
    }

    @Override
    @Generated("com.reprezen.gen.CodeGenerator")
    public void removeExtension(String name) {
        extensions.remove(name);
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
        protected Class<? extends IJsonOverlay<? super Callback>> getOverlayClass() {
            return CallbackImpl.class;
        }

        @Override
        public JsonOverlay<Callback> _create(Callback callback, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new CallbackImpl(callback, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Callback> castOverlay = (JsonOverlay<Callback>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<Callback> _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
            IJsonOverlay<?> overlay;
            overlay = new CallbackImpl(json, parent, refReg);
            @SuppressWarnings("unchecked") JsonOverlay<Callback> castOverlay = (JsonOverlay<Callback>) overlay;
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
