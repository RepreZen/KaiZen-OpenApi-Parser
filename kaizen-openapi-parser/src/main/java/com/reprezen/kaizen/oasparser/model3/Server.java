package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;

public interface Server extends IJsonOverlay<Server>, IModelPart<OpenApi3, Server> {

    // Url
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getUrl();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setUrl(String url);

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // ServerVariable
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, ServerVariable> getServerVariables();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, ServerVariable> getServerVariables(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasServerVariables();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasServerVariable(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ServerVariable getServerVariable(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setServerVariables(Map<String, ServerVariable> serverVariables);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setServerVariable(String name, ServerVariable serverVariable);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeServerVariable(String name);

    // VariablesExtension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getVariablesExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getVariablesExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasVariablesExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasVariablesExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getVariablesExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setVariablesExtensions(Map<String, Object> variablesExtensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setVariablesExtension(String name, Object variablesExtension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeVariablesExtension(String name);

    // Extension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);
}
