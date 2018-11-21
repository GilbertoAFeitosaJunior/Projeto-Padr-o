package mobi.stos.educador.dao.impl;

import java.util.List;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IUsuarioDao;
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

    @Override
    public List<Usuario> listSomenteUsuarios() {
        Criteria consulta = getCurrentSession().createCriteria(Usuario.class);
        consulta.createAlias("coordenadorPedagogico", "coordenadorPedagogico", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
        consulta.createAlias("coordenadorDeProjeto", "coordenadorDeProjeto", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
        consulta.createAlias("gestorDoTerritorio", "gestorDoTerritorio", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);
        consulta.createAlias("educador", "educador", org.hibernate.sql.JoinType.LEFT_OUTER_JOIN);

        consulta.add(Restrictions.and(
                Restrictions.isNull("coordenadorPedagogico.id"),
                Restrictions.isNull("coordenadorDeProjeto.id"),
                Restrictions.isNull("gestorDoTerritorio.id"),
                Restrictions.isNull("educador.id")
        ));
        return consulta.list();

    }
    
}
