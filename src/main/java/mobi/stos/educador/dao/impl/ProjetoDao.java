package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.Projeto;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.IProjetoDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProjetoDao extends AbstractHibernateDao<Projeto> implements IProjetoDao{
    
    public ProjetoDao (){
        super(Projeto.class);
    }
    
}
