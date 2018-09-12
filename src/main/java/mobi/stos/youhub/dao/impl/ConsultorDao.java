package mobi.stos.youhub.dao.impl;

import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IConsultorDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultorDao extends AbstractHibernateDao<Consultor> implements IConsultorDao {

    public ConsultorDao() {
        super(Consultor.class);
    }

    @Override
    public List<Consultor> listByConsultor(long idManager) {
        Criteria criteria = getCurrentSession().createCriteria(Consultor.class);
        criteria.createAlias("manager", "manager", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("manager.id", idManager));
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }
}
