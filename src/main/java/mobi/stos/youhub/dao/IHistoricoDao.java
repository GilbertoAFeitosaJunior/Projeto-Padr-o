package mobi.stos.youhub.dao;

import java.util.List;
import mobi.stos.youhub.bean.Historico;
import mobi.stos.youhub.common.IOperations;

public interface IHistoricoDao extends IOperations<Historico> {

    List<Historico> historicoAgendamento(Long idQuestionario);
}
