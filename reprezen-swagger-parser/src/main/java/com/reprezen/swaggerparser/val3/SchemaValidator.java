package com.reprezen.swaggerparser.val3;

import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;

public class SchemaValidator extends ObjectValidatorBase<Schema> {

    @Override
    public void validateModel(Schema schema, ValidationResults results) {
        // no validation for: title, description, maximum, exclusiveMaximum, minimum exclusiveMinimum, uniqueItems
        validatePositive(schema.getMultipleOf(), results, false, "multipleOf");
        validateNonNegative(schema.getMaxLength(), results, false, "maxLength");
        validateNonNegative(schema.getMinLength(), results, false, "minLength");
        validatePattern(schema.getPattern(), results, false, "pattern");
        validateNonNegative(schema.getMaximum(), results, false, "maxItems");
        validateNonNegative(schema.getMaximum(), results, false, "minItems");
        validateNonNegative(schema.getMaxProperties(), results, false, "maxProperties");
        validateNonNegative(schema.getMinProperties(), results, false, "minProperties");
        validateUnique(schema.getRequiredFields(), results, "required");
        validateList(schema.getEnums(), schema.hasEnums(), results, false, "enum", null);
        validateNonEmpty(schema.getEnums(), schema.hasEnums(), results, "enum");
        validateUnique(schema.getEnums(), results, "enum");
    }
}
