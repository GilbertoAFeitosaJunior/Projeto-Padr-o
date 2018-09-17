package mobi.stos.youhub.bo.impl;

import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.bo.IEventoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IEventoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoBo extends AbstractService<Evento> implements IEventoBo {

    @Autowired
    private IEventoDao dao;

    @Override
    protected IOperations<Evento> getDao() {
        return dao;
    }

    @Override
    public List<Evento> eventoPorData(Long idManager, Date dataInicio) {
        return dao.eventoPorData(idManager, dataInicio);
    }

}
