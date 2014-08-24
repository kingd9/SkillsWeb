package net.daneking.skillstool;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class SkillResourceTest {

	@InjectMocks
	private SkillResource resource;
	private Response response;
	@Mock
	private SkillRepository repository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getShouldReturnResponse() {
		assertNotNull(resource.get());
	}

	private <T> void assertNotNull(final T entity) {
		assertThat(entity, notNullValue());
	}

}
