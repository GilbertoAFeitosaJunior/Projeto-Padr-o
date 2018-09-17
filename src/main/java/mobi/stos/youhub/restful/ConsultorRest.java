package mobi.stos.youhub.restful;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.bo.IIngressoBo;
import mobi.stos.youhub.restful.model.IngressoHelper;
import mobi.stos.youhub.restful.model.QueryConvidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gilberto
 */
@Component
@Path("/consultor")
public class ConsultorRest {
    
    @Autowired
    private IIngressoBo ingressoBo;
    
    private List<Ingresso> ingressos;
    
    @Path("/totalconvidado")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalconsultor(QueryConvidado queryConvidado) {
        try {
            Long total = this.ingressoBo.totalConvidadoPorConsultor(queryConvidado.getIdEvento(), queryConvidado.getIdConsultor());
            return Response.status(Response.Status.OK).entity(total).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    
    @Path("/convidadoevento")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response conviadoPorEvento(QueryConvidado queryConvidado) {
        try {
            this.ingressos = this.ingressoBo.convidadoPorConsultoEvento(queryConvidado.getIdEvento(), queryConvidado.getIdConsultor());
            
            List<Convidado> convidados = new ArrayList<>();
            ingressos.forEach(u -> {
                convidados.add(u.getConvidado());
            });
            
            return Response.status(Response.Status.OK).entity(convidados).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    
    @Path("/ingresso")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ingressoPorConsultor(IngressoHelper ingressoHelper) {
        try {
            
            ingressos = this.ingressoBo.listIngressoPorConsultor(ingressoHelper.getIdConsultor(), ingressoHelper.getData());
            
            ingressos.forEach(u -> {
                u.setConsultor(null);
                u.setConvidado(null);
                u.setManager(null);
                u.setEvento(null);
            });
            
            return Response.status(Response.Status.OK).entity(ingressos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    
    @Path("/convidados")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response convidadoPorConsultorData(IngressoHelper ingressoHelper) {
        try {
            
            ingressos = this.ingressoBo.listIngressoPorConsultor(ingressoHelper.getIdConsultor(), ingressoHelper.getData());
            
            List<Convidado> convidados = new ArrayList<>();
            
            ingressos.forEach(u -> {
                convidados.add(u.getConvidado());
            });
            
            convidados.forEach(u -> {
                u.setManager(null);
            });
            
            return Response.status(Response.Status.OK).entity(convidados).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
    
}
