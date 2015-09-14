package ozarksample.exception.mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider // Auto Discovery対象にする
@ApplicationScoped // ProviderクラスはApplicationScopedが適切
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {

    @Inject
    private Models models;
    
    @Override
    public Response toResponse(Exception exception) {
        models.put("error", exception.getMessage());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("exception/error.jsp")
                .build();
    }
    
}
