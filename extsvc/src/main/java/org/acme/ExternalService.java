package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/external")
public class ExternalService {

    @POST
    @Path("/invoke/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invoke(@PathParam("args") String args) { 
        return Uni.createFrom()
                .item(args)
                .onItem()
                .transform(x -> "->external.invoke->".concat(args.toUpperCase()));
    }

    @POST
    @Path("/invokeSecure/{args}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invokeSecure(@PathParam("args") String args) {
        return Uni.createFrom()
                .item(args)
                .onItem()
                .transform(x -> "->external.invokeSecure->".concat(args.replaceAll(".*", "*")));
    }
}
