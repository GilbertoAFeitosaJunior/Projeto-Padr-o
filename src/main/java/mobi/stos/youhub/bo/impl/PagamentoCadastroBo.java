package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.PagamentoCadastro;
import mobi.stos.youhub.bo.IPagamentoCadastroBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IPagamentoCadastroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoCadastroBo extends AbstractService<PagamentoCadastro> implements IPagamentoCadastroBo {

    @Autowired
    private IPagamentoCadastroDao dao;

    @Override
    protected IOperations<PagamentoCadastro> getDao() {
        return dao;
    }

}
