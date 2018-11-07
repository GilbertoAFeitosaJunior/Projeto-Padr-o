package mobi.stos.educador.dao;

import mobi.stos.educador.bean.Educador;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Matheus Monteiro
 */

public interface IEducadorDao extends IOperations<Educador>{
    
    public void deleteEducadorEscola(long idEducador, long idEscola);
    
}
