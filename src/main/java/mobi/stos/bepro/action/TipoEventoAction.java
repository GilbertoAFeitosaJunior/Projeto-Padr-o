package mobi.stos.bepro.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.bepro.bean.TipoEvento;
import mobi.stos.bepro.bo.ITipoEventoBo;
import mobi.stos.bepro.common.GenericAction;
import static mobi.stos.bepro.common.GenericAction.request;
import mobi.stos.bepro.exception.LoginExpiradoException;
import mobi.stos.bepro.util.consulta.Consulta;
import mobi.stos.bepro.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

public class TipoEventoAction extends GenericAction {

    private TipoEvento tipoEvento;
    private List<TipoEvento> tipoEventos;
    @Autowired
    private ITipoEventoBo tipoEventoBo;

    @Action(value = "prepareTipoEvento",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/tipo_evento/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (tipoEvento != null && tipoEvento.getId() != null) {
                tipoEvento = this.tipoEventoBo.load(this.tipoEvento.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistTipoEvento",
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
            tipoEventoBo.persist(tipoEvento);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listTipoEvento");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "deleteTipoEvento",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            tipoEventoBo.delete(tipoEvento.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listTipoEvento");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listTipoEvento",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/tipo_evento/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            tipoEventos = tipoEventoBo.list(getConsulta());
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public List<TipoEvento> getTipoEventos() {
        return tipoEventos;
    }

    public void setTipoEventos(List<TipoEvento> tipoEventos) {
        this.tipoEventos = tipoEventos;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(TipoEvento.class.getSimpleName());
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
