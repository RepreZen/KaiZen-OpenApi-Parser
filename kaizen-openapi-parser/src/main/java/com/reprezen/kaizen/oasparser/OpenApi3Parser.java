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
package com.reprezen.kaizen.oasparser;

import java.io.File;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;

public class OpenApi3Parser extends OpenApiParser {

	@Override
	public OpenApi3 parse(String spec, URL resolutionBase) {
		return (OpenApi3) super.parse(spec, resolutionBase);
	}

	@Override
	public OpenApi3 parse(String spec, URL resolutionBase, boolean validate) {
		return (OpenApi3) super.parse(spec, resolutionBase, validate);
	}

	@Override
	public OpenApi3 parse(File specFile) throws Exception {
		return (OpenApi3) super.parse(specFile);
	}

	@Override
	public OpenApi3 parse(File specFile, boolean validate) throws Exception {
		return (OpenApi3) super.parse(specFile, validate);
	}

	@Override
	public OpenApi3 parse(URI uri) throws Exception {
		return (OpenApi3) super.parse(uri);
	}

	@Override
	public OpenApi3 parse(URI uri, boolean validate) throws Exception {
		return (OpenApi3) super.parse(uri, validate);
	}

	@Override
	public OpenApi3 parse(URL resolutionBase) throws Exception {
		return (OpenApi3) super.parse(resolutionBase);
	}

	@Override
	public OpenApi3 parse(URL resolutionBase, boolean validate) throws Exception {
		return (OpenApi3) super.parse(resolutionBase, validate);
	}

	@Override
	public OpenApi3 parse(JsonNode tree, URL resolutionBase) {
		return (OpenApi3) super.parse(tree, resolutionBase);
	}

	@Override
	public OpenApi3 parse(JsonNode tree, URL resolutionBase, boolean validate) {
		return (OpenApi3) super.parse(tree, resolutionBase, validate);
	}

	@Override
	protected boolean isVersion3(JsonNode tree) {
		return true; // if 'openapi' property is missing or incorrect, that will
		// show up as a
		// validation error
	}
}
