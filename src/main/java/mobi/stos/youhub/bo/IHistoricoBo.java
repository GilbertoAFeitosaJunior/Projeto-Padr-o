package mobi.stos.youhub.bo;

import java.util.List;
import mobi.stos.youhub.bean.Historico;
import mobi.stos.youhub.common.IOperations;

public interface IHistoricoBo extends IOperations<Historico> {

    List<Historico> historicoAgendamento(Long idQuestionario);

}
