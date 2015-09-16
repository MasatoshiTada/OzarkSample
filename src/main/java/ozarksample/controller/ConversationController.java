package ozarksample.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import ozarksample.dto.ConversationScopeDto;

@Path("conversation")
@RequestScoped
public class ConversationController {

    @Inject
    private ConversationScopeDto conversationScopeDto;
    
    @PostConstruct
    public void init() {
        System.out.println("===== " + this.getClass().getSimpleName() + ".init()");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("===== " + this.getClass().getSimpleName() + ".destroy()");
    }
    
    @GET
    @Controller
    @Path("input1")
    public String input1() {
        System.out.println("===== input1");
        conversationScopeDto.beginConversation();
        return "conversation/input1.jsp";
    }
    
    @POST
    @Controller
    @Path("input2")
    public String input2(@FormParam("name") String name) {
        System.out.println("===== input2");
        conversationScopeDto.setName(name);
        return "conversation/input2.jsp";
    }
    
    @POST
    @Controller
    @Path("result")
    public String result(@FormParam("address") String address) {
        System.out.println("===== result");
        conversationScopeDto.setAddress(address);
        return "conversation/result.jsp";
    }
    
    @GET
    @Controller
    @Path("end")
    public String end() {
        System.out.println("===== end");
        conversationScopeDto.endConversation();
        return "conversation/end.jsp";
    }
}
