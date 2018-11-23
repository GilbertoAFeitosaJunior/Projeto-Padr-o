
package mobi.stos.educador.bo;

import java.util.List;
import mobi.stos.educador.bean.Anexo;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Matheus Monteiro
 */
public interface IAnexoBo extends IOperations<Anexo>{
    
    List<Anexo> byOficinaId(Long idOficina);
    
}
