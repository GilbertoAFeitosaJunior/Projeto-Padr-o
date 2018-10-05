package mobi.stos.bepro.bo.impl;

import java.util.Date;
import java.util.List;
import mobi.stos.bepro.bean.Evento;
import mobi.stos.bepro.bo.IEventoBo;
import mobi.stos.bepro.common.AbstractService;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.dao.IEventoDao;
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

}
