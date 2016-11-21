package uk.me.paulgarner.fh.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import uk.me.paulgarner.fh.domain.Person;
import uk.me.paulgarner.fh.service.PersonService;

@Path("/person")
@Consumes("application/json")
@Produces("application/json")
public class PersonRESTService {
	
	@Inject
	PersonService personService;
	
	@GET
	@Path("/{id}")
	public Response getPerson(@PathParam("id") String personId) {
		Person result = personService.getById(Long.valueOf(personId));
		
		if (null == result) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(result).build();
		}
    }
	
}
