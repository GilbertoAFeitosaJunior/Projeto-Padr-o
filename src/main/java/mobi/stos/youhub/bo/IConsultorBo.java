package mobi.stos.youhub.bo;

import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.common.IOperations;

public interface IConsultorBo extends IOperations<Consultor> {

    List<Consultor> listByConsultor(long idManager);
}
