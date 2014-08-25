package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource {
	public PersonRespository factory;

	@Path("/{id}")
	@Produces(APPLICATION_JSON)
	public Response get(@PathParam("id") final Long id) {
		return factory.getOne(id);
	}

	@Produces(APPLICATION_JSON)
	public Response get() {
		return factory.getAll();
	}

}
