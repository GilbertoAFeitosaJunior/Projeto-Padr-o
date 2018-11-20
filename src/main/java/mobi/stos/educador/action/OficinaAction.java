package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.bo.IAtividadeBo;
import mobi.stos.educador.bo.IEducadorBo;
import mobi.stos.educador.bo.IEscolaBo;
import mobi.stos.educador.bo.IOficinaBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.enumm.SituacaoOficinaEnum;
import mobi.stos.educador.enumm.TurnoEnum;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class OficinaAction extends GenericAction {

    private Oficina oficina;

    private List<Oficina> oficinas;
    private List<Educador> educadors;
    private List<Escola> escolas;
    private List<Atividade> atividades;

    @Autowired
    private IOficinaBo oficinaBo;

    @Autowired
    private IEducadorBo educadorBo;

    @Autowired
    private IEscolaBo escolaBo;

    @Autowired
    private IAtividadeBo atividadeBo;

    @Action(value = "prepareOficina",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
            @Result(name = SUCCESS, location = "/app/oficina/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (oficina != null && oficina.getId() != null) {
                oficina = this.oficinaBo.load(oficina.getId());
            }
            this.atividades = this.atividadeBo.listall();
            this.educadors = this.educadorBo.listall();
            this.escolas = this.escolaBo.listall();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistOficina",
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

            if (getLogged().getEducador() != null) {
                Educador educadorLogado = new Educador(getLogged().getEducador().getId());
                oficina.setEducador(educadorLogado);
                this.oficinaBo.persist(oficina);
                setRedirectURL("listOficina");
                addActionMessage("Registro salvo com sucesso.");
            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteOficina",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            oficinaBo.delete(oficina.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listOficina");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listOficina",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/oficina/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }

            Consulta c = getConsulta();
            c.addCriterion(
                    Restrictions.or(
                            Restrictions.isNull("historico"),
                            Restrictions.ilike("historico", c.getValor(), MatchMode.ANYWHERE)
                    )
            );
            c.addAliasTable("educador", "educador", JoinType.INNER_JOIN);
            
            if (getLogged().getEducador() != null) {
                c.addCriterion(Restrictions.eq("educador.id", getLogged().getEducador().getId()));
            }
            
            this.oficinas = this.oficinaBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public List<Oficina> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
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

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("historico", "Historico"));
        return list;
    }

    @JSON(serialize = false)
    public List getSituacaoOficinaEnums() {
        return Arrays.asList(SituacaoOficinaEnum.values());
    }

    @JSON(serialize = false)
    public List getTurnoEnums() {
        return Arrays.asList(TurnoEnum.values());
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Oficina.class.getSimpleName());
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
