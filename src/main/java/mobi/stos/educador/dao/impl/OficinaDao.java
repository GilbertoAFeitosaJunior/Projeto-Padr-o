
package mobi.stos.educador.dao.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IOficinaDao;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class OficinaDao extends AbstractHibernateDao<Oficina> implements IOficinaDao{
    
    public OficinaDao() {
        super(Oficina.class);
    }
    
    @Override
    public Oficina load(Long id) {
        Oficina oficina = super.load(id);
        if (oficina != null) {
            oficina.setAtividades(this.listAtividades(id));
        }   
        return oficina;
    }

    private Set<Atividade> listAtividades(Long idOficina) {
        Set<Atividade> set = new HashSet<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("a.id, a.nome, a.descricao ");
        sql.append("FROM atividade a ");
        sql.append("INNER JOIN oficina_atividade oa ON oa.atividade_id = a.id ");
        sql.append("WHERE oa.oficina_id = :o_id ");
        sql.append("ORDER BY id");
        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());

        query.setParameter("o_id", idOficina);
        List result = query.list();

        for (Object obj : result) {
            Object[] tuple = (Object[]) obj;
            Atividade entity = new Atividade();
            entity.setId(((BigInteger) tuple[0]).longValue());
            entity.setNome((String) tuple[1]);
            entity.setDescricao((String) tuple[2]);
            
            set.add(entity);
        }
        return set;
    }
    
    @Override
    public void deleteOficinaAtividade(long idOficina, long idAtividade) {
        
          Oficina oficina = super.load(idOficina);

        if (oficina != null) {
            StringBuilder sql = new StringBuilder();
            sql.append(" DELETE ");
            sql.append(" FROM oficina_atividade a ");
            sql.append(" WHERE a.oficina_id = :oficina_id and a.atividade_id = :atividade_id ");
            SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
            query.setParameter("oficina_id", idOficina);
            query.setParameter("atividade_id", idAtividade);
            query.executeUpdate();
        }
    }
    
}
