package ozarksample.controller;

import org.glassfish.ozark.engine.JspViewEngine;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.mvc.Models;
import javax.mvc.Viewable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("hello")
@RequestScoped // コレをつけないとModelsがDI出来ず実行時例外
public class HelloController {
    
    @Inject
    private Models models;
    
    @GET
    @Controller
    @Path("{name}")
    public String hello(@PathParam("name") String name) {
        models.put("name", name);
        System.out.println("return String");
        return "hello.jsp";
    }
    
// コレでもOK
//    @GET
//    @Controller
//    @Path("{name}")
//    public Viewable hello(@PathParam("name") String name) {
//        models.put("name", name);
//        System.out.println("return Viewable");
//        return new Viewable("hello.jsp", models, JspViewEngine.class);
//    }
    
}
