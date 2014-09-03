package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class PersonRespository {

	public Response getOne(final Long id) {
		return Response.ok(find(id), APPLICATION_JSON).build();
	}

	private Response find(final Long id) {
		return Response.ok(new Person()).build();
	}

	public Response getRoot() {
		return Response.ok(new Person()).links(buildAddLink(), buildAddLink()).build();
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
