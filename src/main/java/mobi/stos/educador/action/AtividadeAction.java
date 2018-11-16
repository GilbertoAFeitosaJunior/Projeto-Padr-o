package mobi.stos.educador.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.bo.IAtividadeBo;
import mobi.stos.educador.bo.IMetodologiaBo;
import mobi.stos.educador.common.GenericAction;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.JsonReturn;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Rafael Bloise
 */
public class AtividadeAction extends GenericAction {

    private Atividade atividade;

    private Metodologia metodologia;

    private List<Atividade> atividades;

    private List<Metodologia> metodologias;

    @Autowired
    private IAtividadeBo atividadeBo;

    @Autowired
    private IMetodologiaBo metodologiaBo;

    @Action(value = "listAtividadeMetodologia",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String listAtividadeMetodologia() {
        try {
            GenericAction.isLogged(request);

            atividade = this.atividadeBo.load(atividade.getId());
           

            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    @Action(value = "deleteAtividadeMetodologia",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String deleteAtividadeMetodologia() {
        try {

            GenericAction.isLogged(request);

            this.atividadeBo.deleteAtividadeMetodologia(atividade.getId(), metodologia.getId());

            jsonReturn = new JsonReturn("Excluido com sucesso", true);

        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    @Action(value = "prepareAtividade",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/atividade/formulario.jsp")
            })

    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (atividade != null && atividade.getId() != null) {
                atividade = this.atividadeBo.load(this.atividade.getId());
            }
            this.atividades = this.atividadeBo.listall();
            this.metodologias = this.metodologiaBo.listall();

            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistAtividade",
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
            Atividade entity = null;
            if (atividade != null && atividade.getId() != null) {
                entity = atividadeBo.load(atividade.getId());
            }
            this.atividadeBo.persist(atividade);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listAtividade");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "persistAtividadeJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistAtividadeJson() {
        try {
            GenericAction.isLogged(request);

            if (metodologia.getId() != null) {
                atividade = this.atividadeBo.load(atividade.getId());
                metodologia = this.metodologiaBo.load(metodologia.getId());

                boolean ok = true;
                for (Metodologia m : atividade.getMetodologias()) {
                    if (m.getId() == ((long) metodologia.getId())) {
                        ok = false;
                    }
                }
                if (ok) {
                    atividade.addMetodologia(metodologia);
                    this.atividadeBo.persist(atividade);
                    jsonReturn = new JsonReturn("Registro adicionado com sucesso.", true);
                } else {
                    jsonReturn = new JsonReturn("O Registro já está adicionado.", false);
                }
            } else {
                jsonReturn = new JsonReturn(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            //this.jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    @Action(value = "deleteAtividade",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            atividadeBo.delete(atividade.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listAtividade");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listAtividade",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/atividade/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }

            Consulta c = getConsulta();
            this.atividades = atividadeBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    //getters and setters
    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public List<Metodologia> getMetodologias() {
        return metodologias;
    }

    public void setMetodologias(List<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }

    //JSON
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

    //Métodos abstratos
    @Override
    public void prepare() throws Exception {
        setMenu(Atividade.class.getSimpleName());
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
