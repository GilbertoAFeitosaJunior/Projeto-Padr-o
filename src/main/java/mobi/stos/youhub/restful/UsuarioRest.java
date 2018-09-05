package mobi.stos.youhub.restful;

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
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IManagerBo;
import mobi.stos.youhub.bo.IUsuarioBo;
import mobi.stos.youhub.restful.model.Login;
import mobi.stos.youhub.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/usuario")
public class UsuarioRest {

    @Autowired
    IManagerBo managerBo;

    @Autowired
    IUsuarioBo usuarioBo;

    @Path("/recuperar/{email}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response recuperar(@PathParam("email") String email) {
        try {
            Usuario usuario = this.usuarioBo.byEmail(email);
            if (usuario != null) {
                return Response.status(Response.Status.OK).build();
            }

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Login login) {
        try {

            if (login.getLogin() != null && login.getSenha() != null) {
                String hash = Util.createHash();
                Usuario usuario = this.usuarioBo.login(login.getLogin(), login.getSenha());

                if (usuario != null) {
                    usuario.setHash(hash);
                    this.usuarioBo.persist(usuario);
                    return Response.status(Response.Status.OK).entity(usuario).build();

                }
            }
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/manager/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Manager manager) {
        try {
            if (manager != null && manager.getId() != null) {
                this.managerBo.delete(manager.getId());
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/manager/cadastrar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Context ServletContext context, Manager manager) {
        try {
            if (manager != null) {

                if (manager.getFoto() != null) {
                    manager.setFoto(Util.gerarFoto(context, manager.getFoto(), Manager.class.getSimpleName()));
                }
                this.managerBo.persist(manager);
                return Response.status(Response.Status.CREATED).build();
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/manager/carregar/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response carregar(@PathParam("id") long id) {
        try {
            Manager manager = this.managerBo.load(id);
            if (manager != null) {
                return Response.status(Response.Status.OK).entity(manager).build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
