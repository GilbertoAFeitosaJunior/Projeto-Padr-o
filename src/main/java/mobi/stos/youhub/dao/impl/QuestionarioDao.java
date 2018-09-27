package mobi.stos.youhub.dao.impl;

import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IQuestionarioDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.DateType;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionarioDao extends AbstractHibernateDao<Questionario> implements IQuestionarioDao {

    public QuestionarioDao() {
        super(Questionario.class);
    }

    @Override
    public List<Questionario> agendamentoQuestionario(Long idManager, Date data) {
        Criteria criteria = getCurrentSession().createCriteria(Questionario.class);
        criteria.createAlias("convidado", "convidado", JoinType.INNER_JOIN);
        criteria.createAlias("convidado.manager", "manager", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("manager.id", idManager));
        criteria.add(Restrictions.sqlRestriction("DATE(this_.acompanhamentoagendado) = ?", new Object[]{
            data
        }, new DateType[]{
            DateType.INSTANCE
        }));
        criteria.addOrder(Order.asc("acompanhamentoAgendado"));
        return criteria.list();
    }
}
