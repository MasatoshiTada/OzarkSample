package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("thymeleaf")
@RequestScoped
public class ThymeleafController {
    @Inject
    private Models models;

    @GET
    @Path("input")
    @Controller
    public String input() {
        return "thymeleaf/input.html";
    }
    
    @POST
    @Path("result")
    @Controller
    public String result(@FormParam("name") String name) {
        models.put("name", name);
        return "thymeleaf/result.html";
    }
    
}
