package com.merchant.service;

import com.merchant.manager.MerchantManager;
import com.merchant.manager.IMerchantManager;
import org.json.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * @author Ismael
 * defines path for merchant
 */
@Path("/merchant")

/**
 * to produce file in json format
 */
@Produces("application/json")

/**
 * class to handle merchant using rest services
 */
public class MerchantResource {

    private static IMerchantManager m = new MerchantManager();

    /**
     * shows response about retrieval of information for all merchants using GET request
     * @return response
     */
    @GET
    public Response getMerchants() {
        try {
            return Response.ok(m.getAllMerchants()).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(
                    e.getMessage()).build();
        }
    }

    /**
     * shows information about merchant of a particular id using GET request
     * @param id
     * @return response for a merchant
     */

    @GET
    @Path("{id}")
    public Response getMerchant(@PathParam("id") int id) {
        if (id == 0) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            //return Response.ok("Get merchants").build();
            //return Response.status(200).entity(response).build();
            //return Response.status(200).entity("Get merchants").build();
            return Response.ok(m.getMerchantByMerchantId(id)).build();
        }
        catch(Exception e) {
            return Response.status(400).build();
        }
    }

    /**
     * updates the merchant using POST request
     * @param json
     * @return the update response
     */

    @POST
    @Consumes("application/json")
    public Response postMerchant(String json) {
        JSONObject obj = new JSONObject(json);
        String cvr = obj.getString("cvr");
        String name = obj.getString("name");

        if (cvr == null || name == null) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            //String response = sendMessage(message);
            //return Response.status(200).entity(response).build();
            return Response.accepted(m.createMerchant(cvr, name)).build();
        }
        catch(Exception e) {
            return Response.status(400).build();
        }
    }

    /**
     * updates the merchant using PUT request
     * @param json
     * @return the update response
     */
    @PUT
    @Consumes("application/json")
    public Response putMerchant(String json) {
        JSONObject obj = new JSONObject(json);
        int id = obj.getInt("id");
        String cvr = obj.getString("cvr");
        String name = obj.getString("name");

        if (cvr == null || id == 0 || name == null) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            return Response.ok(m.updateMerchant(id, cvr, name)).build();
        }
        catch(Exception e) {
            return Response.status(400).build();
        }
    }

    /**
     * deletes the merchant using merchant id
     * @param id
     * @return response about deletion
     */
    @DELETE
    @Path("{id}")
    public Response deleteMerchant(@PathParam("id") int id) {
        if (id == 0) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            // String response = sendMessage(message);
            //return Response.ok("Deleted merchants").build();
            //return Response.status(200).entity(response).build();
            m.deleteMerchantByMerchantId(id);
            return Response.ok("Deleted merchants").build();
        }
        catch(Exception e) {
            return Response.status(400).build();
        }
    }
}

