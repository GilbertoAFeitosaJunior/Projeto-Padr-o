package mobi.stos.educador.dao.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mobi.stos.educador.bean.Escola;
import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.bean.Projeto;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IMetodologiaDao;
import mobi.stos.educador.enumm.NivelRelacionamentoEnum;
import mobi.stos.educador.enumm.SituacaoProjetoEnum;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

@Repository
public class MetodologiaDao extends AbstractHibernateDao<Metodologia> implements IMetodologiaDao {

    public MetodologiaDao() {
        super(Metodologia.class);
    }

    @Override
    public Metodologia load(Long id) {
        Metodologia metodologia = super.load(id);
        if (metodologia != null) {
            metodologia.setEscolas(this.listEscola(id));
        }
        return metodologia;
    }

    private Set<Escola> listEscola(long idMetodologia) {

        Set<Escola> set = new HashSet<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("a.id, a.projeto_id, a.nome, a.bairro, a.cep, a.cidade, a.complemento, a.logradouro, a.numero,   "
                + "a.uf, a.nivelRelacionamentoEnum, a.responsavel, a.responsavelContato, a.situacaoEnum, a.inep ");
        sql.append("FROM escola a ");
        sql.append("INNER JOIN metodologia_escola b ON b.escola_id = a.id ");
        sql.append("WHERE b.metodologia_id = :id ");
        sql.append("ORDER BY id");
        SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());

        query.setParameter("id", idMetodologia);
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
            entity.setNivelRelacionamentoEnum((NivelRelacionamentoEnum) tuple[10]);
            entity.setResponsavel((String) tuple[11]);
            entity.setResponsavelContato((String) tuple[12]);
            entity.setSituacaoEnum((SituacaoProjetoEnum) tuple[13]);
            entity.setInep((String) tuple[14]);
            set.add(entity);
        }

        return set;
    }

    @Override
    public void deleteMetodologiaEscola(long idMetodologia, long idEscola) {

        Metodologia metodologia = super.load(idMetodologia);

        if (metodologia != null) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE");
            sql.append("FROM metodologia_escola a ");
            sql.append("WHERE a.metodologia_id = :metodologia_id and a.escola_id = :escola_id");

            SQLQuery query = getCurrentSession().createSQLQuery(sql.toString());
            query.setParameter("metodologia_id", idMetodologia);
            query.setParameter("escola_id", idEscola);
            query.executeUpdate();
        }
    }

}
