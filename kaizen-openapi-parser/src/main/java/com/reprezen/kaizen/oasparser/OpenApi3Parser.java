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

	private OpenApiParser parser = new OpenApiParser() {

		@Override
		protected boolean isVersion3(JsonNode tree) {
			return true;
		}
	};

	public OpenApi3 parse(String spec, URL resolutionBase) {
		return (OpenApi3) parser.parse(spec, resolutionBase);
	}

	public OpenApi3 parse(String spec, URL resolutionBase, boolean validate) {
		return (OpenApi3) parser.parse(spec, resolutionBase, validate);
	}

	public OpenApi3 parse(File specFile) {
		return (OpenApi3) parser.parse(specFile);
	}

	public OpenApi3 parse(File specFile, boolean validate) {
		return (OpenApi3) parser.parse(specFile, validate);
	}

	public OpenApi3 parse(URI uri) {
		return (OpenApi3) parser.parse(uri);
	}

	public OpenApi3 parse(URI uri, boolean validate) {
		return (OpenApi3) parser.parse(uri, validate);
	}

	public OpenApi3 parse(URL resolutionBase) {
		return (OpenApi3) parser.parse(resolutionBase);
	}

	public OpenApi3 parse(URL resolutionBase, boolean validate) {
		return (OpenApi3) parser.parse(resolutionBase, validate);
	}
}
