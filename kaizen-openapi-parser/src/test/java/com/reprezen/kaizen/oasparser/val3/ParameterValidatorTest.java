package com.reprezen.kaizen.oasparser.val3;

import static com.reprezen.kaizen.oasparser.val.msg.Messages.msg;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.reprezen.kaizen.oasparser.OpenApi3Parser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;

public class ParameterValidatorTest {

	@Test
	public void shouldFail_OnPathParamNotRequired() throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(getClass().getResource("/models/params/pathParamNotRequired.yaml"),
				true);

		assertEquals(1, model.getValidationItems().size());
		assertEquals(msg(OpenApi3Messages.PathParamReq, "id"),
				model.getValidationItems().stream().findFirst().get().getMsg());
		assertFalse(model.isValid());
	}

	@Test
	public void shouldFail_OnInvalidParam() throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(getClass().getResource("/models/params/invalidParam.yaml"), true);

		assertEquals(1, model.getValidationItems().size());
		assertEquals(msg(OpenApi3Messages.MissingPathTplt, "id", "/"),
				model.getValidationItems().stream().findFirst().get().getMsg());
		assertFalse(model.isValid());
	}

	@Test
	public void shouldPass_OnValidParam() throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(getClass().getResource("/models/params/validParam.yaml"), true);

		assertEquals(0, model.getValidationItems().size());
		assertTrue(model.isValid());
	}

	@Test
	public void shouldAllow_HybridPathParam() throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(getClass().getResource("/models/params/hybridParam.yaml"), true);

		assertEquals(0, model.getValidationItems().size());
		assertTrue(model.isValid());
	}

	@Test
	public void shouldAllow_MultiHybridPathParam() throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(getClass().getResource("/models/params/multiHybridParam.yaml"),
				true);

		assertEquals(0, model.getValidationItems().size());
		assertTrue(model.isValid());
	}

}
