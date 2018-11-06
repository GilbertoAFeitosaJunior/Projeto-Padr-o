
package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.bo.IEducadorBo;
import mobi.stos.educador.bo.IEscolaBo;
import mobi.stos.educador.bo.IUsuarioBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.util.JsonReturn;
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

public class EducadorAction extends GenericAction{
    
    private Educador educador;
    private Usuario usuario;
    private Escola escola;
    
    private List<Usuario> usuarios;
    private List<Educador> educadors;
    private List<Escola> escolas;
    
    @Autowired
    private IEducadorBo educadorBo;
    
    @Autowired
    private IUsuarioBo usuarioBo;
    
    @Autowired
    private IEscolaBo escolaBo;
    
    @Action(value = "prepareEducador",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
            @Result(name = SUCCESS, location = "/app/educador/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (educador != null && educador.getId() != null) {
                educador = this.educadorBo.load(educador.getId());
            }
            this.educadors = this.educadorBo.listall();
            this.usuarios = this.usuarioBo.listall();
            this.escolas = this.escolaBo.listall();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
    @Action(value = "persistEducador",
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
            Educador entity;
            if (educador != null && educador.getId() != null) {
                entity = educadorBo.load(educador.getId());
            }
            this.educadorBo.persist(educador);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listEducador");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    
      @Action(value = "listEducador",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/educador/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            Consulta c = getConsulta();
            this.educadors = educadorBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }
    
     @Action(value = "deleteEducador",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            educadorBo.delete(educador.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listEducador");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    
    @Override
    public JsonReturn getJsonReturn() {
        return super.getJsonReturn(); 
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        return list;
    }

    public Educador getEducador() {
        return educador;
    }
    public void setEducador(Educador educador) {
        this.educador = educador;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Escola getEscola() {
        return escola;
    }
    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Educador> getEducadors() {
        return educadors;
    }
    public void setEducadors(List<Educador> educadors) {
        this.educadors = educadors;
    }
    public List<Escola> getEscolas() {
        return escolas;
    }
    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }
    
    

    @Override
    public void prepare() throws Exception {
        setMenu(Educador.class.getSimpleName());
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
