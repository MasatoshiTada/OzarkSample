package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import ozarksample.dto.RedirectDto;

@Path("redirect")
@RequestScoped
public class RedirectController {
    
    /**
     * RedirectDtoには@RedirectScopedが付いています
     */
    @Inject
    private RedirectDto redirectDto;
    
    @GET
    @Controller
    @Path("input")
    public String input() {
        return "redirect/input.jsp";
    }
    
    @GET
    @Controller
    @Path("result1")
    public String result1(@QueryParam("name") String name) {
        System.out.println("result1");
        redirectDto.setName(name);
        // 指定するパスに「redirect:」接頭辞を付加
        return "redirect:redirect/result2";
    }
    
    @GET
    @Controller
    @Path("result2")
    public String result2() {
        System.out.println("result2");
        return "redirect/result2.jsp";
    }
    
}
