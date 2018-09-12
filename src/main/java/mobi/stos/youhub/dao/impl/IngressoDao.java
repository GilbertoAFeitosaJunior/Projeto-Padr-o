package mobi.stos.youhub.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IIngressoDao;
import mobi.stos.youhub.enumm.SituacaoConvidadoEnum;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.sql.JoinType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;
import org.hibernate.type.Type;

@Repository
public class IngressoDao extends AbstractHibernateDao<Ingresso> implements IIngressoDao {

    public IngressoDao() {
        super(Ingresso.class);
    }

    @Override
    public List<Ingresso> listFalta(Long idEvento) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("evento", "evento");
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.add(Restrictions.isNull("codigo"));
        criteria.addOrder(Order.desc("dataGeracao"));
        return criteria.list();
    }

    @Override
    public List<Ingresso> listPresente(Long idEvento) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("evento", "evento");
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.add(Restrictions.isNotNull("codigo"));
        criteria.addOrder(Order.desc("dataGeracao"));
        return criteria.list();
    }

    public List<Consultor> consultoresNoEvento(final Long idEvento, Long idManager, int page) {

        return getCurrentSession().doReturningWork(new ReturningWork<List<Consultor>>() {
            @Override
            public List<Consultor> execute(Connection cnctn) throws SQLException {
                String sql = new StringBuilder()
                        .append("SELECT consultor.id, consultor.foto, consultor.nome  FROM ingresso  ")
                        .append("INNER JOIN consultor ON consultor.id = consultor_id")
                        .append("WHERE evento_id = ? AND consultor.manager_id = ?")
                        .append("GROUP BY consultor.id")
                        .append("ORDER BY consultor.nome")
                        .append("LIMIT 10 OFFSET ((? - 1)*10)")
                        .toString();

                PreparedStatement preparedStatement = cnctn.prepareStatement(sql);
                preparedStatement.setLong(1, idEvento);
                preparedStatement.setLong(2, idManager);
                preparedStatement.setInt(3, page);
                ResultSet rs = preparedStatement.executeQuery();

                List<Consultor> consultors = new ArrayList<>();
                Consultor consultor;
                while (rs.next()) {
                    consultor = new Consultor();

                    consultor.setId(rs.getLong("id"));
                    consultor.setFoto(rs.getString("foto"));
                    consultor.setNome("nome");

                    consultors.add(consultor);
                }

                return consultors;
            }
        });
    }

    @Override
    public Long totalConsultorNoEvento(Long idEvento, Long idManager) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.setProjection(
                Projections.sqlProjection(
                        "COUNT(DISTINCT consultor2_.id) AS t",
                        new String[]{"t"},
                        new Type[]{LongType.INSTANCE}
                )
        );
        criteria.createAlias("evento", "evento", JoinType.INNER_JOIN);
        criteria.createAlias("consultor", "consultor", JoinType.INNER_JOIN);
        criteria.createAlias("consultor.manager", "manager", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.add(Restrictions.eq("manager.id", idManager));
        return (Long) criteria.uniqueResult();
    }

    @Override
    public Long totalConvidadoNoEvento(Long idEvento) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.setProjection(Projections.count("id"));
        criteria.createAlias("evento", "evento", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("evento.id", idEvento));
        return (Long) criteria.uniqueResult();
    }
    
    public List<Ingresso> convidadoPorConsultoEvento(Long idEvento, Long idConsultor) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("evento", "evento", JoinType.INNER_JOIN);
        criteria.createAlias("consultor", "consultor", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.add(Restrictions.eq("consultor.id", idConsultor));
        return criteria.list();
    }

    @Override
    public Long totalConvidadoPorConsultor(Long idEvento, Long idConsultor) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.setProjection(Projections.count("id"));
        criteria.createAlias("evento", "evento", JoinType.INNER_JOIN);
        criteria.createAlias("consultor", "consultor", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.add(Restrictions.eq("consultor.id", idConsultor));
        return (Long) criteria.uniqueResult();
    }

    @Override
    public List<Ingresso> listConvidados(Long idEvento, SituacaoConvidadoEnum situacao) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("evento", "evento");
        criteria.createAlias("convidado", "convidado");
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.add(Restrictions.eq("convidado.situacao", situacao));
        criteria.addOrder(Order.desc("dataGeracao"));
        return criteria.list();
    }
}
