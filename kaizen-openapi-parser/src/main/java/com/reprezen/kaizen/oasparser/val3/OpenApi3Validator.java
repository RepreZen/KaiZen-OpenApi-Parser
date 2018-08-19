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
package com.reprezen.kaizen.oasparser.val3;

import com.reprezen.kaizen.oasparser.model3.Callback;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.RequestBody;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.SecurityRequirement;
import com.reprezen.kaizen.oasparser.model3.SecurityScheme;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.model3.Tag;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class OpenApi3Validator extends ObjectValidatorBase<OpenApi3> {

	@Override
	public void runObjectValidations() {
		OpenApi3 model = (OpenApi3) value.getOverlay();
		validateStringField("openApi", true, "3\\.\\d+(\\.\\d+.*)?");
		validateField("info", true, Info.class, new InfoValidator());
		validateListField("servers", false, false, Server.class, new ServerValidator());
		validateMapField("paths", true, false, Path.class, new PathValidator());
		validateExtensions(model.getPathsExtensions());
		validateMapField("schemas", false, false, Schema.class, new SchemaValidator());
		validateMapField("responses", false, false, Response.class, new ResponseValidator());
		validateMapField("parameters", false, false, Parameter.class, new ParameterValidator());
		validateMapField("examples", false, false, Example.class, new ExampleValidator());
		validateMapField("requestBodies", false, false, RequestBody.class, new RequestBodyValidator());
		validateMapField("headers", false, false, Header.class, new HeaderValidator());
		validateMapField("securitySchemes", false, false, SecurityScheme.class, new SecuritySchemeValidator());
		validateMapField("links", false, false, Link.class, new LinkValidator());
		validateMapField("callbacks", false, false, Callback.class, new CallbackValidator());
		validateExtensions(model.getComponentsExtensions());
		validateListField("securityRequirements", false, false, SecurityRequirement.class,
				new SecurityRequirementValidator());
		validateListField("tags", false, false, Tag.class, new TagValidator());
		validateField("externalDocs", false, ExternalDocs.class, new ExternalDocsValidator());
		validateExtensions(model.getExtensions());
	}
}
