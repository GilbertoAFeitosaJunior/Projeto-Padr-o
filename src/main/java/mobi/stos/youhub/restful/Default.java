package mobi.stos.youhub.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/Default")
public class Default {

   

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        try {
            return Response.status(Response.Status.OK).build();
        } catch (Exception e){ 
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
