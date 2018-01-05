package com.reprezen.kaizen.oasparser.model3;

import javax.annotation.Generated;
import java.util.Collection;
import com.reprezen.kaizen.oasparser.jsonoverlay.IPropertiesOverlay;
import com.reprezen.kaizen.oasparser.jsonoverlay.IModelPart;

public interface SecurityParameter extends IPropertiesOverlay<SecurityParameter>, IModelPart<OpenApi3, SecurityParameter> {

    // Parameter
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    Collection<String> getParameters();

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    Collection<String> getParameters(boolean elaborate);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    String getParameter(int index);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    void setParameters(Collection<String> parameters);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    void setParameter(int index, String parameter);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    void addParameter(String parameter);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    void insertParameter(int index, String parameter);

    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    void removeParameter(int index);
}
