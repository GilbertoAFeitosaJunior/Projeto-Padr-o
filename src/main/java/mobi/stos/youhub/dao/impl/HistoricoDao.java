package mobi.stos.youhub.dao.impl;

import java.util.List;
import mobi.stos.youhub.bean.Historico;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IHistoricoDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

@Repository
public class HistoricoDao extends AbstractHibernateDao<Historico> implements IHistoricoDao {

    public HistoricoDao() {
        super(Historico.class);
    }

    @Override
    public List<Historico> historicoAgendamento(Long idQuestionario) {
        Criteria criteria = getCurrentSession().createCriteria(Historico.class);
        criteria.createAlias("questionario", "questionario", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("questionario.id", idQuestionario));
        criteria.addOrder(Order.desc("dataContato"));

        return criteria.list();
    }

}
