package mobi.stos.bepro.dao.impl;

import mobi.stos.bepro.bean.TipoEvento;
import mobi.stos.bepro.common.AbstractHibernateDao;
import mobi.stos.bepro.dao.ITipoEventoDao;
import org.springframework.stereotype.Repository;

@Repository
public class TipoEventoDao extends AbstractHibernateDao<TipoEvento> implements ITipoEventoDao {

    public TipoEventoDao() {
        super(TipoEvento.class);
    }
}
