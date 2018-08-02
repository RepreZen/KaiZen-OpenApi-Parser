package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.jsonoverlay.IJsonOverlay;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;

public interface SecurityScheme extends IJsonOverlay<SecurityScheme>, IModelPart<OpenApi3, SecurityScheme> {

    String getKey();

    // Type
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getType();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setType(String type);

    // Description
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // Name
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setName(String name);

    // In
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getIn();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setIn(String in);

    // Scheme
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getScheme();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setScheme(String scheme);

    // BearerFormat
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getBearerFormat();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setBearerFormat(String bearerFormat);

    // ImplicitOAuthFlow
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getImplicitOAuthFlow();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getImplicitOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow);

    // PasswordOAuthFlow
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getPasswordOAuthFlow();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getPasswordOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow);

    // ClientCredentialsOAuthFlow
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getClientCredentialsOAuthFlow();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow);

    // AuthorizationCodeOAuthFlow
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getAuthorizationCodeOAuthFlow();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow);

    // OAuthFlowsExtension
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getOAuthFlowsExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, Object> getOAuthFlowsExtensions(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasOAuthFlowsExtensions();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasOAuthFlowsExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Object getOAuthFlowsExtension(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeOAuthFlowsExtension(String name);

    // OpenIdConnectUrl
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getOpenIdConnectUrl();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setOpenIdConnectUrl(String openIdConnectUrl);

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
