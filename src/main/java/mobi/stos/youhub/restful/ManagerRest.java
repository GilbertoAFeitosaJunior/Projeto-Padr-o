package mobi.stos.youhub.restful;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bo.IIngressoBo;
import mobi.stos.youhub.bo.IManagerBo;
import mobi.stos.youhub.restful.model.IngressoHelper;
import mobi.stos.youhub.restful.model.QueryConvidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gilberto
 */
@Component
@Path("/manager")
public class ManagerRest {

    @Autowired
    private IIngressoBo ingressoBo;

    @Autowired
    private IManagerBo managerBo;

    private List<Consultor> consultors;

    @Path("/totalconsultor")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalconsultor(IngressoHelper ingressoHelper) {
        try {
            Long total = this.ingressoBo.totalConsultorNoEvento(ingressoHelper.getIdEvento(), ingressoHelper.getIdManager());
            return Response.status(Response.Status.OK).entity(total).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/totalconvidado/{idEvento}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalconsultor(@PathParam("idEvento") Long id) {
        try {
            Long total = this.ingressoBo.totalConvidadoNoEvento(id);
            return Response.status(Response.Status.OK).entity(total).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/listarconsultores")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarconsultores(QueryConvidado queryConvidado) {
        try {
            this.consultors = this.ingressoBo.consultoresNoEvento(queryConvidado);
            return Response.status(Response.Status.OK).entity(this.consultors).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
