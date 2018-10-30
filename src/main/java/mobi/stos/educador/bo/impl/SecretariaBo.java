package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Secretaria;
import mobi.stos.educador.bo.ISecretariaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.ISecretariaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretariaBo extends AbstractService<Secretaria> implements ISecretariaBo{
    
    @Autowired
    private ISecretariaDao dao;

    @Override
    protected IOperations<Secretaria> getDao() {
        return dao;
    }
    
    
    
}
