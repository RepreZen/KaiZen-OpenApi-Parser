package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Collection;

public interface SecurityParameter extends IPropertiesOverlay<SecurityParameter>, IModelPart<OpenApi3, SecurityParameter> {

    // Parameter
    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<String> getParameters();

    @Generated("com.reprezen.gen.CodeGenerator")
    Collection<String> getParameters(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getParameter(int index);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setParameters(Collection<String> parameters);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setParameter(int index, String parameter);

    @Generated("com.reprezen.gen.CodeGenerator")
    void addParameter(String parameter);

    @Generated("com.reprezen.gen.CodeGenerator")
    void insertParameter(int index, String parameter);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeParameter(int index);
}
