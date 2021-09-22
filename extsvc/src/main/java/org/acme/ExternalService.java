package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/external")
public class ExternalService {

    @POST
    @Path("/invoke/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invoke(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->external.invoke->"));
    }

    @POST
    @Path("/invokeSecure/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> invokeSecure(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->external.invokeSecure->"));
    }
}
