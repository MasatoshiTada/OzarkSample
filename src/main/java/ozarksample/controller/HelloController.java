package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("hello")
@RequestScoped // コレをつけないとModelsがDI出来ず実行時例外
public class HelloController {
    
    @Inject
    private Models models;
    
    @GET
    @Controller
    @Path("input")
    public String input() {
        return "hello/input.jsp";
    }
    
    @GET
    @Controller
    @Path("result")
    public String result(@QueryParam("name") String name) {
        models.put("name", name);
        return "hello/result.jsp";
    }
    
}
