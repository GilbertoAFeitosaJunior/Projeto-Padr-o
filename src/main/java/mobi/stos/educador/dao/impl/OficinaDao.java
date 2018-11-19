
package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IOficinaDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class OficinaDao extends AbstractHibernateDao<Oficina> implements IOficinaDao{
    
    public OficinaDao() {
        super(Oficina.class);
    }
    
    
}
