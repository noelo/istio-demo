package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/eventstore")
public class EventStoreSVC {

    @POST
    @Path("/doPrivProduce/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doPrivProduce(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->EventStoreWrite->"));
    }

    @GET
    @Path("/doAuthConsume/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doAuthConsume() {
        return Uni.createFrom()
                .item("testevent")
                .onItem().transform(x -> x.concat("->EventStoreRead->"));
    }
}
