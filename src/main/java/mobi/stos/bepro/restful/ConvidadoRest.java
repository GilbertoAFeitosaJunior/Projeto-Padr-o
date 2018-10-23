package mobi.stos.bepro.restful;

import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.bepro.bean.Consultor;
import mobi.stos.bepro.bean.Convidado;
import mobi.stos.bepro.bo.IConsultorBo;
import mobi.stos.bepro.bo.IConvidadoBo;
import mobi.stos.bepro.restful.model.QueryConsultor;
import mobi.stos.bepro.util.Util;
import mobi.stos.bepro.util.consulta.Consulta;
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
@Path("/convidado")
public class ConvidadoRest {

    @Autowired
    private IConvidadoBo convidadoBo;

    @Autowired
    private IConsultorBo consultorBo;

    @Path("/salvar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@Context ServletContext context, Convidado convidado) {
        try {

            Consultor consultor = this.consultorBo.byHash(convidado.getConsultor().getHash());

            if (consultor != null) {
                if (convidado.getFoto() != null) {
                    convidado.setFoto(Util.gerarFoto(context, convidado.getFoto(), "fotos/" + Convidado.class.getSimpleName()));
                }

                convidado.setConsultor(consultor);
                this.convidadoBo.persist(convidado);
                return Response.status(Response.Status.CREATED).build();
            }

            return Response.status(Response.Status.NOT_FOUND).build(); // consultor não encontrado.
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/listar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(QueryConsultor query) {
        try {
            Consulta consulta = new Consulta();
            consulta.addAliasTable("consultor", "consultor", JoinType.INNER_JOIN);
            consulta.setCampo("nome");
            consulta.setValor(query.getQuery());
            consulta.addCriterion(Restrictions.eq("consultor.hash", query.getHash()).ignoreCase());
            consulta.setLimiteResultados(10);
            consulta.setPaginaAtual(query.getPage());
            consulta.addOrder(Order.asc("nome"));
            List<Convidado> convidados = this.convidadoBo.list(consulta);
            return Response.status(Response.Status.OK).entity(convidados).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/id")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsultr(@PathParam("id") Long id) {
        try {
            if (id != null) {
                Convidado convidado = this.convidadoBo.load(id);
                return Response.status(Response.Status.OK).entity(convidado).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
