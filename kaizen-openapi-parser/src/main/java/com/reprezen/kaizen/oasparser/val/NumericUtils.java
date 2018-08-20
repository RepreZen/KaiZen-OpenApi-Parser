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
package com.reprezen.kaizen.oasparser.val;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import com.google.common.collect.Maps;

public class NumericUtils {
	public static boolean isNumeric(Object obj) {
		return NumericType.of(obj) != null;
	}

	public static boolean isIntegral(Object obj) {
		switch (NumericType.of(obj)) {
		case BIG_INTEGER:
		case BYTE:
		case INTEGER:
		case LONG:
		case SHORT:
			return true;
		default:
			return false;
		}
	}

	public static <T extends Number> T zero(T value) {
		Number result;
		switch (NumericType.of(value)) {
		case BIG_DECIMAL:
			result = BigDecimal.ZERO;
			break;
		case BIG_INTEGER:
			result = BigInteger.ZERO;
			break;
		case BYTE:
			result = Byte.valueOf((byte) 0);
			break;
		case DOUBLE:
			result = Double.valueOf(0.0);
			break;
		case FLOAT:
			result = Float.valueOf(0.0f);
			break;
		case INTEGER:
			result = Integer.valueOf(0);
			break;
		case LONG:
			result = Long.valueOf(0L);
			break;
		case SHORT:
			result = Short.valueOf((short) 0);
			break;
		default:
			return null; // shouldn't ever happen
		}
		@SuppressWarnings("unchecked")
		T tResult = (T) result;
		return tResult;
	}

	public static <T extends Number> boolean gt(T x, T y) {
		return compare(x, y) > 0;
	}

	public static <T extends Number> boolean ge(T x, T y) {
		return compare(x, y) >= 0;
	}

	public static <T extends Number> boolean lt(T x, T y) {
		return compare(x, y) < 0;
	}

	public static <T extends Number> boolean le(T x, T y) {
		return compare(x, y) <= 0;
	}

	public static <T extends Number> boolean eq(T x, T y) {
		return compare(x, y) == 0;
	}

	public static <T extends Number> boolean ne(T x, T y) {
		return compare(x, y) != 0;
	}

	public static <T extends Number> boolean isPositive(T x) {
		return gt(x, zero(x));
	}

	public static <T extends Number> boolean isZero(T x) {
		return eq(x, zero(x));
	}

	public static <T extends Number> boolean isNegative(T x) {
		return lt(x, zero(x));
	}

	public static <T extends Number> boolean isNonNegative(T x) {
		return ge(x, zero(x));
	}

	public static <T extends Number> boolean isnonZero(T x) {
		return ne(x, zero(x));
	}

	public static <T extends Number> boolean isNonPostive(T x) {
		return le(x, zero(x));
	}

	public static <T extends Number> int compare(T x, T y) {
		NumericType type = NumericType.of(x);
		if (type != NumericType.of(y)) {
			throw new IllegalArgumentException();
		}
		switch (type) {
		case BIG_DECIMAL:
			return ((BigDecimal) x).compareTo((BigDecimal) y);
		case BIG_INTEGER:
			return ((BigInteger) x).compareTo((BigInteger) y);
		case BYTE:
			return ((Byte) x).compareTo((Byte) y);
		case DOUBLE:
			return ((Double) x).compareTo((Double) y);
		case FLOAT:
			return ((Float) x).compareTo((Float) y);
		case INTEGER:
			return ((Integer) x).compareTo((Integer) y);
		case LONG:
			return ((Long) x).compareTo((Long) y);
		case SHORT:
			return ((Short) x).compareTo((Short) y);
		default:
			throw new IllegalArgumentException();
		}
	}

	enum NumericType {
		BIG_DECIMAL(BigDecimal.class), //
		BIG_INTEGER(BigInteger.class), //
		BYTE(Byte.class), //
		DOUBLE(Double.class), //
		FLOAT(Float.class), //
		INTEGER(Integer.class), //
		LONG(Long.class), //
		SHORT(Short.class);

		private static Map<Class<? extends Number>, NumericType> types;

		private NumericType(Class<? extends Number> cls) {
			register(cls, this);
		}

		private void register(Class<? extends Number> cls, NumericType type) {
			if (NumericType.types == null)
				NumericType.types = Maps.newHashMap();
			types.put(cls, type);
		}

		public static NumericType of(Object value) {
			return value != null ? types.get(value.getClass()) : null;
		}
	}
}
