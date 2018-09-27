package mobi.stos.youhub.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IIngressoDao;
import mobi.stos.youhub.enumm.SituacaoConvidadoEnum;
import mobi.stos.youhub.restful.model.QueryConvidado;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.type.DateType;
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
        criteria.setProjection(Projections.count("convidado.id"));
        criteria.createAlias("evento", "evento", JoinType.INNER_JOIN);
        criteria.createAlias("convidado", "convidado", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("evento.id", idEvento));
        return (Long) criteria.uniqueResult();
    }

    @Override
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

    @Override
    public List<Consultor> consultoresNoEvento(QueryConvidado queryConvidado) {
        return getCurrentSession().doReturningWork((Connection cnctn) -> {
            String sql = new StringBuilder()
                    .append("SELECT consultor.id, consultor.foto, consultor.nome  FROM ingresso  ")
                    .append("INNER JOIN consultor ON consultor.id = consultor_id ")
                    .append("WHERE evento_id = ? AND ingresso.manager_id = ? ")
                    .append("AND consultor.nome  ILIKE ? ")
                    .append("AND dataentradaevento IS NOT NULL ")
                    .append("ORDER BY consultor.nome ")
                    .append("LIMIT 10 OFFSET ?")
                    .toString();

            PreparedStatement preparedStatement = cnctn.prepareStatement(sql);
            preparedStatement.setLong(1, queryConvidado.getIdEvento());
            preparedStatement.setLong(2, queryConvidado.getIdManager());
            preparedStatement.setString(3, "%" + queryConvidado.getQuery() + "%");
            preparedStatement.setInt(4, (queryConvidado.getPage() - 1) * 10);
            ResultSet rs = preparedStatement.executeQuery();

            List<Consultor> consultors = new ArrayList<>();
            Consultor consultor;

            while (rs.next()) {
                consultor = new Consultor();
                consultor.setId(rs.getLong("id"));
                consultor.setFoto(rs.getString("foto"));
                consultor.setNome(rs.getString("nome"));
                consultors.add(consultor);
            }
            return consultors;
        });
    }

    @Override
    public List<Ingresso> listIngressoPorConsultor(Long idConsultor, Date dataInicio) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("evento", "evento", JoinType.INNER_JOIN);
        criteria.createAlias("consultor", "consultor", JoinType.INNER_JOIN);
        criteria.add(Restrictions.eq("consultor.id", idConsultor));
        criteria.add(Restrictions.sqlRestriction("DATE(evento1_.datadoevento) = ?", new Object[]{
            dataInicio
        }, new DateType[]{
            DateType.INSTANCE
        }));
        return criteria.list();
    }

    @Override
    public Ingresso verificarConvidado(Long idConvidado, Long idEvento) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("convidado", "convidado");
        criteria.createAlias("evento", "evento");
        criteria.add(Restrictions.eq("convidado.id", idConvidado));
        criteria.add(Restrictions.eq("evento.id", idEvento));
        criteria.setMaxResults(1);
        return (Ingresso) criteria.uniqueResult();

    }

    @Override
    public List<Ingresso> listarConvidadosPorEventoManager(Long idManager, Date date) {
        Criteria criteria = getCurrentSession().createCriteria(Ingresso.class);
        criteria.createAlias("manager", "manager");
        criteria.createAlias("evento", "evento");
        criteria.add(Restrictions.eq("manager.id", idManager));
        criteria.add(Restrictions.sqlRestriction("DATE(evento2_.datadoevento) = ?", new Object[]{
            date
        }, new DateType[]{
            DateType.INSTANCE
        }));
        return criteria.list();

    }

}
