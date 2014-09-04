package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path(PersonResource.PATH)
public class PersonResource {
	static final String PATH = "person";
	private final ResponseFactory factory;

	public PersonResource() {
		factory = new ResponseFactory();
	}

	public PersonResource(final ResponseFactory factory) {
		this.factory = factory;
	}

	@GET
	@Path("/{id}")
	@Produces(APPLICATION_JSON)
	public Response get(@PathParam("id") final Long id) {
		return factory.getOne(id);
	}

	@GET
	@Produces(APPLICATION_JSON)
	public Response get() throws URISyntaxException {
		return factory.getRoot();
	}

	@POST
	@Produces(APPLICATION_JSON)
	public Response add() {
		return factory.add();

	}

}
