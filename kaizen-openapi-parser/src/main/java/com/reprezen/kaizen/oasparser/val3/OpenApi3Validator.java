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

import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_callbacks;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_examples;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_externalDocs;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_headers;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_info;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_links;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_openApi;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_parameters;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_paths;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_requestBodies;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_responses;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_schemas;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_securityRequirements;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_securitySchemes;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_servers;
import static com.reprezen.kaizen.oasparser.ovl3.OpenApi3Impl.F_tags;

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
        validateStringField(F_openApi, true, "3\\.\\d+(\\.\\d+.*)?");
        validateField(F_info, true, Info.class, new InfoValidator());
        validateListField(F_servers, false, false, Server.class, new ServerValidator());
        validateMapField(F_paths, true, false, Path.class, new PathValidator());
        validateExtensions(model.getPathsExtensions());
        validateMapField(F_schemas, false, false, Schema.class, new SchemaValidator());
        validateMapField(F_responses, false, false, Response.class, new ResponseValidator());
        validateMapField(F_parameters, false, false, Parameter.class, new ParameterValidator());
        validateMapField(F_examples, false, false, Example.class, new ExampleValidator());
        validateMapField(F_requestBodies, false, false, RequestBody.class, new RequestBodyValidator());
        validateMapField(F_headers, false, false, Header.class, new HeaderValidator());
        validateMapField(F_securitySchemes, false, false, SecurityScheme.class, new SecuritySchemeValidator());
        validateMapField(F_links, false, false, Link.class, new LinkValidator());
        validateMapField(F_callbacks, false, false, Callback.class, new CallbackValidator());
        validateExtensions(model.getComponentsExtensions());
        validateListField(F_securityRequirements, false, false, SecurityRequirement.class,
                new SecurityRequirementValidator());
        validateListField(F_tags, false, false, Tag.class, new TagValidator());
        validateField(F_externalDocs, false, ExternalDocs.class, new ExternalDocsValidator());
        validateExtensions(model.getExtensions());
    }
}
