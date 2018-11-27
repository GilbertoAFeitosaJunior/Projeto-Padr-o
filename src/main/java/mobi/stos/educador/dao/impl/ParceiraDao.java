package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.Parceira;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IParceiraDao;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael Bloise
 */
@Repository
public class ParceiraDao extends AbstractHibernateDao<Parceira> implements IParceiraDao{

    public ParceiraDao() {
        super(Parceira.class);
    }
    
    
    
}
