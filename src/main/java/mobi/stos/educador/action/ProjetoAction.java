package mobi.stos.educador.action;
/**
 *
 * @author Rafael Bloise
 */
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.CoordenadorDeProjeto;
import mobi.stos.educador.bean.Projeto;
import mobi.stos.educador.bean.Secretaria;
import mobi.stos.educador.bo.ICoordenadorDeProjetoBo;
import mobi.stos.educador.bo.IProjetoBo;
import mobi.stos.educador.bo.ISecretariaBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.enumm.ModoDeImplementacaoEnum;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import mobi.stos.educador.enumm.SituacaoProjetoEnum;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.sql.JoinType;

public class ProjetoAction extends GenericAction {

    private Projeto projeto;

    private List<Projeto> projetos;

    private List<Secretaria> secretarias;
    
    private List<CoordenadorDeProjeto> coordenadorDeProjetos;

    @Autowired
    private IProjetoBo projetoBo;
    @Autowired
    private ISecretariaBo secretariaBo;
    @Autowired
    private ICoordenadorDeProjetoBo coordenadorDeProjetoBo;

    @Action(value = "prepareProjeto",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/projeto/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (projeto != null && projeto.getId() != null) {
                projeto = this.projetoBo.load(this.projeto.getId());
            }

            this.secretarias = this.secretariaBo.listall();
            this.coordenadorDeProjetos=this.coordenadorDeProjetoBo.listall();

            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistProjeto",
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
            Projeto entity = null;
            if (projeto != null && projeto.getId() != null) {
                entity = projetoBo.load(projeto.getId());
            }
            this.projetoBo.persist(projeto);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listProjeto");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteProjeto",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            projetoBo.delete(projeto.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listProjeto");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listProjeto",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/projeto/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }

            Consulta c = getConsulta();
            c.addAliasTable("secretaria", "secretaria", JoinType.INNER_JOIN);
            c.addAliasTable("coordenadorDeProjeto", "coordenadorDeProjeto", JoinType.INNER_JOIN);
            this.projetos = projetoBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        list.add(new Keys("secretaria.nome", "Secretaria"));
        list.add(new Keys("coordenadorDeProjeto.nome", "Coordenador"));
        return list;
    }

    @JSON(serialize = false)
    public List getSituacaoProjetoEnums() {
        return Arrays.asList(SituacaoProjetoEnum.values());
    }
    
    
    @JSON(serialize = false)
    public List getModoDeImplementacaoEnums() {
        return Arrays.asList(ModoDeImplementacaoEnum.values());
    }
    
    
    @JSON(serialize = false)
    public List<Projeto> getProjetos() {
        return projetos;
    }

    @JSON(serialize = false)
    public List<Secretaria> getSecretarias() {
        return secretarias;
    }
    
    @JSON(serialize = false)
    public List<CoordenadorDeProjeto> getCoordenadorDeProjetos() {
        return coordenadorDeProjetos;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Projeto.class.getSimpleName());
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
