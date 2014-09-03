package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import util.TestSupport;

public class PersonIntegrationTest extends TestSupport<PersonResource> {
	private static final String PATH = PersonResource.PATH;

	@Before
	public void setup() throws Exception {
		super.setUp();
	}

	@Test
	public void addShouldReturnCreatedStatus() {
		assertThat(postPerson("joe", "king").getStatus(), equalTo(CREATED.getStatusCode()));
	}

	@Test
	public void addShouldReturnLocation() {
		assertThat(postPerson("joe", "king").getLocation(), new IsNotAURIPath("/1"));
	}

	private Response postPerson(final String fname, final String lname) {
		Entity<Person> entity = Entity.entity(new Person(fname, lname), APPLICATION_JSON);
		final Response response = target(PATH).request().post(entity);
		return response;
	}

	@Test
	public void getShouldReturnPerson() {
		final Response response = target(PATH + "/1").request().get(Response.class);
		assertThat(response.readEntity(Person.class), notNullValue());
	}

	@Test
	public void addAndThenGetPerson() {
		final Response response = target(PATH).request().get(Response.class);
		PersonRepresentation representation = response.readEntity(PersonRepresentation.class);
		checkLinks(representation);
		// addLink.getType()
	}

	private void checkLinks(final PersonRepresentation representation) {
		assertThat(representation.getLinks(), notNullValue());
	}
}
