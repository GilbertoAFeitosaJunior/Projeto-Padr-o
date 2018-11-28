package mobi.stos.educador.action;

import com.google.common.base.Strings;
import static com.opensymphony.xwork2.Action.ERROR;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.GestorDoTerritorio;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.bo.IGestorDoTerritorioBo;
import mobi.stos.educador.bo.IUsuarioBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.exception.AvoidDuplicationEmailException;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rafael Bloise
 */
public class GestorDoTerritorioAction extends GenericAction {

    private GestorDoTerritorio gestorDoTerritorio;

    private Usuario usuario;

    private List<GestorDoTerritorio> gestorDoTerritorios;

    @Autowired
    private IGestorDoTerritorioBo gestorDoTerritorioBo;

    @Autowired
    private IUsuarioBo usuarioBo;

    @Action(value = "prepareGestorDoTerritorio",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/gestorDoTerritorio/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (gestorDoTerritorio != null && gestorDoTerritorio.getId() != null) {
                gestorDoTerritorio = this.gestorDoTerritorioBo.load(this.gestorDoTerritorio.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistGestorDoTerritorio",
            interceptorRefs = {
                @InterceptorRef(value = "fileUploadStack")
                ,
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
                ,
                @Result(name = ERROR, location = "/app/notify/")
            })
    public String persist() {
        try {
            GenericAction.isLogged(request);
            Usuario entity;
            if (this.gestorDoTerritorio != null && this.gestorDoTerritorio.getId() != null) {
                entity = this.usuarioBo.load(this.gestorDoTerritorio.getUsuario().getId());
                if (Strings.isNullOrEmpty(this.gestorDoTerritorio.getUsuario().getSenha())) {
                    this.gestorDoTerritorio.getUsuario().setSenha(entity.getSenha());
                }

            } else {
                entity = this.usuarioBo.cadastrar(this.gestorDoTerritorio.getUsuario());
                this.gestorDoTerritorio.setUsuario(entity);
            }
            this.usuarioBo.persist(this.gestorDoTerritorio.getUsuario());
            this.gestorDoTerritorioBo.persist(this.gestorDoTerritorio);

            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listGestorDoTerritorio");
        } catch (AvoidDuplicationEmailException e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteGestorDoTerritorio",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);

            GestorDoTerritorio entity = gestorDoTerritorioBo.load(this.gestorDoTerritorio.getId());
            this.gestorDoTerritorioBo.delete(this.gestorDoTerritorio.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listGestorDoTerritorio");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listGestorDoTerritorio",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/gestorDoTerritorio/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }

            Consulta c = getConsulta();
            c.addAliasTable("usuario", "usuario", JoinType.INNER_JOIN);

            this.gestorDoTerritorios = gestorDoTerritorioBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    // Getter and Setter
    public GestorDoTerritorio getGestorDoTerritorio() {
        return gestorDoTerritorio;
    }

    public void setGestorDoTerritorio(GestorDoTerritorio gestorDoTerritorio) {
        this.gestorDoTerritorio = gestorDoTerritorio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<GestorDoTerritorio> getGestorDoTerritorios() {
        return gestorDoTerritorios;
    }

    public void setGestorDoTerritorios(List<GestorDoTerritorio> gestorDoTerritorios) {
        this.gestorDoTerritorios = gestorDoTerritorios;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        list.add(new Keys("usuario.email", "E-mail"));
        return list;
    }

    //métodos abstratos
    @Override
    public void prepare() throws Exception {
        setMenu(GestorDoTerritorio.class.getSimpleName());
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        GenericAction.request = hsr;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        GenericAction.response = hsr;
    }
}
