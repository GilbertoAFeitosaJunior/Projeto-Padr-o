package mobi.stos.youhub.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.bean.TipoEvento;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IEventoDao;
import org.springframework.stereotype.Repository;

@Repository
public class EventoDao extends AbstractHibernateDao<Evento> implements IEventoDao {

    public EventoDao() {
        super(Evento.class);
    }

    @Override
    public List<Evento> eventoPorData(Long idManager, Date dataInicio) {
        
        return getCurrentSession().doReturningWork((cnctn) -> {
            String sql = new StringBuilder()
                    .append("SELECT DISTINCT evento.id , evento.bairro, evento.complemento, evento.datafim, evento.cidade, "
                            + " evento.datainicio, evento.datalimitecompra, evento.descricao, evento.logradouro, "
                            + " evento.numero, evento.pais, evento.palestrante, evento.pontoreferencia, "
                            + " evento.titulo, evento.uf, evento.valor, evento.diretorsala_id, "
                            + " evento.tipoevento_id, evento.foto  ")
                    .append("FROM ingresso ")
                    .append("INNER JOIN evento on evento.id =  evento_id ")
                    .append("INNER JOIN convidado on convidado.id = convidado_id ")
                    .append("INNER JOIN manager on manager.id =  convidado.manager_id ")
                    .append("WHERE  convidado.manager_id= ? AND DATE(evento.datainicio)= ? ")
                    .append("ORDER BY evento.id")
                    .toString();
            System.out.println(sql);

            PreparedStatement preparedStatement = cnctn.prepareStatement(sql);
            preparedStatement.setLong(1, idManager);
            preparedStatement.setDate(2, new java.sql.Date(dataInicio.getTime()));
            ResultSet rs = preparedStatement.executeQuery();

            List<Evento> eventos = new ArrayList<>();
            Evento evento;
            while (rs.next()) {
                evento = new Evento();
              
                evento.setId(rs.getLong("id"));
                evento.setTipoEvento(new TipoEvento(rs.getLong("tipoevento_id")));
                evento.setTitulo(rs.getString("titulo"));
                evento.setDataInicio(rs.getDate("dataInicio"));
                evento.setDataFim(rs.getDate("dataFim"));
                evento.setValor(rs.getBigDecimal("valor"));
                evento.setDescricao(rs.getString("descricao"));
                evento.setPalestrante(rs.getString("palestrante"));
                evento.setLogradouro(rs.getString("logradouro"));
                evento.setNumero(rs.getString("numero"));
                evento.setComplemento(rs.getString("complemento"));
                evento.setBairro(rs.getString("bairro"));
                evento.setCidade(rs.getString("cidade"));
                evento.setUf(rs.getString("uf"));
                evento.setPais(rs.getString("pais"));
                evento.setPontoReferencia(rs.getString("pontoreferencia"));
                evento.setDataLimiteCompra(rs.getDate("datalimitecompra"));
                evento.setDiretorSala(new DiretorSala(rs.getLong("id")));
                evento.setFoto(rs.getString("foto"));

                eventos.add(evento);
            }
            return eventos;
        });
    }

}
