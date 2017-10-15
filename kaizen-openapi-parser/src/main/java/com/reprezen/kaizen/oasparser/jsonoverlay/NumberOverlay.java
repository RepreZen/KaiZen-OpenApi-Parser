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
package com.reprezen.kaizen.oasparser.jsonoverlay;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;

public class NumberOverlay extends ScalarOverlay<Number> {

	private NumberOverlay(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(json, parent, refReg);
	}

	private NumberOverlay(Number value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
		super(value, parent, refReg);
	}

	@Override
	public Number fromJson(JsonNode json) {
		if (json.isBigDecimal()) {
			return json.decimalValue();
		} else if (json.isBigInteger()) {
			return json.bigIntegerValue();
		}
		// no methods for Byte, even though numberNode(Byte) is provided.
		// experimentations shows that bytes show up as ints. Oh well..
		else if (json.isDouble()) {
			return json.doubleValue();
		} else if (json.isFloat()) {
			return json.floatValue();
		} else if (json.isInt()) {
			return json.intValue();
		} else if (json.isLong()) {
			return json.longValue();
		} else if (json.isShort()) {
			return json.shortValue();
		} else {
			return null;
		}
	}

	@Override
	public JsonNode toJson(SerializationOptions options) {
		if (value == null) {
			return jsonMissing();
		}
		NumberType type = NumberType.of(value);
		if (type == null) {
			throw new IllegalArgumentException(
					"Numeric class " + value.getClass().getName() + " is not representable as a JsonNode");
		} else {
			switch (type) {
			case BigDecimal:
				return jsonScalar((BigDecimal) value);
			case BigInteger:
				return jsonScalar((BigInteger) value);
			case Byte:
				return jsonScalar((Byte) value);
			case Double:
				return jsonScalar((Double) value);
			case Float:
				return jsonScalar((Float) value);
			case Integer:
				return jsonScalar((Integer) value);
			case Long:
				return jsonScalar((Long) value);
			case Short:
				return jsonScalar((Short) value);
			default:
				return jsonMissing();
			}
		}
	}

	public static OverlayFactory<Number, NumberOverlay> factory = new OverlayFactory<Number, NumberOverlay>() {
		@Override
		protected Class<NumberOverlay> getOverlayClass() {
			return NumberOverlay.class;
		}

		@Override
		public NumberOverlay _create(Number value, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new NumberOverlay(value, parent, refReg);
		}

		@Override
		public NumberOverlay _create(JsonNode json, JsonOverlay<?> parent, ReferenceRegistry refReg) {
			return new NumberOverlay(json, parent, refReg);
		}
	};

	private enum NumberType {
		BigDecimal(BigDecimal.class), //
		BigInteger(BigInteger.class), //
		Byte(Byte.class), //
		Double(Double.class), //
		Float(Float.class), //
		Integer(Integer.class), //
		Long(Long.class), //
		Short(Short.class);

		NumberType(Class<? extends Number> cls) {
			this.cls = cls;
		}

		private Class<? extends Number> cls;
		private static Map<Class<? extends Number>, NumberType> typeMap = null;

		private static <T extends Number> NumberType of(T obj) {
			if (typeMap == null) {
				buildTypeMap();
			}
			return typeMap.get(obj.getClass());
		}

		private static void buildTypeMap() {
			typeMap = Maps.newHashMap();
			for (NumberType type : NumberType.values()) {
				typeMap.put(type.cls, type);
			}
		}
	}
}