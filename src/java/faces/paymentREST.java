/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author c0687631
 */
@Path("/payments")
public class paymentREST {

    @Inject
    private paymentController paymentController;

    //private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(paymentController.getAllJson()).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) {
        JsonObject json = paymentController.getByIdJason(id);
        if (json != null) {
            return Response.ok(json).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(JsonObject json) {
        return Response.ok(paymentController.addJson(json)).build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response edit(@PathParam("id") int id, JsonObject json) {
        JsonObject jsonWithId = paymentController.editJson(id, json);
        if (jsonWithId != null) {
            return Response.ok(jsonWithId).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response del(@PathParam("id") int id) {
        if (paymentController.deleteById(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
