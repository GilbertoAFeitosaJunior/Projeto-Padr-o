
package mobi.stos.educador.dao.impl;

import java.util.List;
import mobi.stos.educador.bean.Anexo;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IAnexoDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class AnexoDao extends AbstractHibernateDao<Anexo> implements IAnexoDao{

    public AnexoDao() {
        super(Anexo.class);
    }
    
    
    @Override
    public List<Anexo> byOficinaId(Long idOficina) {
        Criteria criteria = getCurrentSession().createCriteria(Anexo.class);
        criteria.add(Restrictions.eq("oficina.id", idOficina));
        criteria.addOrder(Order.desc("id"));
        return criteria.list();
    }


}
