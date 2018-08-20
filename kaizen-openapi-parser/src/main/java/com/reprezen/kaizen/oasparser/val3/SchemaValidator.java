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

import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_allOfSchemas;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_anyOfSchemas;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_defaultValue;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_deprecated;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_description;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_discriminator;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_enums;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_example;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_exclusiveMaximum;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_exclusiveMinimum;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_externalDocs;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_format;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_itemsSchema;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_maxItems;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_maxLength;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_maxProperties;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_maximum;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_minItems;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_minLength;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_minProperties;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_minimum;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_multipleOf;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_notSchema;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_nullable;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_oneOfSchemas;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_pattern;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_properties;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_requiredFields;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_title;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_type;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_uniqueItems;
import static com.reprezen.kaizen.oasparser.ovl3.SchemaImpl.F_xml;
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
		validateStringField(F_title, false);
		validateStringField(F_description, false);
		validateNumericField(F_maximum, false, null, null);
		validateBooleanField(F_exclusiveMaximum, false);
		validateNumericField(F_minimum, false, null, null);
		validateBooleanField(F_exclusiveMinimum, false);
		validateBooleanField(F_uniqueItems, false);
		validateBooleanField(F_nullable, false);
		validateField(F_example, false, Example.class, new ExampleValidator());
		validateBooleanField(F_deprecated, false);
		validatePositiveField(F_multipleOf, false);
		validateNonNegativeField(F_maxLength, false);
		validateNonNegativeField(F_minLength, false);
		validatePatternField(F_pattern, false);
		validateNonNegativeField(F_maxItems, false);
		validateNonNegativeField(F_minItems, false);
		validateNonNegativeField(F_maxProperties, false);
		validateNonNegativeField(F_minProperties, false);
		validateListField(F_requiredFields, false, true, String.class, null);
		validateListField(F_enums, false, true, Object.class, null);
		validateStringField(F_type, false, "boolean|object|array|number|integer|string");
		{
			SchemaValidator schemaValidator = new SchemaValidator();
			validateListField(F_allOfSchemas, false, false, Schema.class, schemaValidator);
			validateListField(F_oneOfSchemas, false, false, Schema.class, schemaValidator);
			validateListField(F_anyOfSchemas, false, false, Schema.class, schemaValidator);
			validateField(F_notSchema, false, Schema.class, schemaValidator);
			validateField(F_itemsSchema, false, Schema.class, schemaValidator);
			validateMapField(F_properties, false, false, Schema.class, schemaValidator);
		}
		validateFormatField(F_format, false, schema.getType());
		validateField(F_defaultValue, false, Object.class, null, field -> checkDefault(field, schema.getType()));
		checkDiscriminator(schema, validateStringField(F_discriminator, false));
		checkReadWrite(schema);
		validateField(F_xml, false, Xml.class, new XmlValidator());
		validateField(F_externalDocs, false, ExternalDocs.class, new ExternalDocsValidator());
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
