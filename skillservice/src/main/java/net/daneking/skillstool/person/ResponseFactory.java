package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;

public class ResponseFactory {

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8080/skillservice/resource";

	// Setup a reusable RepresentationFactory with standard links/settings
	public static final RepresentationFactory representationFactory = new StandardRepresentationFactory().withFlag(
			RepresentationFactory.PRETTY_PRINT).withLink("website", "http://gotohal.net");

	public static URI makeUri(final Class resourceClass) throws URISyntaxException {
		URI href = UriBuilder.fromResource(resourceClass).build();
		return new URI(BASE_URI).resolve(href);
	}

	public Response getOne(final Long id) {
		return Response.ok(find(id), APPLICATION_JSON).build();
	}

	private Response find(final Long id) {
		return Response.ok(new Person()).build();
	}

	public Response getRoot() throws URISyntaxException {
		Representation rep = representationFactory.newRepresentation(makeUri(PersonResource.class));
		rep.withLink("add", "add");
		return Response.ok(rep).links(buildAddLink(), buildAddLink()).build();
	}

	private Link buildAddLink() {
		return Link.fromResource(PersonResource.class).type(HttpMethod.POST).rel("add").build();
	}

	private Link buildSelfLink() {
		return Link.fromResource(PersonResource.class).rel("self").build();
	}

	public Response add() {
		return Response.created(buildLocationUrl()).links(buildSelfLink()).build();

	}

	private URI buildLocationUrl() {
		return UriBuilder.fromUri("/1").build();
	}
}
