package mobi.stos.youhub.restful.model;

import java.util.Date;

/**
 *
 * @author feito
 */
public class QuestionarioHelper {

    private Long idManager;
    private Long idQuestionario;
    private String menssagem;
    private Date data;

    public QuestionarioHelper() {
    }

    public QuestionarioHelper(Long idManager, Long idQuestionario, Date data) {
        this.idManager = idManager;
        this.idQuestionario = idQuestionario;
        this.data = data;
    }

    public QuestionarioHelper(Long idManager, Long idQuestionario, String menssagem, Date data) {
        this.idManager = idManager;
        this.idQuestionario = idQuestionario;
        this.menssagem = menssagem;
        this.data = data;
    }

    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }

    public Long getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Long idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
