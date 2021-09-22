package org.acme.rest.client;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/datastore")
public interface DataStoreService {

    @POST
    @Path("/persist/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> persist(@PathParam("name") String name);

    @GET
    @Path("/retrieve/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> read();
}