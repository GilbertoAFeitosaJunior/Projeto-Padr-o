package mobi.stos.bepro.restful;

import java.util.Calendar;
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
import mobi.stos.bepro.bo.IConsultorBo;
import mobi.stos.bepro.util.Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/consultor")
public class ConsultorRest {

    @Autowired
    private IConsultorBo consultorBo;

    @Path("/salvar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(@Context ServletContext context, Consultor consultor) {
        try {
            if (consultor != null && consultor.getFirebase() != null) {
                Consultor entity = this.consultorBo.byFirebase(consultor.getFirebase());

                if (entity != null) {
                    consultor.setId(entity.getId());
                }

                if (consultor.getFoto() != null) {
                    consultor.setFoto(Util.gerarFoto(context, consultor.getFoto(), "fotos/" + Consultor.class.getSimpleName()));
                }

                String hash = Util.md5(String.valueOf(Calendar.getInstance().getTimeInMillis()));
                consultor.setHash(hash);
                this.consultorBo.persist(consultor);
                return Response.status(Response.Status.CREATED).entity(hash).build();
            }

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/{hash}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsultr(@PathParam("hash") String hash) {
        try {
            if (StringUtils.isNotEmpty(hash)) {
                Consultor consultor = this.consultorBo.byHash(hash);
                return Response.status(Response.Status.OK).entity(consultor).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
