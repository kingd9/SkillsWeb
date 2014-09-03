package net.daneking.skillstool.skills;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import util.TestSupport;

public class SkillIntegrationTest extends TestSupport<SkillResource> {

	private static final String PATH = SkillResource.PATH;
	private Response expectedResponse;

	@Before
	public void setup() throws Exception {
		super.setUp();
		expectedResponse = getSkillResponse();
	}

	@Test
	public void GETRequestIsNotNull() {
		assertThat(expectedResponse, notNullValue());
	}

	@Test
	public void GETRequestReturnsSkillResource() {
		Skill resource = getSkillResponse().readEntity(Skill.class);
		assertThat(resource, notNullValue());
	}

	private Response getSkillResponse() {
		final Response expected = target(PATH).request().get(Response.class);

		return expected;
	}
}
