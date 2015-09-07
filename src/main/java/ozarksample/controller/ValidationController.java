package ozarksample.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.annotation.Controller;
import javax.mvc.Models;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import ozarksample.form.FormBean;

@Path("validation")
@Controller
@RequestScoped
public class ValidationController {
    
    @Inject
    private BindingResult bindingResult;
    
    @Inject
    private Models models;
    
    @GET
    @Path("input")
    public String input() {
        return "validation/input.jsp";
    }
    
    @POST
    @Path("result")
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String result(@Valid @BeanParam FormBean formBean) {
        if (bindingResult.isFailed()) {
            models.put("bindingResult", bindingResult);
            return "validation/input.jsp";
        }
        models.put("name", formBean.getName());
        models.put("age", formBean.getAge());
        return "validation/result.jsp";
    }
    
}
