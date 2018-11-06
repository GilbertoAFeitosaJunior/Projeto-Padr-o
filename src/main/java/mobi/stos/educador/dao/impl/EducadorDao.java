
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
        sql.append("a.id, a.projeto_id, a.nome, a.bairro, a.cep, a.cidade, a.complemento, a.logradouro, a.numero,   "
                + "a.uf, a.nivelRelacionamentoEnum, a.responsavel, a.responsavelContato, a.situacaoEnum, a.inep ");
        sql.append("FROM escola a ");
        sql.append("INNER JOIN escola_educador b ON b.escola_id= a.id ");
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
    
//     private Set<Escola> listEscola (long idEducador) {
//        
//        Set<Escola> set = new HashSet<>();
//        
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT ");
//        sql.append("a.id, a.bairro, a.cep, a.cidade, a.complemento, a.inep, ");
//        sql.append("a.logradouro, a.nivelRelacionamentoEnum, a.nome, a.numero, a.responsavel, a.responsavelContato, a.situacaoEnum, a.uf, a.projeto_id ");
//        sql.append("FROM escola a ");
//        sql.append("INNER JOIN escola_educador b ON b.escola_id= a.id ");
//        sql.append("WHERE b.educador_id = :id ");
//        sql.append("ORDER BY id");
//        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
//        
//        query.setParameter("id", idEducador);
//        List result = query.list();
//        
//        for (Object obj : result) {
//            Object[] tuple = (Object[]) obj;
//            Escola entity = new Escola();
//            entity.setId(((BigInteger) tuple[0]).longValue());
//            entity.setBairro((String) tuple[1]);
//            entity.setCep(((String) tuple[2]));
//            entity.setCidade((String) tuple[3]);
//            entity.setComplemento(((String) tuple[4]));
//            entity.setInep((String) tuple[5]);
//            entity.setLogradouro((String) tuple[6]);
//            entity.setNivelRelacionamentoEnum(NivelRelacionamentoEnum.retornaEnumNaPosicao((int)tuple[7]));
//            entity.setNome((String) tuple[8]);
//            entity.setResponsavel((String) tuple[9]);
//            entity.setResponsavelContato((String) tuple[10]);
//            entity.setSituacaoEnum(SituacaoProjetoEnum.retornaEnumNaPosicao((int) tuple [11]));
//            entity.setUf((String) tuple[12]);
//            entity.setProjeto(new Projeto(((BigInteger) tuple[13]).longValue()));
//            set.add(entity);
//        }
//        return set;
//    }
   

}
