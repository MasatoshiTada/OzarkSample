package ozarksample.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import ozarksample.dto.RequestScopeDto;

@Path("cdi")
@RequestScoped
public class CdiController {
    
    @Inject
    private RequestScopeDto dto;
    
    @GET
    @Controller
    @Path("input")
    public String input() {
        return "cdi/input.jsp";
    }
    
    @GET
    @Controller
    @Path("result")
    public String result(@QueryParam("name") String name) {
        dto.setName(name);
        return "cdi/result.jsp";
    }
    
}
