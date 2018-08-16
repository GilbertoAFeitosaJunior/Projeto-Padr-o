package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IEventoDao;
import org.springframework.stereotype.Repository;

@Repository
public class EventoDao extends AbstractHibernateDao<Evento> implements IEventoDao {

    public EventoDao() {
        super(Evento.class);
    }
  
}
