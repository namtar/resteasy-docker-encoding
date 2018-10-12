package de.catcode.test.resteasy.docker;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    @POST
    public Response test(TestPojo testPojo) {
        System.out.println(testPojo.toString());
        return Response.ok().build();
    }
}
