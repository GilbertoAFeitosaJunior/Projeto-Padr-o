package mobi.stos.bepro.bo.impl;

import mobi.stos.bepro.bean.Convidado;
import mobi.stos.bepro.bo.IConvidadoBo;
import mobi.stos.bepro.common.AbstractService;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.dao.IConvidadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoBo extends AbstractService<Convidado> implements IConvidadoBo {

    @Autowired
    private IConvidadoDao dao;

    @Override
    protected IOperations<Convidado> getDao() {
        return dao;
    }

  
}
