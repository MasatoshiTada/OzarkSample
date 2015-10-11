package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.mvc.Models;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.security.Encoders;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("security")
@RequestScoped
public class SecurityController {
    
    @Inject
    private Models models;
    
    @Inject
    private Encoders encoders;
    
    @GET
    @Controller
    @Path("input")
    public String input() {
        return "security/input.jsp";
    }
    
    @CsrfValid
    @POST
    @Controller
    @Path("result")
    public String result(@FormParam("name") String name) {
        models.put("name", name);
        return "security/result.jsp";
    }
    
}
