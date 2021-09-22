package org.acme.rest.client;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/external")
public interface ExternalService {
    @POST
    @Path("/invoke/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invoke(@PathParam("name") String name);

}