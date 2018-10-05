package mobi.stos.bepro.dao.impl;

import mobi.stos.bepro.bean.Convidado;
import mobi.stos.bepro.common.AbstractHibernateDao;
import mobi.stos.bepro.dao.IConvidadoDao;
import org.springframework.stereotype.Repository;

@Repository
public class ConvidadoDao extends AbstractHibernateDao<Convidado> implements IConvidadoDao {

    public ConvidadoDao() {
        super(Convidado.class);
    }
}
