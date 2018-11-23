

package mobi.stos.educador.bo.impl;

import java.util.List;
import mobi.stos.educador.bean.Anexo;
import mobi.stos.educador.bo.IAnexoBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IAnexoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 */

@Service
public class AnexoBo extends AbstractService<Anexo> implements IAnexoBo{

    @Autowired
    private IAnexoDao dao;
    
    @Override
    protected IOperations<Anexo> getDao() {
        return dao;
    }

    @Override
    public List<Anexo> byOficinaId(Long idOficina) {
        return dao.byOficinaId(idOficina);
    }

}
