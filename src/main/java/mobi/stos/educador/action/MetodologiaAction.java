package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.bo.IEscolaBo;
import mobi.stos.educador.bo.IMetodologiaBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.enumm.AplicabilidadeEnum;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.JsonReturn;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;



public class MetodologiaAction extends GenericAction{
    
    private Metodologia metodologia;
    
    private Escola escola;
    
    private List<Metodologia> metodologias;
    
    private List<Escola> escolas;
    
    @Autowired
    private IMetodologiaBo metodologiaBo;
    
    @Autowired
    private IEscolaBo escolaBo;
    
    
    
    
    @Action(value = "listMetodologiaEscola",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String listMetodologiaEscola() {
        try {
            GenericAction.isLogged(request);
            metodologia = this.metodologiaBo.load(metodologia.getId());
            escola = this.escolaBo.load(escola.getId());
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    @Action(value = "deleteMetodologiaEscola",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String deleteMetodologiaEscola() {
        try {
            GenericAction.isLogged(request);
            
            this.metodologiaBo.deleteMetodologiaEscola(metodologia.getId(), escola.getId());
//            metodologia = null;
//            escola = null;
            
            jsonReturn = new JsonReturn("Excluido com sucesso",true);
            
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }
    
    
    
    
    
    @Action(value = "prepareMetodologia",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/metodologia/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (metodologia != null && metodologia.getId() != null) {
                metodologia = this.metodologiaBo.load(this.metodologia.getId());
            }

            this.escolas = this.escolaBo.listall();

            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
    
    
    @Action(value = "persistMetodologiaEscola",
            interceptorRefs = {
                @InterceptorRef(value = "fileUploadStack")
                ,
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
                ,
                @Result(name = ERROR, location = "/app/notify/")
            })
    public String persistMetodologiaEscola() {
        try {
            GenericAction.isLogged(request);

            if (escola.getId() != null) {
                metodologia = this.metodologiaBo.load(metodologia.getId());
                escola = this.escolaBo.load(escola.getId());

                boolean ok = true;
                for (Escola e : metodologia.getEscolas()) {
                    if (e.getId() == ((long) escola.getId())) {
                        ok = false;
                    }
                }
                if (ok) {
                    metodologia.addEscola(escola);
                    this.metodologiaBo.persist(metodologia);
                    addActionMessage("Registro salvo com sucesso.");
                } else {
                    addActionMessage("Já existe uma escola cadastrada!");
                }
            } else {
                addActionMessage("Escola não existe!");
            }

        } catch (Exception e) {
             e.printStackTrace();
         }
            return SUCCESS;
        }
    
    @Action(value = "persistMetodologia",
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
            Metodologia entity = null;
            if (metodologia != null && metodologia.getId() != null) {
                entity = metodologiaBo.load(metodologia.getId());
            }
            this.metodologiaBo.persist(metodologia);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listMetodologia");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }
    
    @Action(value = "persistMetodologiaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistMetodologiaJson() {
        try {
            GenericAction.isLogged(request);
            System.out.println("AQUI PORRA");
            System.out.println(metodologia.getId());
            System.out.println(escola.getId());
            
           if (escola.getId() != null) {
                metodologia = this.metodologiaBo.load(metodologia.getId());
                escola = this.escolaBo.load(escola.getId());

                boolean ok = true;
                for (Escola e : metodologia.getEscolas()) {
                    if (e.getId() == ((long) escola.getId())) {
                        ok = false;
                    }
                }
                if (ok) {
                    metodologia.addEscola(escola);
                    this.metodologiaBo.persist(metodologia);
                    jsonReturn = new JsonReturn("Registro salvo com sucesso.", true);
                } else {
                    jsonReturn = new JsonReturn("O fornecedor já incluso no produto.", false);
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
    
    @Action(value = "deleteMetodologia",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            metodologiaBo.delete(metodologia.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listMetodologia");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }
    
    
    
    @Action(value = "listMetodologia",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/metodologia/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }

            Consulta c = getConsulta();
//            c.addAliasTable("escolas", "escolas", JoinType.INNER_JOIN);
            this.metodologias = metodologiaBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }
    
    
    
    
    
    
//    @Action(value = "booleanConditionEnumUsuario",
//            interceptorRefs = {
//                @InterceptorRef(value = "basicStack")},
//            results = {
//                @Result(name = ERROR, location = "/app/notify/")
//                ,
//                @Result(name = SUCCESS, location = "/app/metodologia/formulario.jsp")
//            })
//    public String prepararBoolean() {
//        try {
//            GenericAction.isLogged(request);
//            if (metodologia != null && metodologia.getId() != null) {
//                metodologia = this.metodologia.load(this.metodologia.getId());
//            }
//            return SUCCESS;
//        } catch (Exception e) {
//            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
//            return ERROR;
//        }
//    }
    
    
    
    
    //getters and setters

    public Metodologia getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(Metodologia metodologia) {
        this.metodologia = metodologia;
    }

    public List<Metodologia> getMetodologias() {
        return metodologias;
    }

    public void setMetodologias(List<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }

    public List<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

    public IMetodologiaBo getMetodologiaBo() {
        return metodologiaBo;
    }

    public void setMetodologiaBo(IMetodologiaBo metodologiaBo) {
        this.metodologiaBo = metodologiaBo;
    }

    public IEscolaBo getEscolaBo() {
        return escolaBo;
    }

    public void setEscolaBo(IEscolaBo escolaBo) {
        this.escolaBo = escolaBo;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
    
    
    
    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
//        list.add(new Keys("escola.nome", "Escola"));
        return list;
    }
    
    @JSON(serialize = false)
    public List getAplicabilidadeEnums() {
        return Arrays.asList(AplicabilidadeEnum.values());
    }
    
    //métodos abstratos

    @Override
    public void prepare() throws Exception {
        setMenu(Metodologia.class.getSimpleName());
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
