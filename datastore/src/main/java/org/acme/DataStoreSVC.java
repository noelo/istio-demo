package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/datastore")
public class DataStoreSVC {

    @POST
    @Path("/persist/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> persist(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->dataStore.persist->"));
    }

    @GET
    @Path("/retrieve/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> read() {
        return Uni.createFrom()
                .item("testdata")
                .onItem().transform(x -> x.concat("->dataStore.retrieve->"));
    }
}
