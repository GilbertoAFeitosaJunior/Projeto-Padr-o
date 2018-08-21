package mobi.stos.youhub.dao.impl;

import java.util.List;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IIngressoDao;
import mobi.stos.youhub.enumm.SituacaoConvidadoEnum;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class IngressoDao extends AbstractHibernateDao<Ingresso> implements IIngressoDao {

    public IngressoDao() {
        super(Ingresso.class);
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

}
