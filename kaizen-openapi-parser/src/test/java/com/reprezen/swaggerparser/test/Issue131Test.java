package com.reprezen.swaggerparser.test;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.io.Resources;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Schema;

public class Issue131Test extends Assert {

	@Test
	public void testSchemaRefs() {
		OpenApi3 model = (OpenApi3) new OpenApiParser().parse(Resources.getResource("models/issue131.yaml"), true);
		assertEquals("SampleData", Overlay.getPathInParent(Overlay.find(model, "/components/schemas/SampleData")));
		assertEquals("MoreData",Overlay.getPathInParent(Overlay.find(model,"/components/schemas/MoreData")));
		Schema direct = model.getSchema("SampleData");
		Schema viaMoreData = model.getSchema("MoreData").getProperty("master");
		Schema viaPath = model.getPath("/sampledatamanagement/v1/sampledata/custom/{id}").getGet().getResponse("200")
				.getContentMediaType("application/json").getSchema();
		assertTrue(direct == viaMoreData);
		assertTrue(direct == viaPath);
	}
}
