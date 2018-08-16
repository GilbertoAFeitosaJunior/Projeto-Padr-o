package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IDiretorSalaDao;
import org.springframework.stereotype.Repository;

@Repository
public class DiretorSalaDao extends AbstractHibernateDao<DiretorSala> implements IDiretorSalaDao {

    public DiretorSalaDao() {
        super(DiretorSala.class);
    }

   
}
