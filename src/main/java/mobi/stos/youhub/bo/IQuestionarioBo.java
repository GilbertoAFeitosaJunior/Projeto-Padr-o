package mobi.stos.youhub.bo;

import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.common.IOperations;

public interface IQuestionarioBo extends IOperations<Questionario> {

    List<Questionario> agendamentoQuestionario(Long idManager, Date data);

}
