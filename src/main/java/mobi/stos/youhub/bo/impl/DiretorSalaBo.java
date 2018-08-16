package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.bo.IDiretorSalaBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IDiretorSalaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorSalaBo extends AbstractService<DiretorSala> implements IDiretorSalaBo {

    @Autowired
    private IDiretorSalaDao dao;

    @Override
    protected IOperations<DiretorSala> getDao() {
        return dao;
    }

}
