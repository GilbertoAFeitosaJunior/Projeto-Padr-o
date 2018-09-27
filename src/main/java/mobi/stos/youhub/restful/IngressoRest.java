package mobi.stos.youhub.restful;

import java.util.Date;
import java.util.Objects;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.bo.IConsultorBo;
import mobi.stos.youhub.bo.IConvidadoBo;
import mobi.stos.youhub.bo.IEventoBo;
import mobi.stos.youhub.bo.IIngressoBo;
import mobi.stos.youhub.enumm.SituacaoFechamentoEnum;
import mobi.stos.youhub.enumm.SituacaoPagamentoEnum;
import mobi.stos.youhub.enumm.TipoIngressoEnum;
import mobi.stos.youhub.restful.model.IngressoHelper;
import mobi.stos.youhub.restful.model.PagamentoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gilberto
 */
@Component
@Path("/ingresso")
public class IngressoRest {

    @Autowired
    private IConvidadoBo convidadoBo;

    @Autowired
    private IConsultorBo consultorBo;

    @Autowired
    private IIngressoBo ingressoBo;

    @Autowired
    private IEventoBo eventoBo;

    @POST
    @Path("/pagamento")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response pagamento(PagamentoHelper pagamentoHelper) {
        try {
            Evento evento = this.eventoBo.load(pagamentoHelper.getEvento().getId());
            Convidado convidado = this.convidadoBo.load(pagamentoHelper.getConvidado().getId());

            // a programar. kkkk
//            if (evento != null && convidado != null) {
//                pagamentoHelper.setConvidado(convidado);
//                pagamentoHelper.setEvento(evento);
//
//                return Response.status(Response.Status.OK).entity(pagamentoHelper).build();
//            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/gerar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gerar(IngressoHelper ingressoHelper) {
        try {
            Convidado convidado = this.convidadoBo.load(ingressoHelper.getIdConvidado());
            Evento evento = this.eventoBo.load(ingressoHelper.getIdEvento());
            Consultor consultor = this.consultorBo.load(ingressoHelper.getIdConsultor());

            if (convidado != null && evento != null && consultor != null) {

                if (evento.getSituacaoFechamentoEnum() == SituacaoFechamentoEnum.ABERTO) {
                    Ingresso ingresso = this.ingressoBo.verificarConvidado(convidado.getId(), evento.getId());

                    if (Objects.isNull(ingresso)) {

                        ingresso = new Ingresso();
                        ingresso.setConvidado(convidado);
                        ingresso.setConsultor(consultor);
                        ingresso.setEvento(evento);
                        ingresso.setValor(evento.getValor());
                        ingresso.setDataGeracao(new Date());
                        ingresso.setDataPagamento(new Date());
                        ingresso.setManager(consultor.getManager());
                        ingresso.setSituacaoPagamentoEnum(SituacaoPagamentoEnum.EM_ABERTO);
                        ingresso.setTipoIngressoEnum(TipoIngressoEnum.NORMAL);                       

                        ingresso = this.ingressoBo.persist(ingresso);

                        return Response.status(Response.Status.CREATED).entity(ingresso).build();
                    } else {
                        return Response.status(Response.Status.CONFLICT).build(); // convidado já tem o ingresso.
                    }
                } else {
                    Response.status(Response.Status.FORBIDDEN).build(); // evento fechando.
                }

            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
