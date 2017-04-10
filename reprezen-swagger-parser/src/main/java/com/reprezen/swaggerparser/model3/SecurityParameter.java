/*******************************************************************************
 *  Copyright (c) 2017 ModelSolv, Inc. and others.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Collection;
import javax.annotation.Generated;

public interface SecurityParameter extends SwaggerObject {

    // Parameter
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Collection<String> getParameters();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasParameters();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getParameter(int index);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setParameters(Collection<String> parameters);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setParameter(int index, String parameter);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void addParameter(String parameter);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeParameter(int index);

}
