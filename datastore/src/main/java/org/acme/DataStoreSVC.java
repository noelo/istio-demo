package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/datastore")
public class DataStoreSVC {

    @POST
    @Path("/doPrivWrite/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doPrivWrite(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->DataStorePrivWrite->"));
    }

    @GET
    @Path("/doAuthRead/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doAuthRead() {
        return Uni.createFrom()
                .item("testdata")
                .onItem().transform(x -> x.concat("->DataStoreAuthRead->"));
    }
}
