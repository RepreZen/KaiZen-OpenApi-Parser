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
package com.reprezen.kaizen.oasparser.old.val3;

import org.apache.commons.lang3.reflect.TypeLiteral;

import com.google.inject.AbstractModule;
import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.Contact;
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.License;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.OAuthFlow;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.ServerVariable;
import com.reprezen.kaizen.oasparser.model3.Tag;
import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.old.val.Validator;

public abstract class ValidationConfigurator extends AbstractModule {

	@Override
	protected void configure() {
		bind(new TypeLiteral<Validator<Callback>>() {
		}).to(CallbackValidator.class);
		bind(new TypeLiteral<Validator<Contact>>() {
		}).to(ContactValidator.class);
		bind(new TypeLiteral<Validator<EncodingProperty>>() {
		}).to(EncodingPropertyValidator.class);
		bind(new TypeLiteral<Validator<Example>>() {
		}).to(ExampleValidator.class);
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
		bind(new TypeLiteral<Validator<OpenApi3>>() {
		}).to(OpenApi3Validator.class);
		bind(new TypeLiteral<Validator<Tag>>() {
		}).to(TagValidator.class);
		bind(new TypeLiteral<Validator<Xml>>() {
		}).to(XmlValidator.class);

		configureImplValidators();
	}

	protected abstract void configureImplValidators();
}
