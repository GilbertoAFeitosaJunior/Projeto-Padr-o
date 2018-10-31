
package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IEscolaDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class EscolaDao extends AbstractHibernateDao<Escola> implements IEscolaDao {

    public EscolaDao() {
        super(Escola.class);
    }

    
}
