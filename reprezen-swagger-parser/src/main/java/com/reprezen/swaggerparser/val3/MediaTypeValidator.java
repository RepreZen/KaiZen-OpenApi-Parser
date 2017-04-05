package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.util.Set;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.EncodingProperty;
import com.reprezen.swaggerparser.model3.MediaType;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

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
