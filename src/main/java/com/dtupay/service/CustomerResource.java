package com.dtupay.service;

import com.dtupay.app.Customer;
import com.dtupay.database.CustomerAdapter;
import com.dtupay.database.ICustomerAdapter;
import org.wildfly.swarm.config.runtime.SingletonResource;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    ICustomerAdapter c = new CustomerAdapter();

    @GET
    @Path("get/")
    public Response getCustomers() {
        try {
            return Response.ok(c.getAllCustomers()).build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("get/{id}")
    public Response getCustomer(@PathParam("id") String id) {
        if(id == null) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            // String response = sendMessage(message);
            //return Response.status(200).entity(response).build();
            //return Response.status(200).entity(c.getCustomerByCustomerId(id)).build();
            return Response.ok(c.getCustomerByCustomerId(id)).build();
        }
        catch(Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("post")
    public Response postCustomer(Customer customer) {
        if(customer.getName() == null || customer.getId() == null) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            // String response = sendMessage(message);
            return Response.ok(c.createCustomer(customer)).build();
        }
        catch(Exception e) {
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("put/{customer}")
    public Response putCustomer(Customer customer) {
        if(customer.getName() == null || customer.getId() == null) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            return Response.ok(c.updateCustomer(customer)).build();
        }
        catch(Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteCustomer(@PathParam("id") String id) {
        if(id == null) {
            return Response.status(400).entity("Missing parameters.").build();
        }
        try {
            // String response = sendMessage(message);
            //return Response.ok("Delete customers").build();
            //return Response.status(200).entity(response).build();
            c.deleteCustomerByCustomerId(id);
            return Response.ok("Deleted customer").status(200).build();
        }
        catch(Exception e){
            return Response.serverError().build();
        }
    }
}