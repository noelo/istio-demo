package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/external")
public interface ExternalService {
    @GET
    @Path("/doAuthCallExternal/{name}")
    public String doAuthCallExternal(@PathParam("name") String name);
}