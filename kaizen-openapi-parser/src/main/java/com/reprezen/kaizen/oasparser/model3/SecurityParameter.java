package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.List;
import com.reprezen.jsonoverlay.IJsonOverlay;

public interface SecurityParameter extends IJsonOverlay<SecurityParameter>, IModelPart<OpenApi3, SecurityParameter> {

    // Parameter
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<String> getParameters();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<String> getParameters(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getParameter(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setParameters(List<String> parameters);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setParameter(int index, String parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addParameter(String parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertParameter(int index, String parameter);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeParameter(int index);
}
