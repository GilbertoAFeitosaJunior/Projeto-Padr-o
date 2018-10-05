package mobi.stos.bepro.dao;

import mobi.stos.bepro.bean.Consultor;
import mobi.stos.bepro.common.IOperations;

public interface IConsultorDao extends IOperations<Consultor> {

    Consultor byHash(String hash);

    Consultor byFirebase(String firebase);

}
