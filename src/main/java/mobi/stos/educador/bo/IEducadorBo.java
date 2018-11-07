package mobi.stos.educador.bo;

import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Matheus Monteiro
 */

public interface IEducadorBo extends IOperations<Educador>{
    
    public void deleteEducadorEscola(Long idEducador, Long idEscola);
    
}
