
package mobi.stos.educador.dao;

import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Matheus Monteiro 
 */
public interface IOficinaDao extends IOperations<Oficina>{
    
    public void deleteOficinaAtividade(long idOficina, long idAtividade);
}
