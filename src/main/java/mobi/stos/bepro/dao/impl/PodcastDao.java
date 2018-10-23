package mobi.stos.bepro.dao.impl;

import mobi.stos.bepro.bean.Podcast;
import mobi.stos.bepro.common.AbstractHibernateDao;
import mobi.stos.bepro.dao.IPodcastDao;
import org.springframework.stereotype.Repository;

@Repository
public class PodcastDao extends AbstractHibernateDao<Podcast> implements IPodcastDao {

    public PodcastDao() {
        super(Podcast.class);
    }

}
