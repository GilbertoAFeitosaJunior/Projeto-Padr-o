package mobi.stos.educador.dao.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IAtividadeDao;
import mobi.stos.educador.enumm.AplicabilidadeEnum;
import mobi.stos.educador.enumm.FaixaEtariaEnum;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

/**
 * @author Rafael Bloise
 */
@Repository
public class AtividadeDao extends AbstractHibernateDao<Atividade> implements IAtividadeDao{
    
    public AtividadeDao(){
        super(Atividade.class);
    }
    
    
    @Override
    public Atividade load(Long id) {
        Atividade atividade = super.load(id);
        if (atividade != null) {
            atividade.setMetodologias(this.listMetodologia(id));
        }   
        return atividade;
    }
    
    private Set<Metodologia> listMetodologia (long idAtividade) {

        Set<Metodologia> set = new HashSet<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("a.id, a.nome, a.descricao, a.aplicabilidadeEnum, a.ativo, a.objetivo, a.faixaEtariaEnum ");
        sql.append("FROM metodologia a ");
        sql.append("INNER JOIN atividade_metodologia b ON b.metodologia_id = a.id ");
        sql.append("WHERE b.atividade_id = :id ");
        sql.append("ORDER BY id");
        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());

        query.setParameter("id", idAtividade);
        List result = query.list();

        for (Object obj : result) {
            Object[] tuple = (Object[]) obj;
            Metodologia entity = new Metodologia();
            entity.setId(((BigInteger) tuple[0]).longValue());
            entity.setNome((String) tuple[1]);
            entity.setDescricao((String) tuple[2]);
            entity.setAplicabilidadeEnum(AplicabilidadeEnum.retornaEnumNaPosicao((int) tuple[3]));
            entity.setAtivo((Boolean) tuple[4]);
            entity.setObjetivo((String) tuple[5]);
            entity.setFaixaEtariaEnum(FaixaEtariaEnum.retornaEnumNaPosicao((int) tuple[6]));

            
            
            set.add(entity);
        }

        return set;
    }
    
    
    

    @Override
    public void deleteAtividadeMetodologia(long idAtividade, long idMetodologia) {
        
         Atividade atividade = super.load(idAtividade);

        if (atividade != null) {
            StringBuilder sql = new StringBuilder();
            sql.append(" DELETE ");
            sql.append(" FROM atividade_metodologia a ");
            sql.append(" WHERE a.atividade_id = :atividade_id and a.metodologia_id = :metodologia_id ");
            SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
            query.setParameter("atividade_id", idAtividade);
            query.setParameter("metodologia_id", idMetodologia);
            query.executeUpdate();
        }
        
        
    }
    
}
