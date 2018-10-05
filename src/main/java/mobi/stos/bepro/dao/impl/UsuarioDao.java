package mobi.stos.bepro.dao.impl;

import mobi.stos.bepro.bean.Usuario;
import mobi.stos.bepro.common.AbstractHibernateDao;
import mobi.stos.bepro.dao.IUsuarioDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao extends AbstractHibernateDao<Usuario> implements IUsuarioDao {

    public UsuarioDao() {
        super(Usuario.class);
    }

    @Override
    public Usuario byEmail(String email) {
        Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("email", email).ignoreCase());
        criteria.setMaxResults(1);
        return (Usuario) criteria.uniqueResult();
    }

    @Override
    public Usuario byHash(String hash) {
        Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("hash", hash));
        criteria.setMaxResults(1);
        return (Usuario) criteria.uniqueResult();
    }

}
