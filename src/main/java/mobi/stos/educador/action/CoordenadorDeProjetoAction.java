
package mobi.stos.educador.action;

import com.google.api.client.repackaged.com.google.common.base.Strings;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.CoordenadorDeProjeto;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.bo.ICoordenadorDeProjetoBo;
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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class CoordenadorDeProjetoAction extends GenericAction{
    
    private Usuario usuario;
    private CoordenadorDeProjeto coordenadorDeProjeto;
    
    private List<CoordenadorDeProjeto> coordenadorDeProjetos;
    
    @Autowired
    private IUsuarioBo usuarioBo;
    
    @Autowired
    private ICoordenadorDeProjetoBo coordenadorDeProjetoBo;
    
    @Action(value = "prepareCoordenadorDeProjeto",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
            @Result(name = SUCCESS, location = "/app/coordenador_projeto/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (coordenadorDeProjeto != null && coordenadorDeProjeto.getId() != null) {
                coordenadorDeProjeto = this.coordenadorDeProjetoBo.load(coordenadorDeProjeto.getId());
            }
            this.coordenadorDeProjetos = this.coordenadorDeProjetoBo.listall();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
      @Action(value = "persistCoordenadorDeProjeto",
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
            if (this.coordenadorDeProjeto != null && this.coordenadorDeProjeto.getId() != null) {
                entity = this.usuarioBo.load(this.coordenadorDeProjeto.getUsuario().getId());
                if (Strings.isNullOrEmpty(this.coordenadorDeProjeto.getUsuario().getSenha())) {
                    this.coordenadorDeProjeto.getUsuario().setSenha(entity.getSenha());
                }
            }else{
                entity = this.usuarioBo.cadastrar(this.coordenadorDeProjeto.getUsuario());
                this.coordenadorDeProjeto.setUsuario(entity);
            }
                this.usuarioBo.persist(this.coordenadorDeProjeto.getUsuario());
                this.coordenadorDeProjetoBo.persist(this.coordenadorDeProjeto);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listCoordenadorDeProjeto");
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
    
     @Action(value = "deleteCoordenadorDeProjeto",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            CoordenadorDeProjeto entity = coordenadorDeProjetoBo.load(this.coordenadorDeProjeto.getId());
            this.coordenadorDeProjetoBo.delete(this.coordenadorDeProjeto.getId());
            this.usuarioBo.delete(entity.getUsuario().getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listCoordenadorDeProjeto");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }
    
    @Action(value = "listCoordenadorDeProjeto",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/coordenador_projeto/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
           this.coordenadorDeProjetos = coordenadorDeProjetoBo.listall();
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

    public CoordenadorDeProjeto getCoordenadorDeProjeto() {
        return coordenadorDeProjeto;
    }
    public void setCoordenadorDeProjeto(CoordenadorDeProjeto coordenadorDeProjeto) {
        this.coordenadorDeProjeto = coordenadorDeProjeto;
    }

    public List<CoordenadorDeProjeto> getCoordenadorDeProjetos() {
        return coordenadorDeProjetos;
    }
    public void setCoordenadorDeProjetos(List<CoordenadorDeProjeto> coordenadorDeProjetos) {
        this.coordenadorDeProjetos = coordenadorDeProjetos;
    }
    
    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(CoordenadorDeProjeto.class.getSimpleName());
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

