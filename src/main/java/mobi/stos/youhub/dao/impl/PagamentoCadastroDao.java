package mobi.stos.youhub.dao.impl;

import mobi.stos.youhub.bean.PagamentoCadastro;
import mobi.stos.youhub.common.AbstractHibernateDao;
import mobi.stos.youhub.dao.IPagamentoCadastroDao;
import org.springframework.stereotype.Repository;

@Repository
public class PagamentoCadastroDao extends AbstractHibernateDao<PagamentoCadastro> implements IPagamentoCadastroDao {

    public PagamentoCadastroDao() {
        super(PagamentoCadastro.class);
    }

}
