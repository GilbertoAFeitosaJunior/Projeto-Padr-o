package mobi.stos.educador.dao;

import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.common.IOperations;

/**
 *
 * @author Rafael Bloise
 */
public interface IAtividadeDao extends IOperations<Atividade> {
    
        public void deleteAtividadeMetodologia(long idAtividade, long idMetodologia);

    
}
