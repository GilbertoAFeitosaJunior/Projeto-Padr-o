package mobi.stos.educador.dao;

import mobi.stos.educador.bean.Metodologia;
import mobi.stos.educador.common.IOperations;


public interface IMetodologiaDao extends IOperations<Metodologia>{
    
        public void deleteMetodologiaEscola(long idMetodologia, long idEscola);
    
}
