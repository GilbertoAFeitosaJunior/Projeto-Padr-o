package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.bo.IIngressoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IIngressoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngressoBo extends AbstractService<Ingresso> implements IIngressoBo {

    @Autowired
    private IIngressoDao dao;

    @Override
    protected IOperations<Ingresso> getDao() {
        return dao;
    }

}
