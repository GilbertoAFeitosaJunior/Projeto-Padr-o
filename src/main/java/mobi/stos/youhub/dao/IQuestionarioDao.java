package mobi.stos.youhub.dao;

import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.common.IOperations;

public interface IQuestionarioDao extends IOperations<Questionario> {

    List<Questionario> agendamentoQuestionario(Long idManager, Date data);
}
