package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.kaizen.oasparser.model3.OpenApiObject;
import java.util.Collection;
import javax.annotation.Generated;

public interface SecurityParameter extends OpenApiObject<SecurityParameter> {

    // Parameter
    @Generated("com.reprezen.kaizen.oasparser.jsonoverlay.gen.CodeGenerator")
    Collection<String> getParameters();

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
    void removeParameter(int index);

}
