package mobi.stos.youhub.dao.impl;

import java.util.List;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IUsuarioDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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

    @Override
    public List<Usuario> listConsultorByManager(Long idMananger) {
        Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
        criteria.createAlias("consultor", "consultor", JoinType.INNER_JOIN);
        criteria.createAlias("consultor.manager", "manager", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("manager.id", idMananger));
        criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Override
    public Usuario loadByConsultor(Long idConsultor) {
        Criteria criteria = getCurrentSession().createCriteria(Usuario.class);
        criteria.createAlias("consultor", "consultor", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("consultor.id", idConsultor));
        criteria.setMaxResults(1);
        return (Usuario) criteria.uniqueResult();
    }

}
