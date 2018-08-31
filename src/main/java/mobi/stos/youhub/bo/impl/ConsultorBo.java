package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bo.IConsultorBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IConsultorDao;
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

}
