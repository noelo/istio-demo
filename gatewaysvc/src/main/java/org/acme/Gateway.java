package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/gateway")
public class Gateway {

    @GET
    @Path("/items/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getItems() {
        return Uni.createFrom()
                .item("getitems")
                .onItem()
                .transform(x -> x.concat("->gateway.getItems->"));
    }

    @POST
    @Path("/items/{item}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> createItem(@PathParam("item") String item) {
        return Uni.createFrom()
                .item(item)
                .onItem()
                .transform(x -> x.concat("->gateway->createItem"));
    }

    @POST
    @Path("/invokeSvc/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invokeSVC() {
        return Uni.createFrom()
                .item("invokeSVC")
                .onItem().transform(x -> x.concat("->gateway.invokeSVC->"));
    }

    @GET
    @Path("/auditlog")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getAuditLog() {
        return Uni.createFrom()
                .item("auditlog")
                .onItem().transform(x -> x.concat("->gateway.getAuditLog->"));
    }
}
