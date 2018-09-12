package mobi.stos.youhub.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IManagerDao;
import mobi.stos.youhub.restful.model.QueryConvidado;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDao extends AbstractHibernateDao<Manager> implements IManagerDao {

    public ManagerDao() {
        super(Manager.class);
    }

    @Override
    public List<Consultor> consultoresNoEvento(QueryConvidado queryConvidado) {

        return getCurrentSession().doReturningWork((Connection cnctn) -> {
            String sql = new StringBuilder()
                    .append("SELECT consultor.id, consultor.foto, consultor.nome  FROM ingresso  ")
                    .append("INNER JOIN consultor ON consultor.id = consultor_id ")
                    .append("WHERE evento_id = ? AND consultor.manager_id = ? ")
                    .append("AND consultor.nome  ILIKE ? ")
                    .append("GROUP BY consultor.id ")
                    .append("ORDER BY consultor.nome ")
                    .append("LIMIT 10 OFFSET ((? - 1)*10)")
                    .toString();

            PreparedStatement preparedStatement = cnctn.prepareStatement(sql);
            preparedStatement.setLong(1, queryConvidado.getIdEvento());
            preparedStatement.setLong(2, queryConvidado.getIdManager());
            preparedStatement.setString(3, "%" + queryConvidado.getQuery() + "%");
            preparedStatement.setInt(4, queryConvidado.getPage());
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

}
