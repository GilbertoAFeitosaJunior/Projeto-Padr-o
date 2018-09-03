package mobi.stos.youhub.dao;

import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.common.IOperations;

public interface IConsultorDao extends IOperations<Consultor> {

    List<Consultor> listByConsultor(long idManager);

}
