package mobi.stos.educador.action;

import com.google.common.base.Strings;
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
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class EducadorAction extends GenericAction {

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
            //this.educadors = this.educadorBo.listall();
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
//            GenericAction.isLogged(request);
//            Educador entity;
//            if (educador != null && educador.getId() != null) {
//                entity = educadorBo.load(educador.getId());
//                
//                if (Strings.isNullOrEmpty(educador.getSenha())) {
//                    educador.setSenha(entity.getSenha());
//                }
//            }
//            
//            String ufMaiusculo = educador.getUf().toUpperCase();
//            educador.setUf(ufMaiusculo);
//            this.educadorBo.persist(educador);
            GenericAction.isLogged(request);
            Usuario entity;

            if (this.educador != null && this.educador.getId() != null) {

                entity = this.usuarioBo.load(this.educador.getUsuario().getId());

                if (Strings.isNullOrEmpty(this.educador.getUsuario().getSenha())) {
                    this.educador.getUsuario().setSenha(entity.getSenha());
                }

            } else {
                entity = this.usuarioBo.cadastrar(this.educador.getUsuario());
                this.educador.setUsuario(entity);
            }
            this.usuarioBo.persist(this.educador.getUsuario());
            this.educadorBo.persist(this.educador);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listEducador");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "persistEducadorEscolaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistEducadorEscolaJson() {
        try {
            GenericAction.isLogged(request);

            if (escola.getId() != null) {
                educador = this.educadorBo.load(educador.getId());
                escola = this.escolaBo.load(escola.getId());

                boolean escolaDiferente = true;
                for (Escola e : educador.getEscolas()) {
                    if (e.getId() == ((long) escola.getId())) {
                        escolaDiferente = false;
                    }
                }
                if (escolaDiferente) {
                    educador.addEscola(escola);
                    this.educadorBo.persist(educador);

                    jsonReturn = new JsonReturn("Registro adicionado com sucesso.", true);
                } else {
                    jsonReturn = new JsonReturn("O Registro já está adicionado.", false);
                }
            } else {
                jsonReturn = new JsonReturn(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            c.addAliasTable("usuario", "usuario", JoinType.INNER_JOIN);

            this.educadors = educadorBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    @Action(value = "listEducadorEscolaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String listEducadorEscolaJson() {
        try {
            GenericAction.isLogged(request);
            educador = this.educadorBo.load(educador.getId());
            for (Escola escola : educador.getEscolas()) {
                escola.setProjeto(null);
            }
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
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
            Educador entity = educadorBo.load(this.educador.getId());
            this.educadorBo.delete(this.educador.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listEducador");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "deleteEducadorEscolaJson",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String deleteEducadorEscolaJson() {
        try {
            GenericAction.isLogged(request);
            this.educadorBo.deleteEducadorEscola(educador.getId(), escola.getId());
            jsonReturn = new JsonReturn("Excluido com sucesso", true);
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
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
