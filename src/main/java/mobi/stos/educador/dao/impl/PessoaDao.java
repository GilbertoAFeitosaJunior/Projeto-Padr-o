
package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.Pessoa;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IPessoaDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus Monteiro
 */

@Repository
public class PessoaDao extends AbstractHibernateDao<Pessoa> implements IPessoaDao{

    public PessoaDao() {
        super(Pessoa.class);
    }

}
