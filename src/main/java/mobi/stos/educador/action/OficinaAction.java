package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Anexo;
import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.bo.IAnexoBo;
import mobi.stos.educador.bo.IAtividadeBo;
import mobi.stos.educador.bo.IEscolaBo;
import mobi.stos.educador.bo.IOficinaBo;
import mobi.stos.educador.bo.IUsuarioBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.jsonReturn;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.enumm.SituacaoOficinaEnum;
import mobi.stos.educador.enumm.TurnoEnum;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.JsonReturn;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class OficinaAction extends GenericAction {

    private Oficina oficina;
    private Atividade atividade;
    private Usuario usuario;
    private Anexo anexo;
    
    private Long id;
    
    private List<Anexo> anexos;
    private List<Oficina> oficinas;
    private List<Educador> educadors;
    private List<Escola> escolas;
    private List<Atividade> atividades;

    @Autowired
    private IUsuarioBo usuarioBo;
    
    @Autowired
    private IOficinaBo oficinaBo;

    @Autowired
    private IEscolaBo escolaBo;

    @Autowired
    private IAtividadeBo atividadeBo;
    
    @Autowired
    private IAnexoBo anexoBo;
    
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
            this.escolas = this.escolaBo.listall();
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
      @Action(value = "prepareVisualizarOficina",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/oficina/visualizar_formulario.jsp")
            })
    public String prepareVisualizarOficina() {
        try {
            GenericAction.isLogged(request);
            if (oficina != null && oficina.getId() != null) {
                oficina = this.oficinaBo.load(this.oficina.getId());
            }
            
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
    @Action(value = "persistOficinaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistOficinaJson() {
        try {
            GenericAction.isLogged(request);
            Oficina entity = null;
             if (getLogged().getEducador() != null) {
                 if(oficina != null && oficina.getId() != null){
                     entity = this.oficinaBo.load(oficina.getId());
                 }
                Educador educadorLogado = new Educador(getLogged().getEducador().getId());
                oficina.setEducador(educadorLogado);
                oficina.setAtividades(entity.getAtividades());
                oficina = this.oficinaBo.persist(oficina);
                id = oficina.getId();
                oficina = null;
                jsonReturn = new JsonReturn("Registro salvo com sucesso.", true);
            } else {
                jsonReturn = new JsonReturn("Erro ao salvar o registro.", false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    @Action(value = "persistOficinaAtividadeJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistOficinaAtividadeJson() {
        try {
            GenericAction.isLogged(request);
            
              if (atividade.getId() != null) {
                oficina = this.oficinaBo.load(oficina.getId()); 
                atividade = this.atividadeBo.load(atividade.getId());
                
                oficina.getEducador().setEscolas(null);

                boolean ok = true;
                for (Atividade a : oficina.getAtividades()) {
                    if (a.getId() == ((long) atividade.getId())) {
                        ok = false;
                    }
                }
                if (ok) {
                    oficina.addAtividade(atividade);
                    this.oficinaBo.persist(oficina);
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
    
    @Action(value = "persistOficinaHistoricoJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistOficinaHistoricoJson() {
        try {
            GenericAction.isLogged(request);
            if (getLogged().getEducador() != null) {
                String historicoView = this.oficina.getHistorico();
                this.oficina = this.oficinaBo.load(this.oficina.getId());
                StringBuilder sb = new StringBuilder();
                sb.append("<br/>");
                sb.append("<br/>");
                sb.append(historicoView);
                sb.append("<br/>");
                sb.append("Por: ");
                sb.append(getLogged().getEducador().getNome());
                sb.append("<br/>");
                Date data = new Date(); 
                DateFormat dateFormat = new SimpleDateFormat("HH:mm"); 
                String horaAtual = String.valueOf(dateFormat.format(data)); 
                String dataFormatada = java.text.DateFormat.getDateInstance(DateFormat.FULL).format(data);
                sb.append(dataFormatada);
                sb.append(" as " );
                sb.append(horaAtual);
                sb.append("<br/>");
                if (oficina.getHistorico() != null) {
                    sb.append("_________________________________________________");
                    sb.append(oficina.getHistorico());
                }
                
                oficina.setHistorico(String.valueOf(sb));
                
                this.oficina = this.oficinaBo.persist(oficina);
                oficina.setAtividades(null);
                oficina.setEducador(null);
                
            } else {
            }

        } catch (Exception e) {
            e.printStackTrace();
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
            
            this.anexos = anexoBo.byOficinaId(oficina.getId());
            
            for (Anexo anexo : anexos) {
                anexo.setOficina(null);
                ServletContext context = request.getServletContext();
                File file = new File(context.getRealPath("/") + anexo.getArquivo());
                if (file.exists()) {
                    file.delete();
                }

                this.anexoBo.delete(anexo.getId());
            }
            oficinaBo.delete(oficina.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listOficina");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }
    
    @Action(value = "deleteOficinaAtividadeJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String deleteOficinaAtividadeJson() {
        try {

            GenericAction.isLogged(request);

            this.oficinaBo.deleteOficinaAtividade(oficina.getId(), atividade.getId());

            jsonReturn = new JsonReturn("Excluido com sucesso", true);

        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }
    
     @Action(value = "listOficinaAtividadeJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String listOficinaAtividadeJson() {
        try {
            GenericAction.isLogged(request);
            System.out.println(oficina.getId());
            
            if (oficina != null && oficina.getId() != null) {
                oficina = this.oficinaBo.load(oficina.getId());
                if (oficina != null) {
                    oficina.setEducador(null);
                    oficina.setEscola(null);
                }
            }
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
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
           c.addAliasTable("educador", "educador", JoinType.INNER_JOIN);
           c.addAliasTable("escola", "escola", JoinType.INNER_JOIN);
            if (getLogged().getEducador() != null) {
                c.addCriterion(Restrictions.eq("educador.id", getLogged().getEducador().getId()));
            }
            c.addOrder(Order.desc("id"));
            this.oficinas = this.oficinaBo.list(c);
            this.usuario = this.usuarioBo.load(getLogged().getId());
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    public Anexo getAnexo() {
        return anexo;
    }

    public void setAnexo(Anexo anexo) {
        this.anexo = anexo;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public JsonReturn getJsonReturn() {
        return super.getJsonReturn(); 
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
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
        list.add(new Keys("escola.nome", "Nome da Escola"));
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
