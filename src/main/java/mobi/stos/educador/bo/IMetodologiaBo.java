package mobi.stos.educador.bo;
/**
 *
 * @author Rafael Bloise
 */

import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.common.IOperations;


public interface IMetodologiaBo extends IOperations<Metodologia>{

    public void deleteMetodologiaEscola(Long idMetodologia, Long idEscola);
    
    
}
