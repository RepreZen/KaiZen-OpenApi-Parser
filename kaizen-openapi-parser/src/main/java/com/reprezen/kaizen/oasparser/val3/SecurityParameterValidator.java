package com.reprezen.kaizen.oasparser.val3;

import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SecurityParameterValidator extends ObjectValidatorBase<SecurityParameter> {

	@Override
	public void runObjectValidations() {
		validateListField("parameters", false, false, String.class, null);
	}
}
