package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/gateway")
public class Gateway {

    @GET
    @Path("/doUnauthAction/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doUnauth(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->GWUnauth->"));
    }

    @GET
    @Path("/doAuthAction/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doAuth(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem().transform(x -> x.concat("->GWAuth->"));
    }

    @POST
    @Path("/doPrivAuthAction/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doPrivAuth(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem().transform(x -> x.concat("->GWPrivAuth->"));
    }
}
