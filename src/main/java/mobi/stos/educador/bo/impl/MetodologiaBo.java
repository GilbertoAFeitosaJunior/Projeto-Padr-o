package mobi.stos.educador.bo.impl;
/**
 *
 * @author Rafael Bloise
 */
import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.bo.IMetodologiaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IMetodologiaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetodologiaBo extends AbstractService<Metodologia> implements IMetodologiaBo {

    @Autowired
    private IMetodologiaDao dao;

    @Override
    protected IOperations<Metodologia> getDao() {
        return dao;
    }

    @Override
    public void deleteMetodologiaEscola(Long idMetodologia, Long idEscola) {
        dao.deleteMetodologiaEscola(idMetodologia, idEscola);
    }

}
