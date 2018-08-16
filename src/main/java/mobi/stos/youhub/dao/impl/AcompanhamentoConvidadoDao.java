package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.AcompanhamentoConvidado;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IAcompanhamentoConvidadoDao;
import org.springframework.stereotype.Repository;

@Repository
public class AcompanhamentoConvidadoDao extends AbstractHibernateDao<AcompanhamentoConvidado> implements IAcompanhamentoConvidadoDao {

    public AcompanhamentoConvidadoDao() {
        super(AcompanhamentoConvidado.class);
    }

}
