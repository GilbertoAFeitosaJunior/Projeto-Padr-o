package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IIngressoDao;
import org.springframework.stereotype.Repository;

@Repository
public class IngressoDao extends AbstractHibernateDao<Ingresso> implements IIngressoDao {

    public IngressoDao() {
        super(Ingresso.class);
    }

   
}
