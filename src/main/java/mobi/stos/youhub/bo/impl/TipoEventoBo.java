package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.TipoEvento;
import mobi.stos.youhub.bo.ITipoEventoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.ITipoEventoDao;
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
