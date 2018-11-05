package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.bo.IMetodologiaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.impl.MetodologiaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaBo extends AbstractService<Metodologia> implements IMetodologiaBo{
    
    @Autowired
    private MetodologiaDao dao;

    @Override
    protected IOperations<Metodologia> getDao() {
        return dao;
    }
    
}
