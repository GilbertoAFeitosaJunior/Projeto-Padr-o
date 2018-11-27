

package mobi.stos.educador.dao.impl;

import java.util.List;
import mobi.stos.educador.bean.Turma;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.ITurmaDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class TurmaDao extends AbstractHibernateDao<Turma> implements ITurmaDao{

    public TurmaDao() {
        super(Turma.class);
    }

    @Override
    public List<Turma> byEscolaId(Long idEscola) {
        Criteria criteria = getCurrentSession().createCriteria(Turma.class);
        criteria.add(Restrictions.eq("escola.id", idEscola));
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }

}
