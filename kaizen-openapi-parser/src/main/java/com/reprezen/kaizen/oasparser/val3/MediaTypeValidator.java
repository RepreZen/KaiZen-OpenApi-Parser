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

import java.util.Set;

import com.google.inject.Inject;
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class MediaTypeValidator extends ObjectValidatorBase<MediaType> {

    @Inject
    private Validator<Schema> schemaValidator;
    @Inject
    private Validator<EncodingProperty> encodingPropertyValidator;

    @Override
    public void validateObject(MediaType mediaType, ValidationResults results) {
        // no validation for: example, examples
        // TODO Q: Should schema be required in media type?
        validateField(mediaType.getSchema(), results, false, "schema", schemaValidator);
        validateMap(mediaType.getEncodingProperties(), results, false, "encoding", Regexes.NOEXT_NAME_REGEX,
                encodingPropertyValidator);
        checkEncodingPropsAreProps(mediaType, results);
        validateExtensions(mediaType.getExtensions(), results);
    }

    void checkEncodingPropsAreProps(MediaType mediaType, ValidationResults results) {
        // TODO Q: do allOf, anyOf, oneOf schemas participate? what about additionalProperties?
        Set<String> propNames = mediaType.getSchema().getProperties().keySet();
        for (String encodingPropertyName : mediaType.getEncodingProperties().keySet()) {
            if (!propNames.contains(encodingPropertyName)) {
                results.addError(
                        m.msg("EncPropNotSchemaProp|Encoding property does not name a schema property for the media type",
                                encodingPropertyName),
                        encodingPropertyName);
            }
        }
    }
}
