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

import com.google.inject.Inject;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;
import com.reprezen.kaizen.oasparser.val.ValidationResults;
import com.reprezen.kaizen.oasparser.val.Validator;

public class SchemaValidator extends ObjectValidatorBase<Schema> {

	@Inject
	private Validator<Xml> xmlValidator;
	@Inject
	private Validator<ExternalDocs> externalDocsValidator;
	@Inject
	private Validator<Example> exampleValidator;

	@Override
	public void validateObject(Schema schema, ValidationResults results) {
		// no validation for: title, description, maximum, exclusiveMaximum, minimum
		// exclusiveMinimum, uniqueItems,
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
		validateString(schema.getType(), results, false, "boolean|object|array|number|integer|string", "type");
		validateList(schema.getAllOfSchemas(), schema.hasAllOfSchemas(), results, false, "allOf", this);
		validateList(schema.getOneOfSchemas(), schema.hasOneOfSchemas(), results, false, "oneOf", this);
		validateList(schema.getAnyOfSchemas(), schema.hasAnyOfSchemas(), results, false, "anyOf", this);
		if (schema.getNotSchema(false) != null && Overlay.isPresent(schema.getNotSchema(false))) {
			validate(schema.getNotSchema(false), results, "not");
		}
		if (schema.getItemsSchema(false) != null && Overlay.isPresent(schema.getItemsSchema(false))) {
			validate(schema.getItemsSchema(false), results, "items");
		}
		validateMap(schema.getProperties(), results, false, "properties", null, this);
		validateFormat(schema.getFormat(), schema.getType(), results, "format");
		validateDefault(schema.getDefault(), schema.getType(), results, "default");
		checkDiscriminator(schema, results, "discriminator");
		checkReadWrite(schema, results);
		validateField(schema.getXml(false), results, false, "xml", xmlValidator);
		validateField(schema.getExternalDocs(false), results, false, "externalDocs", externalDocsValidator);
		validateMap(schema.getExamples(), results, false, "examples", Regexes.NOEXT_NAME_REGEX, exampleValidator);
		validateExtensions(schema.getExtensions(), results);
	}

	private void checkDiscriminator(Schema schema, ValidationResults results, String crumb) {
		String discriminator = schema.getDiscriminator();
		if (discriminator != null) {
			if (!schema.getProperties().keySet().contains(discriminator)) {
				results.addError(m.msg("DiscNotProp|The discriminator is not a property of this schema", discriminator),
						crumb);
			}
			if (!schema.getRequiredFields().contains(discriminator)) {
				results.addError(
						m.msg("DiscNotReq|The discriminator property is not required in this schema", discriminator),
						crumb);
			}
		}
	}

	private void checkReadWrite(Schema schema, ValidationResults results) {
		if (schema.isReadOnly() && schema.isWriteOnly()) {
			// don't set crumb... this validation involves multiple fields so is tied to
			// schema
			results.addError(m.msg("ROnlyAndWOnly|Schema cannot be both ReadOnly and WriteOnly"));
		}
	}
}
