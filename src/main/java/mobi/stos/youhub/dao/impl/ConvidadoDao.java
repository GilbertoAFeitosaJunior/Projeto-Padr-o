package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IConvidadoDao;
import org.springframework.stereotype.Repository;

@Repository
public class ConvidadoDao extends AbstractHibernateDao<Convidado> implements IConvidadoDao {

    public ConvidadoDao() {
        super(Convidado.class);
    }

}
