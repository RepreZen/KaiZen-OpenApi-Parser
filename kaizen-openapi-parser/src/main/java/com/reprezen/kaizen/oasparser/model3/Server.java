package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;

public interface Server extends IPropertiesOverlay<Server>, IModelPart<OpenApi3, Server> {

    // Url
    @Generated("com.reprezen.gen.CodeGenerator")
    String getUrl();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getUrl(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setUrl(String url);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // ServerVariable
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, ServerVariable> getServerVariables();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, ServerVariable> getServerVariables(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasServerVariable(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    ServerVariable getServerVariable(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setServerVariables(Map<String, ServerVariable> serverVariables);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setServerVariable(String name, ServerVariable serverVariable);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeServerVariable(String name);

    // VariablesExtension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getVariablesExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getVariablesExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasVariablesExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getVariablesExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setVariablesExtensions(Map<String, Object> variablesExtensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setVariablesExtension(String name, Object variablesExtension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeVariablesExtension(String name);

    // Extension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeExtension(String name);
}
