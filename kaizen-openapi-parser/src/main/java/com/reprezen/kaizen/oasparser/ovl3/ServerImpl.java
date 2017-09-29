package com.reprezen.kaizen.oasparser.ovl3;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.jsonoverlay.AnyObjectOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.JsonOverlayFactory;
import com.reprezen.kaizen.oasparser.jsonoverlay.MapOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.StringOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.ValMapOverlay;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.ovl3.OpenApiObjectImpl;
import com.reprezen.kaizen.oasparser.ovl3.ServerVariableImpl;
import java.util.Map;
import javax.annotation.Generated;

public class ServerImpl extends OpenApiObjectImpl<Server> implements Server {

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ServerImpl(String key, JsonNode json, JsonOverlay<?> parent) {
        super(key, json, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ServerImpl(String key, JsonOverlay<?> parent) {
        super(key, parent);
    }

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay url = new StringOverlay("url", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private StringOverlay description = new StringOverlay("description", this);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private MapOverlay<ServerVariableImpl> serverVariables = new MapOverlay<ServerVariableImpl>("variables", this, ServerVariableImpl.factory, "(?!x-)[a-zA-Z0-9\\._-]+");

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object, AnyObjectOverlay> variablesExtensions = new ValMapOverlay<Object, AnyObjectOverlay>("variables", this, AnyObjectOverlay.factory, "x-.+");

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    private ValMapOverlay<Object, AnyObjectOverlay> extensions = new ValMapOverlay<Object, AnyObjectOverlay>("", this, AnyObjectOverlay.factory, "x-.+");

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

    // ServerVariable
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, ? extends ServerVariable> getServerVariables() {
        return serverVariables.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasServerVariable(String name) {
        return serverVariables.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public ServerVariable getServerVariable(String name) {
        return serverVariables.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setServerVariables(Map<String, ? extends ServerVariable> serverVariables) {
        @SuppressWarnings("unchecked")
            Map<String,ServerVariableImpl> implServerVariables = (Map<String, ServerVariableImpl>) serverVariables;
            this.serverVariables.set(implServerVariables);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setServerVariable(String name, ServerVariable serverVariable) {
        serverVariables.set(name, (ServerVariableImpl) serverVariable);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeServerVariable(String name) {
        serverVariables.remove(name);
    }

    // VariablesExtension
    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Map<String, Object> getVariablesExtensions() {
        return variablesExtensions.get();
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public boolean hasVariablesExtension(String name) {
        return variablesExtensions.containsKey(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public Object getVariablesExtension(String name) {
        return variablesExtensions.get(name);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setVariablesExtensions(Map<String, Object> variablesExtensions) {
        this.variablesExtensions.set(variablesExtensions);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void setVariablesExtension(String name, Object variablesExtension) {
        variablesExtensions.set(name, variablesExtension);
    }

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    public void removeVariablesExtension(String name) {
        variablesExtensions.remove(name);
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
    public static JsonOverlayFactory<ServerImpl> factory = new JsonOverlayFactory<ServerImpl>() {
    @Override
    public ServerImpl create(String key, JsonNode json, JsonOverlay<?> parent) {
        return isEmptyRecursive(parent, ServerImpl.class) ? null : new ServerImpl(key, json, parent);
    }
};

    @Override
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    protected void installPropertyAccessors(PropertyAccessors accessors) {
        OverlayGetter getter = null;
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return url;}};
            accessors.add("url", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return description;}};
            accessors.add("description", null, getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return serverVariables;}};
            accessors.add("variables", "(?!x-)[a-zA-Z0-9\\._-]+", getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return variablesExtensions;}};
            accessors.add("variables", "x-.+", getter);
            getter = new OverlayGetter(){ public JsonOverlay<?> get(){return extensions;}};
            accessors.add("", "x-.+", getter);
    }

}
