package mobi.stos.youhub.bo;

import java.util.List;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.enumm.SituacaoConvidadoEnum;

public interface IIngressoBo extends IOperations<Ingresso> {

    List<Ingresso> listConvidados(Long idEvento, SituacaoConvidadoEnum situacao);
    
     List<Ingresso> listFalta(Long idEvento);
     
     List<Ingresso> listPresente(Long idEvento);
}
