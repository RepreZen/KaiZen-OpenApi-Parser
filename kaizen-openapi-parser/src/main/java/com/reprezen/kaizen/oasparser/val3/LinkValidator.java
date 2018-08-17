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

import static com.reprezen.kaizen.oasparser.val.Messages.m;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.Header;
import com.reprezen.kaizen.oasparser.model3.Link;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Server;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class LinkValidator extends ObjectValidatorBase<Link> {

    @Inject
    private Validator<Server> serverValidator;

    @Override
    public void validateObject(Link link, ValidationResults results) {
        // TODO: Validate operationRef value (why didn't they must make it a ref
        // object???!)
        Operation op = checkValidOperation(link, results);
        if (op != null) {
            checkParameters(link, op, results);
        }
        
        // TODO I don't see "header" in the spec. Remove it
        //validateMap(link.getHeaders(), results, false, "headers", Regexes.NOEXT_REGEX, headerValidator);
        
        // TODO validate requestBody (which doesn't exist in parser API)
        validateDescription(link.getDescription(), results);
        validateField(link.getServer(), results, false, "server", serverValidator);
        
        validateExtensions(link.getExtensions(), results);
    }

    private Operation checkValidOperation(Link link, ValidationResults results) {
        String opId = link.getOperationId();
        String operationRef = link.getOperationRef();
        Operation op = null;
        if (opId == null && operationRef == null) {
            results.addError(
                    m.msg("NoOpIdNoOpRefInLink|Link must contain eitehr 'operationRef' or 'operationId' properties"));
        } else if (opId != null && operationRef != null) {
            results.addError(
                    m.msg("OpIdAndOpRefInLink|Link may not contain both 'operationRef' and 'operationId' properties"));
        }
        if (opId != null) {
            op = findOperationById(Overlay.of(link).getModel(), opId);
            if (op == null) {
                results.addError(
                        m.msg("OpIdNotFound|OperationId in Link does not identify an operation in the containing model",
                                opId),
                        "operationId");
            }
        }
        String relativePath = getRelativePath(operationRef, results);
        if (relativePath != null) {
            // TODO: the spec says "relative or absolute reference"
            op = findOperationByPath(Overlay.of(link).getModel(), relativePath, results);
            if (op == null) {
                results.addError(
                        m.msg("OpPathNotFound|Relative OperationRef in Link does not identify a GET operation in the containing model",
                                operationRef),
                        "operationRef");
            }
            //
        }
        return op;
    }

    private void checkParameters(Link link, Operation op, ValidationResults results) {
        // TODO Q: parameter name is not sufficient to identify param in
        // operation; will
        // allow if it's unique, warn if
        // it's not
        Map<String, Integer> opParamCounts = getParamNameCounts(op.getParameters());
        for (String paramName : link.getParameters().keySet()) {
            int count = opParamCounts.get(paramName);
            if (count == 0) {
                results.addError(m.msg("BadLinkParam|Link parameter does not appear in linked operation", paramName),
                        paramName);
            } else if (count > 1) {
                results.addWarning(
                        m.msg("AmbigLinkParam|Link parameter name appears more than once in linked operation",
                                paramName),
                        paramName);
            }
        }
    }

    private Operation findOperationById(OpenApi3 model, String operationId) {
        for (Path path : model.getPaths().values()) {
            for (Operation op : path.getOperations().values()) {
                if (operationId.equals(op.getOperationId())) {
                    return op;
                }
            }
        }
        return null;
    }

    private Operation findOperationByPath(OpenApi3 model, String relativePath, ValidationResults results) {
        Path path = model.getPath(relativePath);
        return path != null ? path.getGet(false) : null;
    }

    private String getRelativePath(String operationRef, ValidationResults results) {
        // TODO Q: will braces be pct-encoded as required for URIs?
        if (operationRef != null) {
            results.addWarning("OperationRefUnSupp|Link.operationRef is not yet supported", "operationRef");
        }
        return null;
    }

    private Map<String, Integer> getParamNameCounts(Collection<? extends Parameter> parameters) {
        Map<String, Integer> counts = Maps.newHashMap();
        for (Parameter parameter : parameters) {
            String name = parameter.getName();
            if (counts.containsKey(name)) {
                counts.put(name, 1 + counts.get(name));
            } else {
                counts.put(name, 1);
            }
        }
        return counts;
    }
}
