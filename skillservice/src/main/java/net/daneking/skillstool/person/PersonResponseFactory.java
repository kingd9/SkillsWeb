package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static net.daneking.config.Main.representationFactory;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import net.daneking.config.Main;

import com.theoryinpractise.halbuilder.api.Representation;

public class PersonResponseFactory {
	public Response getOne(final Long id) {
		return Response.ok(find(id), APPLICATION_JSON).build();
	}

	private Response find(final Long id) {
		return Response.ok(new Person()).build();
	}

	public Response getRoot() throws URISyntaxException {
		Representation rep = representationFactory.newRepresentation(Main.makeUri(PersonResource.class));
		rep.withLink("add", "add");
		return Response.ok(rep).build();
	}

	public Response add() {
		return Response.created(buildLocationUrl()).build();

	}

	private URI buildLocationUrl() {
		return UriBuilder.fromUri("/1").build();
	}
}
