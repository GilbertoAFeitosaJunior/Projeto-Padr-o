package mobi.stos.bepro.dao.impl;

import mobi.stos.bepro.bean.Evento;
import mobi.stos.bepro.common.AbstractHibernateDao;
import mobi.stos.bepro.dao.IEventoDao;
import org.springframework.stereotype.Repository;

@Repository
public class EventoDao extends AbstractHibernateDao<Evento> implements IEventoDao {
    
    public EventoDao() {
        super(Evento.class);
    }
    
}
