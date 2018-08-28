package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IManagerDao;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDao extends AbstractHibernateDao<Manager> implements IManagerDao {

    public ManagerDao() {
        super(Manager.class);
    }

}
