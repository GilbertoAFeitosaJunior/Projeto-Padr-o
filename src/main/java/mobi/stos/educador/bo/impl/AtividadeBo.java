package mobi.stos.educador.bo.impl;

import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.bo.IAtividadeBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.IAtividadeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rafael Bloise
 */
@Service
public class AtividadeBo extends AbstractService<Atividade> implements IAtividadeBo{
    
    @Autowired
    private IAtividadeDao dao;
    
      @Override
    protected IOperations<Atividade> getDao() {
        return dao;
    }

    @Override
    public void deleteAtividadeMetodologia(Long idAtividade, Long idMetodologia) {
        dao.deleteAtividadeMetodologia(idAtividade, idMetodologia);
    }

   
    
    
    
    
    
}
