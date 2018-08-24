package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.Empresa;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IEmpresaDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaDao extends AbstractHibernateDao<Empresa> implements IEmpresaDao {

    public EmpresaDao() {
        super(Empresa.class);
    }

}
