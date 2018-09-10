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

import static com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl.F_encodingProperties;
import static com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl.F_example;
import static com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl.F_examples;
import static com.reprezen.kaizen.oasparser.ovl3.MediaTypeImpl.F_schema;
import static com.reprezen.kaizen.oasparser.val.msg.Messages.msg;
import static com.reprezen.kaizen.oasparser.val3.OpenApi3Messages.EncPropNotSchemaProp;

import java.util.Map;
import java.util.Set;

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.EncodingProperty;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.MediaType;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;

public class MediaTypeValidator extends ObjectValidatorBase<MediaType> {

    @Override
    public void runObjectValidations() {
        MediaType mediaType = (MediaType) value.getOverlay();
        // TODO Q: Should schema be required in media type?
        validateField(F_schema, false, Schema.class, new SchemaValidator());
        validateMapField(F_encodingProperties, false, false, EncodingProperty.class, new EncodingPropertyValidator());
        checkEncodingPropsAreProps(mediaType, results);
        validateExtensions(mediaType.getExtensions());
        Overlay<Map<String, Example>> examples = validateMapField(F_examples, false, false, Example.class,
                new ExampleValidator());
        Overlay<Object> example = validateField(F_example, false, Object.class, null);
        checkExampleExclusion(examples, example);
    }

    void checkEncodingPropsAreProps(MediaType mediaType, ValidationResults results) {
        // TODO Q: do allOf, anyOf, oneOf schemas participate? what about
        // additionalProperties?
        Schema schema = mediaType.getSchema(false);
        if (Overlay.of(schema).isElaborated()) {
            Set<String> propNames = schema.getProperties().keySet();
            Map<String, EncodingProperty> encProps = mediaType.getEncodingProperties();
            for (String encodingPropertyName : encProps.keySet()) {
                if (!propNames.contains(encodingPropertyName)) {
                    results.addError(msg(EncPropNotSchemaProp, encodingPropertyName),
                            Overlay.of(encProps, encodingPropertyName));
                }
            }
        }
    }

    void checkExampleExclusion(Overlay<Map<String, Example>> examples, Overlay<Object> example) {
        boolean examplesPresent = examples != null && examples.isPresent()
                && Overlay.getMapOverlay(examples).size() > 0;
        boolean examplePresent = example != null && example.isPresent();
        if (examplesPresent && examplePresent) {
            results.addError("ExmplExclusion|The 'example' and 'exmaples' properties may not both appear", value);
        }
    }
}
