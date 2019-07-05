package com.reprezen.kaizen.oasparser.val3;

import com.reprezen.kaizen.oasparser.val.msg.Messages;

public enum OpenApi3Messages implements Messages {
	ExmplTwoValues("Example may not specify both a direct value and an external value URL"), //
	ExampleNoValue("Example specifies neither a direct value nor an external value URL"), //
	NonQryAllowRsvd("AllowReserved is ignored for non-query parameter '%1 [%2]'"), //
	IgnContType("Content-Type headers are ignored"), //
	NoOpIdNoOpRefInLink("Link must contain eitehr 'operationRef' or 'operationId' properties"), //
	OpIdAndOpRefInLink("Link may not contain both 'operationRef' and 'operationId' properties"), //
	OpIdNotFound("OperationId in Link does not identify an operation in the containing model"), //
	OpPathNotFound("Relative OperationRef in Link does not identify a GET operation in the containing model"), //
	BadLinkParam("Link parameter does not appear in linked operation"), //
	AmbigLinkParam("Link parameter name appears more than once in linked operation"), //
	OperationRefUnSupp("Link.operationRef is not yet supported"), //
	EncPropNotSchemaProp("Encoding property '%1' does not name a schema property for the media type"), //
	MissingPathTplt("No template for path parameter '%1' in path string"), //
	PathParamReq("Path param '%1' must have 'required' property set true"), //
	DiscNotProp("The discriminator '%1' is not a property of this schema"), //
	DiscNotReq("The discriminator property '%1' must be required in this schema"), //
	ROnlyAndWOnly("Schema cannot be both ReadOnly and WriteOnly"), //
	UnkSecScheme("Security scheme not defined in model: %1");

	private String formatString;

	private OpenApi3Messages(String formatString) {
		this.formatString = formatString;
	}

	@Override
	public String getFormatString() {
		return formatString;
	}

}
