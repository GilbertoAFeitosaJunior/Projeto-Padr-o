

package mobi.stos.educador.bo.impl;

import java.util.List;
import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.bo.IOficinaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IOficinaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 * 
 */

@Service
public class OficinaBo extends AbstractService<Oficina> implements IOficinaBo{

    @Autowired
    private IOficinaDao dao;
    
    @Override
    protected IOperations<Oficina> getDao() {
        return dao;
    }

    @Override
    public void deleteOficinaAtividade(long idOficina, long idAtividade) {
        dao.deleteOficinaAtividade(idOficina, idAtividade);
    }

}
