package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.FormaObterCredito;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IFormaObterCreditoDao;
import org.springframework.stereotype.Repository;

@Repository
public class FormaObterCreditoDao extends AbstractHibernateDao<FormaObterCredito> implements IFormaObterCreditoDao {

    public FormaObterCreditoDao() {
        super(FormaObterCredito.class);
    }

   
}
