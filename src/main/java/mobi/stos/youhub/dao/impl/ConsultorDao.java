package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IConsultorDao;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultorDao extends AbstractHibernateDao<Consultor> implements IConsultorDao {

    public ConsultorDao() {
        super(Consultor.class);
    }

}
