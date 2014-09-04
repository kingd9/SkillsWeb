package net.daneking.skillstool.person;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

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

	public Response add() {
		return null;

	}

	public ResponseBuilder getResponseOk() {
		return Response.ok();
	}
}
