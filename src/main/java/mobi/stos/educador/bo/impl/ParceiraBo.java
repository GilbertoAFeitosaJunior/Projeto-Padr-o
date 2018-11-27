package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Parceira;
import mobi.stos.educador.bo.IParceiraBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IParceiraDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rafael Bloise
 */
@Service
public class ParceiraBo extends AbstractService<Parceira> implements IParceiraBo {

    @Autowired
    private IParceiraDao dao;

    @Override
    protected IOperations<Parceira> getDao() {
        return dao;
    }

}
