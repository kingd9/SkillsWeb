package net.daneking.skillstool;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("skill")
public class SkillResource {
	private final SkillRepository repository;

	public SkillResource() {
		this.repository = new SkillRepository();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response.ok(repository.getEntity(), MediaType.APPLICATION_JSON).build();
	}
}
