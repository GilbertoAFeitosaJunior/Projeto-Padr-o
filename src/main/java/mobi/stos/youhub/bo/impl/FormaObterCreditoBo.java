package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.FormaObterCredito;
import mobi.stos.youhub.bo.IFormaObterCreditoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IFormaObterCreditoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormaObterCreditoBo extends AbstractService<FormaObterCredito> implements IFormaObterCreditoBo {

    @Autowired
    private IFormaObterCreditoDao dao;

    @Override
    protected IOperations<FormaObterCredito> getDao() {
        return dao;
    }

}
