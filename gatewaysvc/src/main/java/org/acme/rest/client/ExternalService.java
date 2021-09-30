package org.acme.rest.client;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/external")
@RegisterRestClient
public interface ExternalService {
    @POST
    @Path("/invoke/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invoke(@PathParam("args") String args);

    @POST
    @Path("/invokeSecure/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invokeSecure(@PathParam("args") String args);

}