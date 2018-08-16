package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bo.IConvidadoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IConvidadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConviadoBo extends AbstractService<Convidado> implements IConvidadoBo {

    @Autowired
    private IConvidadoDao dao;

    @Override
    protected IOperations<Convidado> getDao() {
        return dao;
    }

}
