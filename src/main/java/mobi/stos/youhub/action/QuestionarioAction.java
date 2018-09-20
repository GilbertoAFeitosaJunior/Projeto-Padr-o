package mobi.stos.youhub.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.bo.IConvidadoBo;
import mobi.stos.youhub.bo.IQuestionarioBo;
import mobi.stos.youhub.common.GenericAction;
import mobi.stos.youhub.enumm.AtividadeAtualEnum;
import mobi.stos.youhub.enumm.RendaMediaEnum;
import mobi.stos.youhub.enumm.SituacaoFechamentoEnum;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class QuestionarioAction extends GenericAction {

    private Questionario questionario;

    @Autowired
    private IQuestionarioBo questionarioBo;

    @Autowired
    private IConvidadoBo convidadoBo;

    @Action(value = "persitQuestionario",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String preparar() {
        try {

            System.out.println("######################## entrou aqui...");
            Convidado convidado = this.convidadoBo.load(14l);

            Questionario q = new Questionario();

            q.setIdade(33);
            q.setAtividadeAtualEnum(AtividadeAtualEnum.AUTONOMO);
            q.setCargaHoraria("12");
            q.setRendaMediaEnum(RendaMediaEnum.ATE_2_MIL);
            q.setPossuiRendaResidual(true);
            q.setTemPlanoSaude(true);
            q.setTemFilhos(true);
            q.setQtdFilhos(3);
            q.setSonho1("sonho1");
            q.setSonho2("sonho2");
            q.setSonho3("sonho3");
            q.setEscolaParticular(true);
            q.setObjecao1("objeção 111");
            q.setObjecao2("Objeção 2");
            q.setObjecao3("Objeção 3");
            q.setOpcaoInvestimento1("Opçãod de investimento 1");
            q.setOpcaoInvestimento2("Opção de Investimento 2");
            q.setOpcaoInvestimento3("Opção de investimento 3");
            q.setAcompanhamentoAgendado(new Date());
            q.setAcompanhamentoAgendado(new Date());
            q.setConvidado(convidado);
            q.setSituacaoFechamentoEnum(SituacaoFechamentoEnum.ABERTO);
            System.out.println("######################## entrou aqui...");
            this.questionario = new  Questionario();
            this.questionario = this.questionarioBo.persist(q);

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Questionario.class.getSimpleName());
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
