package ozarksample.exception.mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import ozarksample.exception.MyException;

@Provider // Auto Discovery対象にする
@ApplicationScoped // ProviderクラスはApplicationScopedが適切
public class MyExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<MyException> {

    @Inject
    private Models models;
    
    @Override
    public Response toResponse(MyException exception) {
        models.put("error", exception.getMessage());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("exception/error.jsp")
                .build();
    }
    
}
