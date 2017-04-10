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

import com.reprezen.swaggerparser.model3.OAuthFlow;
import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Map;
import javax.annotation.Generated;

public interface SecurityScheme extends SwaggerObject {

    // Type
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getType();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setType(String type);

    // Description
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Name
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setName(String name);

    // In
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getIn();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setIn(String in);

    // Scheme
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getScheme();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setScheme(String scheme);

    // BearerFormat
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getBearerFormat();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setBearerFormat(String bearerFormat);

    // ImplicitOAuthFlow
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getImplicitOAuthFlow();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow);

    // PasswordOAuthFlow
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getPasswordOAuthFlow();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow);

    // ClientCredentialsOAuthFlow
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getClientCredentialsOAuthFlow();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow);

    // AuthorizationCodeOAuthFlow
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getAuthorizationCodeOAuthFlow();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow);

    // OAuthFlowsExtension
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getOAuthFlowsExtensions();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasOAuthFlowsExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getOAuthFlowsExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeOAuthFlowsExtension(String name);

    // OpenIdConnectUrl
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getOpenIdConnectUrl();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setOpenIdConnectUrl(String openIdConnectUrl);

    // Extension
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getExtensions();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    boolean hasExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Object getExtension(String name);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExtensions(Map<String, Object> extensions);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setExtension(String name, Object extension);

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void removeExtension(String name);

}
