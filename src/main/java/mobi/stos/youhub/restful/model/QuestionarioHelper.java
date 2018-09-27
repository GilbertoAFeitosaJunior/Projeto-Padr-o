package mobi.stos.youhub.restful.model;

import java.util.Date;
import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bean.Questionario;

/**
 *
 * @author feito
 */
public class QuestionarioHelper {

    private Long idManager;
    private Date data;
    private Convidado convidado;
    private Questionario questionario;
    private Long idQuestionario;
    private Long idMananger;
    private String menssagem;

    public QuestionarioHelper() {
    }

    public QuestionarioHelper(Convidado convidado, Questionario questionario) {
        this.convidado = convidado;
        this.questionario = questionario;
    }

    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public Long getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Long idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public Long getIdMananger() {
        return idMananger;
    }

    public void setIdMananger(Long idMananger) {
        this.idMananger = idMananger;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

}
