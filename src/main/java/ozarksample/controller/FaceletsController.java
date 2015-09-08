package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("facelets")
@RequestScoped
public class FaceletsController {
    @Inject
    private Models models;

    @GET
    @Path("input")
    @Controller
    public String input() {
        return "facelets/input.xhtml";
    }
    
    @POST
    @Path("result")
    @Controller
    public String result(@FormParam("name") String name) {
        System.out.println(this.getClass().getSimpleName() + ".result()");
        System.out.println("name = " + name);
        models.put("name", name);
        return "facelets/result.xhtml";
    }
    
    @GET
    @Path("input-get")
    @Controller
    public String inputGet() {
        return "facelets/input-get.xhtml";
    }
    
    @GET
    @Path("result-get")
    @Controller
    public String resultGet(@QueryParam("name") String name) {
        System.out.println("name = " + name);
        models.put("name", name);
        return "facelets/result-get.xhtml";
    }
    
}
