package mobi.stos.youhub.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IDiretorSalaBo;
import mobi.stos.youhub.common.GenericAction;
import static mobi.stos.youhub.common.GenericAction.request;
import mobi.stos.youhub.exception.LoginExpiradoException;
import mobi.stos.youhub.util.consulta.Consulta;
import mobi.stos.youhub.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

public class DiretorSalaAction extends GenericAction {

    private DiretorSala diretorSala;
    private List<DiretorSala> diretorSalas;
    @Autowired
    private IDiretorSalaBo diretorSalaBo;

    @Action(value = "prepareDiretorSala",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/evento/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (diretorSala != null && diretorSala.getId() != null) {
                diretorSala = this.diretorSalaBo.load(this.diretorSala.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistDiretorSala",
            interceptorRefs = {
                @InterceptorRef(value = "fileUploadStack")
                ,
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String persist() {
        try {
            GenericAction.isLogged(request);
            diretorSalaBo.persist(diretorSala);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listDiretorSala");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "deleteDiretorSala",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            diretorSalaBo.delete(diretorSala.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listDiretorSala");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listDiretorSala",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/evento/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            diretorSalas = diretorSalaBo.list(getConsulta());
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    public DiretorSala getDiretorSala() {
        return diretorSala;
    }

    public void setDiretorSala(DiretorSala diretorSala) {
        this.diretorSala = diretorSala;
    }

    public List<DiretorSala> getDiretorSalas() {
        return diretorSalas;
    }

    public void setDiretorSalas(List<DiretorSala> diretorSalas) {
        this.diretorSalas = diretorSalas;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("titulo", "Título"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Usuario.class.getSimpleName());
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
