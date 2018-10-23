package mobi.stos.bepro.bo.impl;

import mobi.stos.bepro.bean.Podcast;
import mobi.stos.bepro.bo.IPodcastBo;
import mobi.stos.bepro.common.AbstractService;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.dao.IPodcastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodcastBo extends AbstractService<Podcast> implements IPodcastBo {

    @Autowired
    private IPodcastDao dao;

    @Override
    protected IOperations<Podcast> getDao() {
        return dao;
    }

}
