package net.daneking.skillstool.person;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.theoryinpractise.halbuilder.api.Representation;

public class PersonResponseFactoryTest {

	private static final long INVALID_ID = -1L;
	private static final long VALID_ID = 1L;

	@InjectMocks
	@Spy
	private PersonResponseFactory underTest;
	@Mock
	private Representation representation;
	@Mock
	private ResponseBuilder responseBuilder;
	@Mock
	private PersonRepository repository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getRootShouldCreateResponse() {
		assertThat(underTest.getRoot(), not(nullValue()));
	}

	@Test
	public void getRootShouldCallResponseBuilderBuild() {
		setupResponseBuilder(representation);
		underTest.getRoot();
		assertResponseBuilderBuilds();
	}

	@Test
	public void getOneShouldCallFind() {
		underTest.getOne(1L);
		verify(repository).find(anyLong());
	}

	@Test
	public void getOneShouldCallResponseBuilder() {
		setupResponseBuilder(representation);
		underTest.getRoot();
		assertResponseBuilderBuilds();

	}

	@Test
	public void addShouldCallAdd() {
		underTest.add(new Person());
		verify(repository).add(anyPerson());
	}

	@Test
	public void addWithInvalidIdShouldHaveError() {
		setupAdd(INVALID_ID);
		setupServerError();
		underTest.add(new Person());
		assertResponseBuilderBuilds();

	}

	@Test
	public void addWithValidIdShouldHaveCreated() {
		setupAdd(VALID_ID);
		doReturn(responseBuilder).when(underTest).getCreatedResponse(VALID_ID);
		underTest.add(new Person());
		assertResponseBuilderBuilds();

	}

	private void setupAdd(final long id) {
		when(repository.add(anyPerson())).thenReturn(id);
	}

	private void setupServerError() {
		doReturn(responseBuilder).when(underTest).getResponseStatus(Response.Status.INTERNAL_SERVER_ERROR);
	}

	private Person anyPerson() {
		return any(Person.class);
	}

	private void assertResponseBuilderBuilds() {
		verify(responseBuilder).build();
	}

	private void setupResponseBuilder(final Representation representation) {
		doReturn(responseBuilder).when(underTest).getResponseOk();
		doReturn(responseBuilder).when(responseBuilder).entity(representation);
	}

}
