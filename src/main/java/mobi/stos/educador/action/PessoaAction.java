package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Pessoa;
import mobi.stos.educador.bo.IPessoaBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.enumm.GeneroEnum;
import mobi.stos.educador.enumm.SexoEnum;
import mobi.stos.educador.util.AES;
import static mobi.stos.educador.util.AES.decrypt;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */

public class PessoaAction extends GenericAction{
    
    private Pessoa pessoa;
    
    private List<Pessoa> pessoas;
    
    @Autowired
    private IPessoaBo pessoaBo;
    
     @Action(value = "preparePessoa",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
            @Result(name = SUCCESS, location = "/app/pessoa/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (pessoa != null && pessoa.getId() != null) {
                pessoa = this.pessoaBo.load(pessoa.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistPessoa",
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
            Pessoa entity;
            if (pessoa != null && pessoa.getId() != null) {
                entity = pessoaBo.load(pessoa.getId());
            }
            
            String ufMaiusculo = pessoa.getUf().toUpperCase();
            pessoa.setUf(ufMaiusculo);
            this.pessoaBo.persist(pessoa);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listPessoa");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "listPessoa",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/pessoa/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            Consulta c = getConsulta();
//            pessoa.getNome() = decrypt(getPessoa().nomeEncriptado(), AES.chaveencriptacao);
            this.pessoas = pessoaBo.list(c);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }
    
     @Action(value = "deletePessoa",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            pessoaBo.delete(pessoa.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listPessoa");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }
    
    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        return list;
    }
    
    @JSON(serialize = false)
    public List getSexoEnums() {
        return Arrays.asList(SexoEnum.values());
    }
    
    @JSON(serialize = false)
    public List getGeneroEnums() {
        return Arrays.asList(GeneroEnum.values());
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Pessoa.class.getSimpleName());
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
