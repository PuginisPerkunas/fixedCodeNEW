/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DIYProjects.Classes;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Mindaugas Liogys
 */
@Path("/jeep")
public class JeepControlsResource {

    private final Jeep jeep;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JeepControlsResource
     */
    public JeepControlsResource() {
        jeep = Jeep.getInstance();
    }

    @GET
    @Path("/engine/forward")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForwards() {
        try {
            
            return Response.ok().build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    @GET
    @Path("/engine/backward")  
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBackwards() {
        try {
            return Response.ok().build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    @GET
    @Path("/engine/speedup")    
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIncreasedSpeed() {
        try {
            String speed = jeep.speedUp();
            return Response.ok(speed).build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    @GET
    @Path("/engine/chosenspeed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSlowSpeed() {
        try {
            String speed = jeep.ChosenSpeed();
            return Response.ok(speed).build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    @GET
    @Path("/engine/left")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLeft() {
        try {
           // String speed = jeep.Left();
            return Response.ok().build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    @GET
    @Path("/engine/right")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRight() {
        try {
            //String speed = jeep.ChosenSpeed();
            return Response.ok().build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    @GET
    @Path("/engine/speeddown")   
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDecreasedSpeed() {
        try {
            return Response.ok().build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }

    @GET
    @Path("/engine/stop")   
    @Produces(MediaType.APPLICATION_JSON)
    public Response stop() {
        try {
            String speed = jeep.stop();
            return Response.ok(speed).build();
        }
        catch (Exception exc) {
            return Response.serverError().entity(exc.getMessage()).build();
        }
    }
    
    /**
     * POST method for creating an instance of JeepControlResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public JeepControlResource getJeepControlResource(@PathParam("id") String id) {
        return JeepControlResource.getInstance(id);
    }
}
