package com.reprezen.swaggerparser.val3;

import static com.reprezen.swaggerparser.val.Messages.m;

import com.google.inject.Inject;
import com.reprezen.swaggerparser.model3.ExternalDocs;
import com.reprezen.swaggerparser.model3.Schema;
import com.reprezen.swaggerparser.model3.Xml;
import com.reprezen.swaggerparser.val.ObjectValidatorBase;
import com.reprezen.swaggerparser.val.ValidationResults;
import com.reprezen.swaggerparser.val.Validator;

public class SchemaValidator extends ObjectValidatorBase<Schema> {

    @Inject
    private Validator<Xml> xmlValidator;
    @Inject
    private Validator<ExternalDocs> externalDocsValidator;

    @Override
    public void validateObject(Schema schema, ValidationResults results) {
        // no validation for: title, description, maximum, exclusiveMaximum, minimum exclusiveMinimum, uniqueItems,
        // nullable, example, deprecated
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
        validateString(schema.getType(), results, true, "boolean|object|array|number|integer|string", "type");
        validateList(schema.getAllOfSchemas(), schema.hasAllOfSchemas(), results, false, "allOf", this);
        validateList(schema.getOneOfSchemas(), schema.hasOneOfSchemas(), results, false, "oneOf", this);
        validateList(schema.getAnyOfSchemas(), schema.hasAnyOfSchemas(), results, false, "anyOf", this);
        if (schema.getNotSchema() != null && !schema.getNotSchema().isMissing()) {
            validate(schema.getNotSchema(), results, "not");
        }
        if (schema.getItemsSchema() != null && !schema.getItemsSchema().isMissing()) {
            validate(schema.getItemsSchema(), results, "items");
        }
        validateMap(schema.getProperties(), results, false, "properties", Regexes.NOEXT_NAME_REGEX, this);
        validateFormat(schema.getFormat(), schema.getType(), results, "format");
        validateDefault(schema.getDefault(), schema.getType(), results, "default");
        checkDiscriminator(schema, results, "discriminator");
        checkReadWrite(schema, results);
        validateField(schema.getXml(), results, false, "xml", xmlValidator);
        validateField(schema.getExternalDocs(), results, false, "externalDocs", externalDocsValidator);
        validateList(schema.getExamples(), schema.hasExamples(), results, false, "examples", null);
        validateExtensions(schema.getExtensions(), results);
    }

    private void checkDiscriminator(Schema schema, ValidationResults results, String crumb) {
        String discriminator = schema.getDiscriminator();
        if (discriminator != null) {
            if (!schema.getProperties().keySet().contains(discriminator)) {
                results.addError(m.msg("DiscNotProp|The discriminator is not a property of this schema", discriminator),
                        crumb);
            }
        }
        if (!schema.getRequiredFields().contains(discriminator)) {
            results.addError(
                    m.msg("DiscNotReq|The discriminator property is not required in this schema", discriminator),
                    crumb);
        }
    }

    private void checkReadWrite(Schema schema, ValidationResults results) {
        if (schema.isReadOnly() && schema.isWriteOnly()) {
            // don't set crumb... this validation involves multiple fields so is tied to schema
            results.addError(m.msg("ROnlyAndWOnly|Schema cannot be both ReadOnly and WriteOnly"));
        }
    }
}