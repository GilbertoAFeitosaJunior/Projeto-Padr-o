package mobi.stos.youhub.bo;

import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.common.IOperations;

public interface IEventoBo extends IOperations<Evento> {

    List<Evento> eventoPorData(Long idManager, Date dataInicio);

}
