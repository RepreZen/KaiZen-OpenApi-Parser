package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;

public interface SecurityScheme extends IPropertiesOverlay<SecurityScheme>, IModelPart<OpenApi3, SecurityScheme> {

    // Type
    @Generated("com.reprezen.gen.CodeGenerator")
    String getType();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getType(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setType(String type);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // Name
    @Generated("com.reprezen.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getName(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setName(String name);

    // In
    @Generated("com.reprezen.gen.CodeGenerator")
    String getIn();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getIn(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setIn(String in);

    // Scheme
    @Generated("com.reprezen.gen.CodeGenerator")
    String getScheme();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getScheme(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setScheme(String scheme);

    // BearerFormat
    @Generated("com.reprezen.gen.CodeGenerator")
    String getBearerFormat();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getBearerFormat(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setBearerFormat(String bearerFormat);

    // ImplicitOAuthFlow
    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getImplicitOAuthFlow();

    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getImplicitOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setImplicitOAuthFlow(OAuthFlow implicitOAuthFlow);

    // PasswordOAuthFlow
    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getPasswordOAuthFlow();

    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getPasswordOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setPasswordOAuthFlow(OAuthFlow passwordOAuthFlow);

    // ClientCredentialsOAuthFlow
    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getClientCredentialsOAuthFlow();

    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getClientCredentialsOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setClientCredentialsOAuthFlow(OAuthFlow clientCredentialsOAuthFlow);

    // AuthorizationCodeOAuthFlow
    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getAuthorizationCodeOAuthFlow();

    @Generated("com.reprezen.gen.CodeGenerator")
    OAuthFlow getAuthorizationCodeOAuthFlow(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setAuthorizationCodeOAuthFlow(OAuthFlow authorizationCodeOAuthFlow);

    // OAuthFlowsExtension
    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getOAuthFlowsExtensions();

    @Generated("com.reprezen.gen.CodeGenerator")
    Map<String, Object> getOAuthFlowsExtensions(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    boolean hasOAuthFlowsExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    Object getOAuthFlowsExtension(String name);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOAuthFlowsExtensions(Map<String, Object> oAuthFlowsExtensions);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOAuthFlowsExtension(String name, Object oAuthFlowsExtension);

    @Generated("com.reprezen.gen.CodeGenerator")
    void removeOAuthFlowsExtension(String name);

    // OpenIdConnectUrl
    @Generated("com.reprezen.gen.CodeGenerator")
    String getOpenIdConnectUrl();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getOpenIdConnectUrl(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setOpenIdConnectUrl(String openIdConnectUrl);

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
