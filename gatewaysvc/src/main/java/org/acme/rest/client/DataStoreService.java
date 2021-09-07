package org.acme.rest.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/datastore")
public interface DataStoreService {

    @POST
    @Path("/doPrivWrite/{name}")
    public String doPrivWrite(@PathParam("name") String name);

    @GET
    @Path("/doAuthRead/")
    public String doAuthRead();
}