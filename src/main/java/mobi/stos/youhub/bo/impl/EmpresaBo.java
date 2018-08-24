package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.Empresa;
import mobi.stos.youhub.bo.IEmpresaBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IEmpresaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaBo extends AbstractService<Empresa> implements IEmpresaBo {

    @Autowired
    private IEmpresaDao dao;

    @Override
    protected IOperations<Empresa> getDao() {
        return dao;
    }

}
