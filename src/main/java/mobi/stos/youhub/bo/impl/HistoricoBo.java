package mobi.stos.youhub.bo.impl;

import java.util.List;
import mobi.stos.youhub.bean.Historico;
import mobi.stos.youhub.bo.IHistoricoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IHistoricoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoBo extends AbstractService<Historico> implements IHistoricoBo {

    @Autowired
    private IHistoricoDao dao;

    @Autowired
    private IHistoricoDao historicoDao;

    @Override
    protected IOperations<Historico> getDao() {
        return dao;
    }

    @Override
    public List<Historico> historicoAgendamento(Long idQuestionario) {
        return dao.historicoAgendamento(idQuestionario);
    }

}
