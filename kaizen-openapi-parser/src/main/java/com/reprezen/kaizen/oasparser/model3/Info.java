package com.reprezen.kaizen.oasparser.model3;

import com.reprezen.jsonoverlay.IPropertiesOverlay;
import com.reprezen.jsonoverlay.IModelPart;
import javax.annotation.Generated;
import com.reprezen.kaizen.oasparser.model3.License;
import java.util.Map;
import com.reprezen.kaizen.oasparser.model3.Contact;

public interface Info extends IPropertiesOverlay<Info>, IModelPart<OpenApi3, Info> {

    // Title
    @Generated("com.reprezen.gen.CodeGenerator")
    String getTitle();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getTitle(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setTitle(String title);

    // Description
    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getDescription(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setDescription(String description);

    // TermsOfService
    @Generated("com.reprezen.gen.CodeGenerator")
    String getTermsOfService();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getTermsOfService(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setTermsOfService(String termsOfService);

    // Contact
    @Generated("com.reprezen.gen.CodeGenerator")
    Contact getContact();

    @Generated("com.reprezen.gen.CodeGenerator")
    Contact getContact(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setContact(Contact contact);

    // License
    @Generated("com.reprezen.gen.CodeGenerator")
    License getLicense();

    @Generated("com.reprezen.gen.CodeGenerator")
    License getLicense(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setLicense(License license);

    // Version
    @Generated("com.reprezen.gen.CodeGenerator")
    String getVersion();

    @Generated("com.reprezen.gen.CodeGenerator")
    String getVersion(boolean elaborate);

    @Generated("com.reprezen.gen.CodeGenerator")
    void setVersion(String version);

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
