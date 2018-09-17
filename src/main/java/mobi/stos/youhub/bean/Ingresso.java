package mobi.stos.youhub.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mobi.stos.youhub.enumm.SituacaoPagamentoEnum;
import mobi.stos.youhub.enumm.TipoIngressoEnum;
import mobi.stos.youhub.enumm.TipoPagamentoEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Weibson
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class Ingresso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Manager manager;

    @ManyToOne
    private Consultor consultor;

    @ManyToOne
    private Convidado convidado;

    @Column(nullable = false, length = 10)
    private String codigo;

    private TipoIngressoEnum tipoIngressoEnum;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    private SituacaoPagamentoEnum situacaoPagamentoEnum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataGeracao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPagamento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntradaEvento;

    private TipoPagamentoEnum tipoPagamentoEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoIngressoEnum getTipoIngressoEnum() {
        return tipoIngressoEnum;
    }

    public void setTipoIngressoEnum(TipoIngressoEnum tipoIngressoEnum) {
        this.tipoIngressoEnum = tipoIngressoEnum;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public SituacaoPagamentoEnum getSituacaoPagamentoEnum() {
        return situacaoPagamentoEnum;
    }

    public void setSituacaoPagamentoEnum(SituacaoPagamentoEnum situacaoPagamentoEnum) {
        this.situacaoPagamentoEnum = situacaoPagamentoEnum;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataEntradaEvento() {
        return dataEntradaEvento;
    }

    public void setDataEntradaEvento(Date dataEntradaEvento) {
        this.dataEntradaEvento = dataEntradaEvento;
    }

    public TipoPagamentoEnum getTipoPagamentoEnum() {
        return tipoPagamentoEnum;
    }

    public void setTipoPagamentoEnum(TipoPagamentoEnum tipoPagamentoEnum) {
        this.tipoPagamentoEnum = tipoPagamentoEnum;
    }

}
