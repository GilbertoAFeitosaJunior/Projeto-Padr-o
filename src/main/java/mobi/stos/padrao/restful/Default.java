package mobi.stos.padrao.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.padrao.bean.Usuario;
import mobi.stos.padrao.bo.IUsuarioBo;
import mobi.stos.padrao.interfaces.IFutureCallback;
import mobi.stos.padrao.threads.PagamentoThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/Default")
public class Default {

    @Autowired
    private IUsuarioBo usuarioBo;

    @Path("/inicio")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        try {

            PagamentoThread thread = new PagamentoThread(usuarioBo);
            thread.onFutureCallback(new IFutureCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("################### sucesso;");
                }

                @Override
                public void onError(Exception exception) {
                    exception.printStackTrace();
                    System.out.println("############ erro;");
                }
            });
            thread.start();
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/fim")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(Usuario usuario) {
        try {
            Usuario u = this.usuarioBo.load(109l);
            System.out.println("############################## CHEGOU......" + usuario.getEmail());

            return Response.status(Response.Status.OK).entity(u).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
