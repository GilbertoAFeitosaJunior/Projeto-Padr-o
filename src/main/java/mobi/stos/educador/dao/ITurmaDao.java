
package mobi.stos.educador.dao;

import java.util.List;
import mobi.stos.educador.bean.Turma;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Matheus Monteiro
 */
public interface ITurmaDao extends IOperations<Turma>{
    
    public List<Turma> byEscolaId(Long idEscola);
    
}
