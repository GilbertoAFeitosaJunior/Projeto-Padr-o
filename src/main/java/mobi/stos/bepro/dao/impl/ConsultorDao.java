package mobi.stos.bepro.dao.impl;

import mobi.stos.bepro.bean.Consultor;
import mobi.stos.bepro.common.AbstractHibernateDao;
import mobi.stos.bepro.dao.IConsultorDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultorDao extends AbstractHibernateDao<Consultor> implements IConsultorDao {

    public ConsultorDao() {
        super(Consultor.class);
    }

    @Override
    public Consultor byHash(String hash) {
        Criteria criteria = getCurrentSession().createCriteria(Consultor.class);
        criteria.add(Restrictions.eq("hash", hash));
        criteria.setMaxResults(1);
        return (Consultor) criteria.uniqueResult();
    }

    @Override
    public Consultor byFirebase(String firebase) {
        Criteria criteria = getCurrentSession().createCriteria(Consultor.class);
        criteria.add(Restrictions.eq("firebase", firebase));
        criteria.setMaxResults(1);
        return (Consultor) criteria.uniqueResult();
    }
}
