package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.RelatorioAcompanhamentoConvidado;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IRelatorioAcompanhamentoConvidadoDao;
import org.springframework.stereotype.Repository;

@Repository
public class RelatorioAcompanhamentoConvidadoDao extends AbstractHibernateDao<RelatorioAcompanhamentoConvidado> implements IRelatorioAcompanhamentoConvidadoDao {

    public RelatorioAcompanhamentoConvidadoDao() {
        super(RelatorioAcompanhamentoConvidado.class);
    }

}
