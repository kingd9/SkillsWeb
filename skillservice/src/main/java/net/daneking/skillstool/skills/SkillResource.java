package net.daneking.skillstool.skills;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(SkillResource.PATH)
public class SkillResource {
	static final String PATH = "skills";
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
