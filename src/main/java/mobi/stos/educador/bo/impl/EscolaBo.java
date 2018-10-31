
package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bo.IEscolaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IEscolaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DEVJAVA
 */

@Service
public class EscolaBo extends AbstractService<Escola> implements IEscolaBo {
    
    @Autowired
    private IEscolaDao dao;

    @Override
    protected IOperations<Escola> getDao() {
        return dao;
    }
    
    

}
