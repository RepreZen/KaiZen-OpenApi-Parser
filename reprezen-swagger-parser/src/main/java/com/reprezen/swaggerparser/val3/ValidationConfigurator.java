package com.reprezen.swaggerparser.val3;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.reprezen.swaggerparser.model3.Callback;
import com.reprezen.swaggerparser.model3.Contact;
import com.reprezen.swaggerparser.model3.EncodingProperty;
import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.model3.Header;
import com.reprezen.swaggerparser.model3.Info;
import com.reprezen.swaggerparser.model3.License;
import com.reprezen.swaggerparser.model3.Link;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.OAuthFlow;
import com.reprezen.swaggerparser.model3.Operation;
import com.reprezen.swaggerparser.model3.Parameter;
import com.reprezen.swaggerparser.model3.Path;
import com.reprezen.swaggerparser.model3.RequestBody;
import com.reprezen.swaggerparser.model3.Response;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.SecurityRequirement;
import com.reprezen.swaggerparser.model3.SecurityScheme;
import com.reprezen.swaggerparser.model3.Server;
import com.reprezen.swaggerparser.model3.ServerVariable;
import com.reprezen.swaggerparser.model3.Swagger3;
import com.reprezen.swaggerparser.model3.Tag;
import com.reprezen.swaggerparser.model3.Xml;
import com.reprezen.swaggerparser.val.Validator;

public abstract class ValidationConfigurator extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<Validator<Callback>>() {
        }).to(CallbackValidator.class);
        bind(new TypeLiteral<Validator<Contact>>() {
        }).to(ContactValidator.class);
        bind(new TypeLiteral<Validator<EncodingProperty>>() {
        }).to(EncodingPropertyValidator.class);
        bind(new TypeLiteral<Validator<ExternalDocs>>() {
        }).to(ExternalDocsValidator.class);
        bind(new TypeLiteral<Validator<Header>>() {
        }).to(HeaderValidator.class);
        bind(new TypeLiteral<Validator<Info>>() {
        }).to(InfoValidator.class);
        bind(new TypeLiteral<Validator<License>>() {
        }).to(LicenseValidator.class);
        bind(new TypeLiteral<Validator<Link>>() {
        }).to(LinkValidator.class);
        bind(new TypeLiteral<Validator<MediaType>>() {
        }).to(MediaTypeValidator.class);
        bind(new TypeLiteral<Validator<OAuthFlow>>() {
        }).to(OAuthFlowValidator.class);
        bind(new TypeLiteral<Validator<Operation>>() {
        }).to(OperationValidator.class);
        bind(new TypeLiteral<Validator<Parameter>>() {
        }).to(ParameterValidator.class);
        bind(new TypeLiteral<Validator<Path>>() {
        }).to(PathValidator.class);
        bind(new TypeLiteral<Validator<RequestBody>>() {
        }).to(RequestBodyValidator.class);
        bind(new TypeLiteral<Validator<Response>>() {
        }).to(ResponseValidator.class);
        bind(new TypeLiteral<Validator<Schema>>() {
        }).to(SchemaValidator.class);
        bind(new TypeLiteral<Validator<SecurityRequirement>>() {
        }).to(SecurityRequirementValidator.class);
        bind(new TypeLiteral<Validator<SecurityScheme>>() {
        }).to(SecuritySchemeValidator.class);
        bind(new TypeLiteral<Validator<Server>>() {
        }).to(ServerValidator.class);
        bind(new TypeLiteral<Validator<ServerVariable>>() {
        }).to(ServerVariableValidator.class);
        bind(new TypeLiteral<Validator<Swagger3>>() {
        }).to(Swagger3Validator.class);
        bind(new TypeLiteral<Validator<Tag>>() {
        }).to(TagValidator.class);
        bind(new TypeLiteral<Validator<Xml>>() {
        }).to(XmlValidator.class);

        configureImplValidators();
    }

    protected abstract void configureImplValidators();
}
