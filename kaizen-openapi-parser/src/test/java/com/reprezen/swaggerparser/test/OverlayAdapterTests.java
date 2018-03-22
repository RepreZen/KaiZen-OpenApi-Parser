package com.reprezen.swaggerparser.test;

import java.net.URL;
import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.reprezen.jsonoverlay.ListOverlay;
import com.reprezen.jsonoverlay.MapOverlay;
import com.reprezen.jsonoverlay.Overlay;
import com.reprezen.kaizen.oasparser.OpenApiParser;
import com.reprezen.kaizen.oasparser.model3.Info;
import com.reprezen.kaizen.oasparser.model3.OpenApi3;
import com.reprezen.kaizen.oasparser.model3.Operation;
import com.reprezen.kaizen.oasparser.model3.Parameter;
import com.reprezen.kaizen.oasparser.model3.Path;
import com.reprezen.kaizen.oasparser.model3.Response;
import com.reprezen.kaizen.oasparser.model3.Schema;
import com.reprezen.kaizen.oasparser.ovl3.PathImpl;

public class OverlayAdapterTests extends Assert {

	private OpenApi3 model;

	@Before
	public void setup() {
		this.model = parseLocalModel("linksTest");
	}

	@Test
	public void testPropertiesAdapter() {
		assertTrue(model == Overlay.of(model).get());
		assertTrue(model.getInfo() == new Overlay<Info>(model.getInfo()).get());
	}

	@Test
	public void testFieldAdapter() {
		assertEquals(model.getOpenApi(), Overlay.of(model, "openApi", String.class).get());
		@SuppressWarnings("unchecked")
		Map<String, PathImpl> pathsMapOverlay = (Map<String, PathImpl>) Overlay.of(model, "paths", Map.class).get();
		assertTrue(model.getPath("/2.0/users/{username}") == pathsMapOverlay.get("/2.0/users/{username}"));
	}

	@Test
	public void testMapAdapter() {
		Overlay<?> mapOverlay = Overlay.of(model, "paths", Map.class);
		assertTrue(mapOverlay.getMapOverlay() instanceof MapOverlay);
		@SuppressWarnings("unchecked")
		MapOverlay<Path> castMapOverlay = (MapOverlay<Path>) mapOverlay.getMapOverlay();
		Path path = Overlay.of(castMapOverlay, "/2.0/users/{username}").get();
		assertTrue(model.getPath("/2.0/users/{username}") == path);
	}

	@Test
	public void testListAdapter() {
		Operation method = model.getPath("/2.0/repositories/{username}/{slug}").getGet();
		Overlay<?> listOverlay = Overlay.of(method, "parameters", Collection.class);
		assertTrue(listOverlay.getListOverlay() instanceof ListOverlay);
		@SuppressWarnings("unchecked")
		ListOverlay<Parameter> castListOverlay = (ListOverlay<Parameter>) listOverlay.getListOverlay();
		Parameter param = Overlay.of(castListOverlay, 1).get();
		assertTrue(method.getParameter(1) == param);
	}

	@Test
	public void testReferences() {
		// props reference
		Response resp200 = model.getPath("/2.0/users/{username}").getGet().getResponse("200");
		assertFalse(Overlay.of(resp200).isReference("description"));
		assertTrue(Overlay.of(resp200.getContentMediaType("application/json")).isReference("schema"));
		assertEquals("#/components/schemas/user",
				Overlay.of(resp200.getContentMediaType("application/json")).getReference("schema").getRefString());

		// map reference
		assertFalse(Overlay.of(model, "schemas", Schema.class).isReference("user"));
		assertTrue(Overlay.of(model.getSchema("repository").getProperties()).isReference("owner"));
		assertEquals("#/components/schemas/user",
				Overlay.of(model.getSchema("repository").getProperties()).getReference("owner").getRefString());

		// list reference
		Collection<Parameter> params = model.getPath("/2.0/repositories/{username}/{slug}").getGet().getParameters();
		assertFalse(Overlay.of(params).isReference(1));
		assertTrue(Overlay.of(params).isReference(0));
		assertEquals("#/components/parameters/username", Overlay.of(params).getReference(0).getRefString());
	}

	private static OpenApi3 parseLocalModel(String name) {
		URL url = SimpleSerializationTest.class.getResource("/models/" + name + ".yaml");
		return (OpenApi3) new OpenApiParser().parse(url);
	}
}