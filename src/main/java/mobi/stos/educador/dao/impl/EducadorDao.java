
package mobi.stos.educador.dao.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Projeto;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IEducadorDao;
import mobi.stos.educador.enumm.NivelRelacionamentoEnum;
import mobi.stos.educador.enumm.SituacaoProjetoEnum;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class EducadorDao extends AbstractHibernateDao<Educador> implements IEducadorDao{

    public EducadorDao() {
        super(Educador.class);
    }
    
    @Override
    public Educador load(Long id) {
        Educador educador = super.load(id);
        if (educador != null) {
            educador.setEscolas(this.listEscola(id));
        }
        return educador;        
    }
    
     private Set<Escola> listEscola(long idEducador) {

        Set<Escola> set = new HashSet<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("a.id, a.projeto_id, a.nome, a.bairro, a.cep, a.cidade, a.complemento, a.logradouro, a.numero,"
                + " a.uf, a.nivelRelacionamentoEnum, a.responsavel, a.responsavelContato, a.situacaoEnum, a.inep ");
        sql.append("FROM escola a ");
        sql.append("INNER JOIN educador_escola b ON b.escola_id= a.id ");
        sql.append("WHERE b.educador_id = :id ");
        sql.append("ORDER BY id");
        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());

        query.setParameter("id", idEducador);
        List result = query.list();

        for (Object obj : result) {
            Object[] tuple = (Object[]) obj;
            Escola entity = new Escola();
            entity.setId(((BigInteger) tuple[0]).longValue());
            entity.setProjeto(new Projeto(((BigInteger) tuple[1]).longValue()));
            entity.setNome((String) tuple[2]);
            entity.setBairro((String) tuple[3]);
            entity.setCep(((Integer) tuple[4]));
            entity.setCidade((String) tuple[5]);
            entity.setComplemento((String) tuple[6]);
            entity.setLogradouro((String) tuple[7]);
            entity.setNumero((String) tuple[8]);
            entity.setUf((String) tuple[9]);
            entity.setNivelRelacionamentoEnum(NivelRelacionamentoEnum.retornaEnumNaPosicao((int)tuple[10]));
            entity.setResponsavel((String) tuple[11]);
            entity.setResponsavelContato((String) tuple[12]);
            entity.setSituacaoEnum(SituacaoProjetoEnum.retornaEnumNaPosicao((int)tuple[13]));
            entity.setInep((String) tuple[14]);
            set.add(entity);
        }
        return set;
    }

    @Override
    public void deleteEducadorEscola(long idEducador, long idEscola) {
           Educador educador = super.load(idEducador);

        if (educador != null) {
            StringBuilder sql = new StringBuilder();
            sql.append(" DELETE ");
            sql.append(" FROM educador_escola a ");
            sql.append(" WHERE a.educador_id = :educador_id and a.escola_id = :escola_id ");
            System.out.println(sql.toString());
            SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
            query.setParameter("educador_id", idEducador);
            query.setParameter("escola_id", idEscola);
            query.executeUpdate();
        }
    }
   

}
