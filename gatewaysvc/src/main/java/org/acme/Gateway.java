package org.acme;

import org.eclipse.microprofile.reactive.messaging.Channel;
import io.smallrye.mutiny.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.acme.rest.client.DataStoreService;
import org.acme.rest.client.ExternalService;

@Path("/gateway")
public class Gateway {

    @Inject
    Logger log;

    @Inject
    @RestClient
    DataStoreService dsSVC;

    @Inject
    @RestClient
    ExternalService extSVC;

    @Inject
    @Channel("auditlogs")
    Multi<String> logs;

    @GET
    @Path("/items/")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> getItems() {
        return dsSVC.read().onItem().transform(x -> "->gateway.getItems->".concat(x));
    }

    @POST
    @Path("/items/{item}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> createItem(@PathParam("item") String item) {
        return Uni.createFrom().item(item).onItem().transform(x -> x.concat("->gateway->createItem"));
    }

    @POST
    @Path("/invokeSvc/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invokeSVC(@PathParam("args") String args) {
        return extSVC.invoke(args).onItem().transform(x -> "->gateway.invokeSVC->".concat(args).concat(x));
    }

    @GET
    @Path("/auditlog")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Uni<String> getAuditLog() {
        return Uni.createFrom().item("auditlog").onItem().transform(x -> x.concat("->gateway.getAuditLog->"));
    }
}
