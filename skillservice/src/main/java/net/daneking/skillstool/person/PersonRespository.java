package net.daneking.skillstool.person;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.core.Response;

public class PersonRespository {

	public Response getOne(final Long id) {
		return Response.ok(find(id), APPLICATION_JSON).build();
	}

	private Person find(final Long id) {
		return new Person();
	}

	public Response getAll() {
		return null;
	}

}
