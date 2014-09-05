package net.daneking.skillstool.person;

import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import com.theoryinpractise.halbuilder.api.Representation;

class PersonResponseFactory {
	private final Representation representation;
	private final PersonRepository repository;

	public PersonResponseFactory(final Representation representation, final PersonRepository repository) {
		this.representation = representation;
		this.repository = repository;
	}

	public Response getRoot() {
		return getResponseOk().entity(this.representation).build();
	}

	public Response getOne(final Long id) {
		return getResponseOk().entity(repository.find(id)).build();

	}

	public Response add(final Person person) {
		long id = repository.add(person);
		if (isValidId(id)) {
			return getCreatedResponse(id).build();
		}
		return getResponseStatus(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

	ResponseBuilder getCreatedResponse(final long id) {
		return Response.created(buildPersonUri(id));
	}

	ResponseBuilder getResponseStatus(final Response.Status status) {
		return Response.status(status);
	}

	private boolean isValidId(final long id) {
		return id > 0;
	}

	private URI buildPersonUri(final long id) {
		return UriBuilder.fromPath("/" + id).build();
	}

	public ResponseBuilder getResponseOk() {
		return Response.ok();
	}

}
