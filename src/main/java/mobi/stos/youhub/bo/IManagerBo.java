package mobi.stos.youhub.bo;

import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.restful.model.QueryConvidado;

public interface IManagerBo extends IOperations<Manager> {
    
   List<Consultor> consultoresNoEvento(QueryConvidado queryConvidado);

}
