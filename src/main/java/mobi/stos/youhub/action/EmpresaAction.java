package mobi.stos.youhub.action;

import com.google.api.client.repackaged.com.google.common.base.Strings;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.bean.Empresa;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IEmpresaBo;
import mobi.stos.youhub.bo.IUsuarioBo;
import mobi.stos.youhub.common.GenericAction;
import static mobi.stos.youhub.common.GenericAction.request;
import mobi.stos.youhub.exception.LoginExpiradoException;
import mobi.stos.youhub.util.consulta.Consulta;
import mobi.stos.youhub.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpresaAction extends GenericAction {

    private Empresa empresa;
    private Usuario usuario;

    private List<Usuario> usuarios;
    private List<Empresa> empresas;

    @Autowired
    private IEmpresaBo empresaBo;

    @Autowired
    private IUsuarioBo usuarioBo;

    @Action(value = "prepareEmpresa",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/empresa/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (usuario != null && usuario.getId() != null) {
                usuario = usuarioBo.load(usuario.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistEmpresa",
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

            if (usuario != null && usuario.getId() == null) {
                Empresa entity = this.empresaBo.persist(usuario.getEmpresa());
                usuario.setEmpresa(entity);
                this.usuarioBo.cadastrar(usuario);
            } else {
                Usuario entity = this.usuarioBo.load(usuario.getId());
                usuario.setEmail(entity.getEmail());
                if (Strings.isNullOrEmpty(usuario.getSenha())) {
                    usuario.setSenha(entity.getSenha());
                }

                this.empresaBo.persist(usuario.getEmpresa());
                this.usuarioBo.persist(usuario);
            }

            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listEmpresa");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteEmpresa",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
                ,
                @Result(name = ERROR, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            this.usuario = this.usuarioBo.load(usuario.getId());
            this.usuarioBo.delete(usuario.getId());
            this.empresaBo.delete(usuario.getEmpresa().getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listEmpresa");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "listEmpresa",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/empresa/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            Consulta consulta = getConsulta();
            consulta.addAliasTable("empresa", "empresa");
             consulta.addCriterion(Restrictions.isNotNull("empresa"));     
            usuarios = usuarioBo.list(consulta);
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("empresa.razaoSocial", "Razão Social"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Empresa.class.getSimpleName());
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
