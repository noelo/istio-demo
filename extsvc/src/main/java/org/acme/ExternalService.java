package org.acme;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/external")
public class ExternalService {

    @GET
    @Path("/doAuthCallExternal/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> doAuthCallExternal(@PathParam("name") String name) {
        return Uni.createFrom()
                .item(name)
                .onItem()
                .transform(x -> x.concat("->ExtSvcAuthCallExternal->"));
    }
}
