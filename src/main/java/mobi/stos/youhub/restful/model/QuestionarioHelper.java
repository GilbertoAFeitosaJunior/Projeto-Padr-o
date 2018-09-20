package mobi.stos.youhub.restful.model;

import java.util.Date;

/**
 *
 * @author feito
 */
public class QuestionarioHelper {

    private Long idManager;
    private Long idQuestionario;
    private Date data;

    public QuestionarioHelper(Long idManager, Long idQuestionario, Date data) {
        this.idManager = idManager;
        this.idQuestionario = idQuestionario;
        this.data = data;
    }

    public QuestionarioHelper() {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
