package com.reprezen.swaggerparser.model3;

import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.model3.License;
import com.reprezen.swaggerparser.model3.SwaggerObject;
import java.util.Map;
import javax.annotation.Generated;

public interface Info extends SwaggerObject {

    // Title
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getTitle();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setTitle(String title);

    // Description
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setDescription(String description);

    // TermsOfService
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getTermsOfService();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setTermsOfService(String termsOfService);

    // Contact
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    Contact getContact();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setContact(Contact contact);

    // License
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    License getLicense();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setLicense(License license);

    // Version
    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    String getVersion();

    @Generated("com.reprezen.swaggerparser.jsonoverlay.gen.CodeGenerator")
    void setVersion(String version);

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
