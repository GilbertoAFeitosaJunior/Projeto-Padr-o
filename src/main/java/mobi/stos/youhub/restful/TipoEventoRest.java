package mobi.stos.youhub.restful;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.youhub.bean.TipoEvento;
import mobi.stos.youhub.bo.ITipoEventoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/tipoevento")
public class TipoEventoRest {

    private List<TipoEvento> tipoEventos;

    @Autowired
    ITipoEventoBo tipoEventoBo;

    @Path("/delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(TipoEvento tipoEvento) {
        try {
            if (tipoEvento != null && tipoEvento.getId() != null) {
                this.tipoEventoBo.delete(tipoEvento.getId());
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/salvar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(TipoEvento tipoEvento) {
        try {
            if (tipoEvento != null) {
                this.tipoEventoBo.persist(tipoEvento);
                return Response.status(Response.Status.CREATED).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/listar")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        try {
            this.tipoEventos = this.tipoEventoBo.listall();
            return Response.status(Response.Status.OK).entity(this.tipoEventos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
