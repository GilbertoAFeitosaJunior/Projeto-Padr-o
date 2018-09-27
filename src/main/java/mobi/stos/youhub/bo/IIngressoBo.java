package mobi.stos.youhub.bo;

import java.util.Date;
import java.util.List;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.enumm.SituacaoConvidadoEnum;
import mobi.stos.youhub.restful.model.QueryConvidado;

public interface IIngressoBo extends IOperations<Ingresso> {

    List<Ingresso> listConvidados(Long idEvento, SituacaoConvidadoEnum situacao);

    List<Ingresso> listFalta(Long idEvento);

    List<Ingresso> listPresente(Long idEvento);

    Long totalConsultorNoEvento(Long idEvento, Long idManager);

    Long totalConvidadoNoEvento(Long idEvento);

    Long totalConvidadoPorConsultor(Long idEvento, Long idConsultor);

    List<Ingresso> convidadoPorConsultoEvento(Long idEvento, Long idConsultor);

    List<Consultor> consultoresNoEvento(QueryConvidado queryConvidado);

    List<Ingresso> listIngressoPorConsultor(Long idConsultor, Date dataInicio);

    Ingresso verificarConvidado(Long idConvidado, Long idEvento);

    List<Ingresso> listarConvidadosPorEventoManager(Long idManager, Date date);

}
