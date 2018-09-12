package mobi.stos.youhub.bo.impl;

import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.bo.IManagerBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IManagerDao;
import mobi.stos.youhub.restful.model.QueryConvidado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerBo extends AbstractService<Manager> implements IManagerBo {

    @Autowired
    private IManagerDao dao;

    @Override
    protected IOperations<Manager> getDao() {
        return dao;
    }

    @Override
    public List<Consultor> consultoresNoEvento(QueryConvidado queryConvidado) {
        return dao.consultoresNoEvento(queryConvidado);
    }

}
