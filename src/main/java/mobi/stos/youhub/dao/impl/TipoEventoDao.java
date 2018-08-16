package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.TipoEvento;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.ITipoEventoDao;
import org.springframework.stereotype.Repository;

@Repository
public class TipoEventoDao extends AbstractHibernateDao<TipoEvento> implements ITipoEventoDao {

    public TipoEventoDao() {
        super(TipoEvento.class);
    }

   
}
