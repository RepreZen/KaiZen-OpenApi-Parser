package com.reprezen.swaggerparser.test;

import com.google.common.io.Resources;
import com.reprezen.kaizen.oasparser.OpenApi3Parser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidationTest {

	@Test
	public void testLicenceUrl() throws Exception {
		OpenApi3 model = new OpenApi3Parser().parse(Resources.getResource("models/validationTest.yaml"), true);

		assertEquals(1, model.getValidationItems().size());
		assertEquals(7, model.getValidationResults().getItems().iterator().next().getPositionInfo().getLine());
	}
}
