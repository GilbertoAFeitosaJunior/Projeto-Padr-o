package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.AcompanhamentoConvidado;
import mobi.stos.youhub.bo.IAcompanhamentoConvidadoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IAcompanhamentoConvidadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcompanhamentoConvidadoBo extends AbstractService<AcompanhamentoConvidado> implements IAcompanhamentoConvidadoBo {

    @Autowired
    private IAcompanhamentoConvidadoDao dao;

    @Override
    protected IOperations<AcompanhamentoConvidado> getDao() {
        return dao;
    }

}
