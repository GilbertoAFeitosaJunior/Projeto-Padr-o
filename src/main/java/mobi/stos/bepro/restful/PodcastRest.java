package mobi.stos.bepro.restful;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.bepro.bean.Podcast;
import mobi.stos.bepro.bo.IPodcastBo;
import mobi.stos.bepro.restful.model.Query;
import mobi.stos.bepro.util.consulta.Consulta;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/podcast")
public class PodcastRest {

    @Autowired
    IPodcastBo podcastBo;

    @Path("/lista")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(Query query) {
        try {
            Consulta consulta = new Consulta();
            consulta.setCampo("titulo");
            consulta.setValor(query.getQuery());
            consulta.setLimiteResultados(10);
            consulta.addCriterion(Restrictions.ge("dataExibicao", new Date()));
            consulta.setPaginaAtual(query.getPage());
            consulta.addOrder(Order.desc("dataCriacao"));
            List<Podcast> podcasts = this.podcastBo.list(consulta);

            return Response.status(Response.Status.OK).entity(podcasts).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
