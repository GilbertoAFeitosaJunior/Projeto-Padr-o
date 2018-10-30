package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Projeto;
import mobi.stos.educador.bo.IProjetoBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IProjetoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoBo extends AbstractService<Projeto> implements IProjetoBo {

    @Autowired
    private IProjetoDao dao;

    @Override
    protected IOperations<Projeto> getDao() {
        return dao;
    }

}
