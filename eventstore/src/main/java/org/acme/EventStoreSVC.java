package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/eventstore")
public class EventStoreSVC {

    @POST
    @Path("/persist/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> persist(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->eventstore.persist->"));
    }

    @GET
    @Path("/read/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> read() {
        return Uni.createFrom()
                .item("testevent")
                .onItem().transform(x -> x.concat("->eventstore.retrieve->"));
    }
}
