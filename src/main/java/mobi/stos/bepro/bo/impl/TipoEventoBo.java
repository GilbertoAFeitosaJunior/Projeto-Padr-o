package mobi.stos.bepro.bo.impl;

import mobi.stos.bepro.bean.TipoEvento;
import mobi.stos.bepro.bo.ITipoEventoBo;
import mobi.stos.bepro.common.AbstractService;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.dao.ITipoEventoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEventoBo extends AbstractService<TipoEvento> implements ITipoEventoBo {

    @Autowired
    private ITipoEventoDao dao;

    @Override
    protected IOperations<TipoEvento> getDao() {
        return dao;
    }

}
