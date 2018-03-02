package com.reprezen.swaggerparser.test;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Resources;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Schema;

public class Issue131Test extends Assert {

	@Test
	public void testLinks() {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/issue131.yaml"), true);
		assertEquals("SampleData", model.find("/components/schemas/SampleData").getPathInParent());
		assertEquals("MoreData", model.find("/components/schemas/MoreData").getPathInParent());
		Schema direct = model.getSchema("SampleData");
		Schema viaMoreData = model.getSchema("MoreData").getProperty("master");
		Schema viaPath = model.getPath("/sampledatamanagement/v1/sampledata/custom/{id}").getGet().getResponse("200")
				.getContentMediaType("application/json").getSchema();
		assertTrue(direct == viaMoreData);
		assertTrue(direct == viaPath);
	}
}
