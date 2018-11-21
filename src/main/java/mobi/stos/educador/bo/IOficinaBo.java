
package mobi.stos.educador.bo;

import java.util.List;
import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Matheus Monteiro
 */
public interface IOficinaBo extends IOperations<Oficina>{
    
    public void deleteOficinaAtividade(long idOficina, long idAtividade);
    
}
