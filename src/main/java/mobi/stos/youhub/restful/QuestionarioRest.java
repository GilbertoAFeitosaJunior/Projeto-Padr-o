package mobi.stos.youhub.restful;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.stos.youhub.bean.Historico;
import mobi.stos.youhub.bean.Questionario;
import mobi.stos.youhub.bo.IEventoBo;
import mobi.stos.youhub.bo.IHistoricoBo;
import mobi.stos.youhub.bo.IQuestionarioBo;
import mobi.stos.youhub.enumm.SituacaoFechamentoEnum;
import mobi.stos.youhub.restful.model.Query;
import mobi.stos.youhub.restful.model.QuestionarioHelper;
import mobi.stos.youhub.util.consulta.Consulta;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Weibson
 */
@Component
@Path("/questionario")
public class QuestionarioRest {

    private List<Questionario> questionarios;

    private List<Historico> historicos;

    @Autowired
    IQuestionarioBo questionarioBo;

    @Autowired
    IHistoricoBo historicoBo;

    @Autowired
    IEventoBo eventoBo;

    @Path("/cancelar/{idQuestionario}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelar(@PathParam("idQuestionario") Long idQuestionario) {
        try {

            Questionario questionario = this.questionarioBo.load(idQuestionario);

            if (questionario != null) {
                questionario.setSituacaoFechamentoEnum(SituacaoFechamentoEnum.CANCELADO);
            }

            return Response.status(Response.Status.OK).entity(historicos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/fechar/{idQuestionario}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fechar(@PathParam("idQuestionario") Long idQuestionario) {
        try {

            Questionario questionario = this.questionarioBo.load(idQuestionario);

            if (questionario != null) {
                questionario.setSituacaoFechamentoEnum(SituacaoFechamentoEnum.FECHADO);
            }

            return Response.status(Response.Status.OK).entity(historicos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/agendamento/historico/{idQuestionario}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agendamento(@PathParam("idQuestionario") Long idQuestionario) {
        try {

            this.historicos = this.historicoBo.historicoAgendamento(idQuestionario);

            return Response.status(Response.Status.OK).entity(historicos).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/reagendar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agendar(QuestionarioHelper questionarioHelper) {
        try {

            Questionario questionario = this.questionarioBo.load(questionarioHelper.getIdQuestionario());
            if (questionario != null) {
                Historico historico = new Historico();
                historico.setDataAcompanhamentoAgendado(questionarioHelper.getData());
                historico.setDataContato(new Date());
                
                questionario.setSituacaoFechamentoEnum(SituacaoFechamentoEnum.ANDAMENTO);
               
                historico.setQuestionario(questionario);
                historico.setTexto(questionarioHelper.getMenssagem());

                questionario.setAcompanhamentoAgendado(questionarioHelper.getData());

                this.historicoBo.persist(historico);
                this.questionarioBo.persist(questionario);
                return Response.status(Response.Status.OK).build();
            }

            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/agendamento")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agendamento(QuestionarioHelper questionarioHelper) {
        try {
            this.questionarios = this.questionarioBo.agendamentoQuestionario(questionarioHelper.getIdManager(), questionarioHelper.getData());

            questionarios.forEach(u -> {
                u.getConvidado().setManager(null);

            });

            return Response.status(Response.Status.OK).entity(questionarios).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/salvar")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Questionario questionario) {
        try {
            if (questionario != null) {
                questionario.setSituacaoFechamentoEnum(SituacaoFechamentoEnum.ABERTO);
                this.questionarioBo.persist(questionario);
                return Response.status(Response.Status.CREATED).build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/deletar/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(@PathParam("id") Long id) {
        try {
            if (id != null) {
                this.questionarioBo.delete(id);
                return Response.status(Response.Status.OK).build();
            }
            return Response.status(Response.Status.FORBIDDEN).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/listar")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        try {
            this.questionarios = this.questionarioBo.listall(new String[]{"dataQuestionario DESC"});
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/listar/aberto")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response aberto(Query query) {
        try {
            Consulta consulta = new Consulta();
            consulta.addAliasTable("convidado", "convidado", JoinType.INNER_JOIN);
            consulta.setCampo("convidado.nome");
            consulta.setValor(query.getQuery());
            consulta.addCriterion(Restrictions.eq("situacaoFechamentoEnum", SituacaoFechamentoEnum.ABERTO));
            consulta.setLimiteResultados(10);
            consulta.setPaginaAtual(query.getPage());
            consulta.addOrder(Order.asc("dataQuestionario"));
            this.questionarios = this.questionarioBo.list(consulta);
            return Response.status(Response.Status.OK).entity(this.questionarios).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/listar/fechado")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fechado(Query query) {
        try {
            Consulta consulta = new Consulta();
            consulta.addAliasTable("convidado", "convidado", JoinType.INNER_JOIN);
            consulta.setCampo("convidado.nome");
            consulta.setValor(query.getQuery());
            consulta.addCriterion(Restrictions.eq("situacaoFechamentoEnum", SituacaoFechamentoEnum.FECHADO));
            consulta.setLimiteResultados(10);
            consulta.setPaginaAtual(query.getPage());
            consulta.addOrder(Order.asc("dataQuestionario"));
            this.questionarios = this.questionarioBo.list(consulta);
            return Response.status(Response.Status.OK).entity(this.questionarios).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/listar/cancelado")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cancelado(Query query) {
        try {
            Consulta consulta = new Consulta();
            consulta.addAliasTable("convidado", "convidado", JoinType.INNER_JOIN);
            consulta.setCampo("convidado.nome");
            consulta.setValor(query.getQuery());
            consulta.addCriterion(Restrictions.eq("situacaoFechamentoEnum", SituacaoFechamentoEnum.CANCELADO));
            consulta.setLimiteResultados(10);
            consulta.setPaginaAtual(query.getPage());
            consulta.addOrder(Order.asc("dataQuestionario"));
            this.questionarios = this.questionarioBo.list(consulta);
            return Response.status(Response.Status.OK).entity(this.questionarios).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @Path("/carregar/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response carregar(@PathParam("id") Long id) {
        try {
            if (id != null) {
                Questionario entiy = this.questionarioBo.load(id);
                return Response.status(Response.Status.OK).entity(entiy).build();
            }
            return Response.status(Response.Status.FORBIDDEN).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
