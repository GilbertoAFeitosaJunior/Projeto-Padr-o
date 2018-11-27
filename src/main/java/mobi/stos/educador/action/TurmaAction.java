

package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Turma;
import mobi.stos.educador.bo.IEscolaBo;
import mobi.stos.educador.bo.ITurmaBo;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.jsonReturn;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.util.JsonReturn;
import mobi.stos.educador.util.consulta.Consulta;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class TurmaAction extends GenericAction{
    
    private Turma turma;
    private Escola escola;
    
    private List<Escola> escolas;
    private List<Turma> turmas;
    
    @Autowired
    private IEscolaBo escolaBo;
    
    @Autowired
    private ITurmaBo turmaBo;
    
    @Action(value = "persistTurmaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persistTurmaJson() {
        try {
            GenericAction.isLogged(request);
            
            turma.setEscola(new Escola(escola.getId()));
            this.turmaBo.persist(turma);
            
           jsonReturn = new JsonReturn("Registro adicionado com sucesso.", true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    @Action(value = "listTurmaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String listTurmaJson() {
        try {
            GenericAction.isLogged(request);
            
            if(escola.getId() != null){
                this.turmas = this.turmaBo.byEscolaId(escola.getId());
            }
            
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }
    @Action(value = "deleteTurmaJson",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String deleteTurmaJson() {
        try {
            GenericAction.isLogged(request);
            
            if(turma.getId() != null){
               this.turmaBo.delete(turma.getId());
            }
            
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }
    
      @Override
    public JsonReturn getJsonReturn() {
        return super.getJsonReturn(); 
    }

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Escola getEscola() {
        return escola;
    }
    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public List<Escola> getEscolas() {
        return escolas;
    }
    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Turma.class.getSimpleName());
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
