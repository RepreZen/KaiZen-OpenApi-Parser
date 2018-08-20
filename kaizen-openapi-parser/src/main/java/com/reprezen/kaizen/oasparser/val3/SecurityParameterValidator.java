package com.reprezen.kaizen.oasparser.val3;

import static com.reprezen.kaizen.oasparser.ovl3.SecurityParameterImpl.F_parameters;

import com.reprezen.kaizen.oasparser.model3.SecurityParameter;
import com.reprezen.kaizen.oasparser.val.ObjectValidatorBase;

public class SecurityParameterValidator extends ObjectValidatorBase<SecurityParameter> {

	@Override
	public void runObjectValidations() {
		validateListField(F_parameters, false, false, String.class, null);
	}
}
