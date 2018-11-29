
package mobi.stos.educador.action;

import com.google.common.base.Strings;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.CoordenadorPedagogico;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.bo.ICoordenadorPedagogicoBo;
import mobi.stos.educador.bo.IUsuarioBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.exception.AvoidDuplicationEmailException;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Order;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class CoordenadorPedagogicoAction extends GenericAction{
    
    private Usuario usuario;
    private CoordenadorPedagogico coordenadorPedagogico;
    
    private List<CoordenadorPedagogico> coordenadorPedagogicos;
    
    @Autowired
    private IUsuarioBo usuarioBo;
    
    @Autowired
    private ICoordenadorPedagogicoBo coordenadorPedagogicoBo;
    
    @Action(value = "prepareCoordenadorPedagogico",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
            @Result(name = SUCCESS, location = "/app/coordenador_pedagogico/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (coordenadorPedagogico != null && coordenadorPedagogico.getId() != null) {
                coordenadorPedagogico = this.coordenadorPedagogicoBo.load(coordenadorPedagogico.getId());
            }
            //this.coordenadorPedagogicos = this.coordenadorPedagogicoBo.listall();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
      @Action(value = "persistCoordenadorPedagogico",
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
            if (this.coordenadorPedagogico != null && this.coordenadorPedagogico.getId() != null) {
                entity = this.usuarioBo.load(this.coordenadorPedagogico.getUsuario().getId());
                if (Strings.isNullOrEmpty(this.coordenadorPedagogico.getUsuario().getSenha())) {
                    this.coordenadorPedagogico.getUsuario().setSenha(entity.getSenha());
                }
            }else{
                entity = this.usuarioBo.cadastrar(this.coordenadorPedagogico.getUsuario());
                this.coordenadorPedagogico.setUsuario(entity);
            }
                this.usuarioBo.persist(this.coordenadorPedagogico.getUsuario());
                this.coordenadorPedagogicoBo.persist(this.coordenadorPedagogico);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listCoordenadorPedagogico");
        }catch (AvoidDuplicationEmailException e) {
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
    
     @Action(value = "deleteCoordenadorPedagogico",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            CoordenadorPedagogico entity = coordenadorPedagogicoBo.load(this.coordenadorPedagogico.getId());
            this.coordenadorPedagogicoBo.delete(this.coordenadorPedagogico.getId());
            //this.usuarioBo.delete(entity.getUsuario().getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listCoordenadorPedagogico");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }
    
    @Action(value = "listCoordenadorPedagogico",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/coordenador_pedagogico/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            Consulta consulta = getConsulta();
            consulta.addAliasTable("usuario", "usuario", JoinType.INNER_JOIN);
            consulta.addOrder(Order.desc("id"));

           this.coordenadorPedagogicos = coordenadorPedagogicoBo.list(consulta);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CoordenadorPedagogico getCoordenadorPedagogico() {
        return coordenadorPedagogico;
    }

    public void setCoordenadorPedagogico(CoordenadorPedagogico coordenadorPedagogico) {
        this.coordenadorPedagogico = coordenadorPedagogico;
    }

    public List<CoordenadorPedagogico> getCoordenadorPedagogicos() {
        return coordenadorPedagogicos;
    }

    public void setCoordenadorPedagogicos(List<CoordenadorPedagogico> coordenadorPedagogicos) {
        this.coordenadorPedagogicos = coordenadorPedagogicos;
    }
    
    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        list.add(new Keys("usuario.email", "E-mail"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(CoordenadorPedagogico.class.getSimpleName());
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
