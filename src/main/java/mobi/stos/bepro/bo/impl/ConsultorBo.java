package mobi.stos.bepro.bo.impl;

import mobi.stos.bepro.bean.Consultor;
import mobi.stos.bepro.bo.IConsultorBo;
import mobi.stos.bepro.common.AbstractService;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.dao.IConsultorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultorBo extends AbstractService<Consultor> implements IConsultorBo {

    @Autowired
    private IConsultorDao dao;

    @Override
    protected IOperations<Consultor> getDao() {
        return dao;
    }

    @Override
    public Consultor byHash(String hash) {
        return dao.byHash(hash);
    }

    @Override
    public Consultor byFirebase(String firebase) {
        return dao.byFirebase(firebase);
    }

}
