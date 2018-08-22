package com.reprezen.kaizen.oasparser.val;

import com.reprezen.kaizen.oasparser.val.msg.Messages;

public enum BaseValidationMessages implements Messages {
	WrongTypeJson("Incorrect JSON Node type %1; allowed types: %2") //
	;
	private String formatString;

	BaseValidationMessages(String formatString) {
		this.formatString = formatString;
	}

	@Override
	public String getFormatString() {
		return formatString;
	}

}
