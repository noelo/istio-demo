package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/eventstore")
public interface EventStoreService {

    @POST
    @Path("/doPrivProduce/{name}")
    public String doPrivProduce(@PathParam("name") String name);

    @GET
    @Path("/doAuthConsume/")
    public String doAuthConsume();
}