package mobi.stos.youhub.bo.impl;

import mobi.stos.youhub.bean.RelatorioAcompanhamentoConvidado;
import mobi.stos.youhub.bo.IRelatorioAcompanhamentoConvidadoBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IRelatorioAcompanhamentoConvidadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioAcompanhamentoConvidadoBo extends AbstractService<RelatorioAcompanhamentoConvidado> implements IRelatorioAcompanhamentoConvidadoBo {

    @Autowired
    private IRelatorioAcompanhamentoConvidadoDao dao;

    @Override
    protected IOperations<RelatorioAcompanhamentoConvidado> getDao() {
        return dao;
    }

}
