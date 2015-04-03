package ozarksample.controller;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.validation.ValidationResult;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import ozarksample.error.ErrorDataBean;
import ozarksample.form.FormBean;

@Path("valid")
@RequestScoped // コレをつけないとModelsがDI出来ず実行時例外
@Controller
public class ValidationController {
    
    @Inject
    private ValidationResult vr;
    
    @Inject
    private Models models;
    
    @GET
    @Path("index")
    public String index() {
        return "validIndex.jsp";
    }
    
    @POST
    @Path("result")
    @ValidateOnExecution(type = ExecutableType.NONE)
    public String result(@Valid @BeanParam FormBean formBean) {
        if (vr.isFailed()) {
            List<ErrorDataBean> errors = new ArrayList<>();
            for (ConstraintViolation<?> violation : vr) {
                ErrorDataBean error = new ErrorDataBean();
                String message = violation.getMessage();
                System.out.println(message);
                error.setMessage(message);
                errors.add(error);
            }
            models.put("errors", errors);
//            return Response.status(Response.Status.BAD_REQUEST).entity("validIndex.jsp").build();
            models.put("message", "検証エラーですよ");
            return "validIndex.jsp";
        }
        models.put("name", formBean.getName());
        models.put("age", formBean.getAge());
//        return Response.status(Response.Status.OK).entity("validResult.jsp").build();
        return "validResult.jsp";
    }
    
}
