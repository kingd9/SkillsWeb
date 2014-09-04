package net.daneking.skillstool.person;

import static com.theoryinpractise.halbuilder.api.RepresentationFactory.HAL_JSON;
import static com.theoryinpractise.halbuilder.api.RepresentationFactory.HAL_XML;

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
	private final PersonResponseFactory factory;

	public PersonResource() {
		factory = new PersonResponseFactory();
	}

	public PersonResource(final PersonResponseFactory factory) {
		this.factory = factory;
	}

	@GET
	@Path("/{id}")
	@Produces({ HAL_JSON, HAL_XML })
	public Response get(@PathParam("id") final Long id) {
		return factory.getOne(id);
	}

	@GET
	@Produces({ HAL_JSON, HAL_XML })
	public Response get() throws URISyntaxException {
		return factory.getRoot();
	}

	@POST
	@Produces({ HAL_JSON, HAL_XML })
	public Response add() {
		return factory.add();

	}

}
