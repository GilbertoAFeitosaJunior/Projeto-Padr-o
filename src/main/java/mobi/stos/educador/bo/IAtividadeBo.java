package mobi.stos.educador.bo;

import mobi.stos.educador.bean.Atividade;
import mobi.stos.educador.common.IOperations;

/**
 * @author Rafael Bloise
 */

public interface IAtividadeBo extends IOperations<Atividade> {
    
        public void deleteAtividadeMetodologia(Long idAtividade ,Long idMetodologia);

    
}
