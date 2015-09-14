package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import ozarksample.exception.MyException;

@Path("exception")
@RequestScoped
public class ExceptionController {
    
    @Inject
    private Models models;
    
    @GET
    @Controller
    @Path("input")
    public String input() {
        return "exception/input.jsp";
    }
    
    @GET
    @Controller
    @Path("result")
    public String result(@QueryParam("name") String name) throws Exception {
        int length = name.length();
        if (length == 0) {
            throw new Exception("Exceptionが発生しました。");
        } else if (length == 1) {
            throw new MyException("MyExceptionが発生しました。");
        }
        models.put("name", name);
        return "exception/result.jsp";
    }
    
}
