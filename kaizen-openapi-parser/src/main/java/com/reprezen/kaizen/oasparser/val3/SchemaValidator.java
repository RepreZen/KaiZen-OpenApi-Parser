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

import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.model3.Example;
import com.reprezen.kaizen.oasparser.model3.ExternalDocs;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.model3.Xml;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SchemaValidator extends ObjectValidatorBase<Schema> {

	@Override
	public void runObjectValidations() {
		Schema schema = (Schema) value.getOverlay();
		validateStringField("title", false);
		validateStringField("description", false);
		validateNumericField("maximum", false, null, null);
		validateBooleanField("exclusiveMaximum", false);
		validateNumericField("minimum", false, null, null);
		validateBooleanField("exclusiveMinimum", false);
		validateBooleanField("uniqueItems", false);
		validateBooleanField("nullable", false);
		validateField("example", false, Example.class, new ExampleValidator());
		validateBooleanField("deprecated", false);
		validatePositiveField("multipleOf", false);
		validateNonNegativeField("maxLength", false);
		validateNonNegativeField("minLength", false);
		validatePatternField("pattern", false);
		validateNonNegativeField("maxItems", false);
		validateNonNegativeField("minItems", false);
		validateNonNegativeField("maxProperties", false);
		validateNonNegativeField("minProperties", false);
		validateListField("requiredFields", false, true, String.class, null);
		validateListField("enums", false, true, Object.class, null);
		validateStringField("type", false, "boolean|object|array|number|integer|string");
		{
			SchemaValidator schemaValidator = new SchemaValidator();
			validateListField("allOfSchemas", false, false, Schema.class, schemaValidator);
			validateListField("oneOfSchemas", false, false, Schema.class, schemaValidator);
			validateListField("anyOfSchemas", false, false, Schema.class, schemaValidator);
			validateField("notSchema", false, Schema.class, schemaValidator);
			validateField("itemsSchema", false, Schema.class, schemaValidator);
			validateMapField("properties", false, false, Schema.class, schemaValidator);
		}
		validateFormatField("format", false, schema.getType());
		validateField("defaultValue", false, Object.class, null, field -> checkDefault(field, schema.getType()));
		checkDiscriminator(schema, validateStringField("discriminator", false));
		checkReadWrite(schema);
		validateField("xml", false, Xml.class, new XmlValidator());
		validateField("externalDocs", false, ExternalDocs.class, new ExternalDocsValidator());
		validateMapField("examples", false, false, Example.class, new ExampleValidator());
		validateExtensions(schema.getExtensions());
	}

	private void checkDiscriminator(Schema schema, Overlay<?> context) {
		String discriminator = schema.getDiscriminator();
		if (discriminator != null) {
			if (!schema.getProperties().keySet().contains(discriminator)) {
				results.addError(m.msg("DiscNotProp|The discriminator is not a property of this schema", discriminator),
						context);
			}
			if (!schema.getRequiredFields().contains(discriminator)) {
				results.addError(
						m.msg("DiscNotReq|The discriminator property is not required in this schema", discriminator),
						context);
			}
		}
	}

	private void checkReadWrite(Schema schema) {
		if (schema.isReadOnly() && schema.isWriteOnly()) {
			results.addError(m.msg("ROnlyAndWOnly|Schema cannot be both ReadOnly and WriteOnly"), value);
		}
	}
}
