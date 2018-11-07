
package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.bo.IEducadorBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IEducadorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 */

@Service
public class EducadorBo extends AbstractService<Educador> implements IEducadorBo {

    @Autowired
    private IEducadorDao dao;
    
    @Override
    protected IOperations<Educador> getDao() {
        return dao;
    }

    @Override
    public void deleteEducadorEscola(Long idEducador, Long idEscola) {
        dao.deleteEducadorEscola(idEducador, idEscola);
    }

}
