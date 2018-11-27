

package mobi.stos.educador.bo.impl;

import java.util.List;
import mobi.stos.educador.bean.Turma;
import mobi.stos.educador.bo.ITurmaBo;
import mobi.stos.educador.common.AbstractService;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.dao.ITurmaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Matheus Monteiro
 */

@Service
public class TurmaBo extends AbstractService<Turma> implements ITurmaBo{

    @Autowired
    private ITurmaDao dao;
    
    @Override
    protected IOperations<Turma> getDao() {
        return dao;
    }

    @Override
    public List<Turma> byEscolaId(Long idEscola) {
        return dao.byEscolaId(idEscola);
    }

}
