package mobi.stos.bepro.bo;

import mobi.stos.bepro.bean.Consultor;
import mobi.stos.bepro.common.IOperations;

public interface IConsultorBo extends IOperations<Consultor> {

    Consultor byHash(String hash);

    Consultor byFirebase(String firebase);
}
