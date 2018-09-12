package mobi.stos.youhub.dao;

import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.restful.model.QueryConvidado;

public interface IManagerDao extends IOperations<Manager> {

   List<Consultor> consultoresNoEvento(QueryConvidado queryConvidado);
    
}
