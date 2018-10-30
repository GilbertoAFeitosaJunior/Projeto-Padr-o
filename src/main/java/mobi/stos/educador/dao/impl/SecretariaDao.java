package mobi.stos.educador.dao.impl;

import mobi.stos.educador.bean.Secretaria;
import mobi.stos.educador.common.AbstractHibernateDao;
import mobi.stos.educador.dao.ISecretariaDao;
import org.springframework.stereotype.Repository;

@Repository
public class SecretariaDao extends AbstractHibernateDao<Secretaria> implements ISecretariaDao {
    
    public SecretariaDao (){
        super(Secretaria.class);
    }
    
}
