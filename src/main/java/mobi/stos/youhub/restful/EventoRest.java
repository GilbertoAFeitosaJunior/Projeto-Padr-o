package mobi.stos.youhub.restful;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.bo.IEventoBo;
import mobi.stos.youhub.bo.ITipoEventoBo;
import mobi.stos.youhub.restful.model.Query;
import mobi.stos.youhub.util.consulta.Consulta;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/evento")
public class EventoRest {

   
    private List<Evento> eventos;

    @Autowired
    ITipoEventoBo tipoEventoBo;

    @Autowired
    IEventoBo eventoBo;

    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Evento evento) {
        try {
            if (evento != null && evento.getId() != null) {
                this.eventoBo.delete(evento.getId());
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/cadastrar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Evento evento) {
        try {
            if (evento != null) {
                this.eventoBo.persist(evento);
                return Response.status(Response.Status.CREATED).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/lista")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(Query query) {//id to tipo de evento.
        try {
            Consulta consulta = new Consulta();
            consulta.addAliasTable("tipoEvento", "tipoEvento", JoinType.INNER_JOIN);
            consulta.setCampo("titulo");
            consulta.setValor(query.getQuery());
            consulta.addCriterion(Restrictions.eq("tipoEvento.id", query.getId()));
            consulta.setLimiteResultados(10);
            consulta.setPaginaAtual(query.getPage());
            consulta.addOrder(Order.asc("dataInicio"));
            this.eventos = this.eventoBo.list(consulta);
            return Response.status(Response.Status.OK).entity(this.eventos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/carregar/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response carregar(@PathParam("id") long id) {
        try {
            Evento evento = this.eventoBo.load(id);
            if (evento != null) {
                return Response.status(Response.Status.OK).entity(evento).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
