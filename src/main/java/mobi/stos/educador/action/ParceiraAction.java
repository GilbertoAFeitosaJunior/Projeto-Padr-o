package mobi.stos.educador.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Parceira;
import mobi.stos.educador.bo.IParceiraBo;
import mobi.stos.educador.common.GenericAction;
import mobi.stos.educador.enumm.SituacaoParceiraEnum;
import mobi.stos.educador.exception.LoginExpiradoException;
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
public class ParceiraAction extends GenericAction {

    private Parceira parceira;

    private List<Parceira> parceiras;

    @Autowired
    private IParceiraBo parceiraBo;

    @Action(value = "prepareParceira",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/parceira/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (parceira != null && parceira.getId() != null) {
                parceira = this.parceiraBo.load(this.parceira.getId());
            }

            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistParceira",
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
            Parceira entity = null;
            if (parceira != null && parceira.getId() != null) {
                entity = parceiraBo.load(parceira.getId());
            }

            this.parceiraBo.persist(parceira);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listParceira");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteParceira",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            parceiraBo.delete(parceira.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listParceira");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listParceira",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/parceira/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }

            parceiras = parceiraBo.list(getConsulta());
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    @JSON(serialize = false)
    public List<Parceira> getParceiras() {
        return parceiras;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        list.add(new Keys("responsavelPrincipal", "Responsável Principal"));
        return list;
    }

    @JSON(serialize = false)
    public List getSituacaoParceiraEnums() {
        return Arrays.asList(SituacaoParceiraEnum.values());
    }

    public Parceira getParceira() {
        return parceira;
    }

    public void setParceira(Parceira parceira) {
        this.parceira = parceira;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Parceira.class.getSimpleName());
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
