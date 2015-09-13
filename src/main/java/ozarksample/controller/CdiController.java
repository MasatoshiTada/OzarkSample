package ozarksample.controller;

import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import ozarksample.dto.UserDto;

@Path("cdi")
@ConversationScoped
public class CdiController implements Serializable {
    
    /**
     * UserDtoには@ConversationScopedが付加されています
     */
    @Inject
    private UserDto userDto;
    
    @GET
    @Controller
    @Path("input1")
    public String input1() {
        userDto.beginConversation();
        return "cdi/input1.jsp";
    }
    
    @POST
    @Controller
    @Path("input2")
    public String input2(@FormParam("name") String name) {
        userDto.setName(name);
        return "cdi/input2.jsp";
    }
    
    @POST
    @Controller
    @Path("result")
    public String result(@FormParam("address") String address) {
        userDto.setAddress(address);
        return "cdi/result.jsp";
    }
    
    @GET
    @Controller
    @Path("end")
    public String end() {
        userDto.endConversation();
        return "cdi/end.jsp";
    }
}
