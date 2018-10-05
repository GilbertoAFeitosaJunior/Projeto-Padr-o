package mobi.stos.bepro.restful;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.bepro.bean.Evento;
import mobi.stos.bepro.bean.TipoEvento;
import mobi.stos.bepro.bo.IEventoBo;
import mobi.stos.bepro.bo.ITipoEventoBo;
import mobi.stos.bepro.restful.model.Query;
import mobi.stos.bepro.util.consulta.Consulta;
import org.hibernate.criterion.Order;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/consultor")
public class TipoEventoRest {

    @Autowired
    ITipoEventoBo tipoEventoBo;

    @Path("/cadastrar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(TipoEvento tipoEvento) {
        try {
            if (tipoEvento != null) {
                this.tipoEventoBo.persist(tipoEvento);
                return Response.status(Response.Status.CREATED).build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();

        }
    }

    @Path("/carregar/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response carregar(@PathParam("id") long id) {
        try {
            TipoEvento tipoEvento = this.tipoEventoBo.load(id);
            if (tipoEvento != null) {
                return Response.status(Response.Status.OK).entity(tipoEvento).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/listar")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        try {
            List<TipoEvento> tipoEventos = this.tipoEventoBo.listall();
            return Response.status(Response.Status.OK).entity(tipoEventos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
