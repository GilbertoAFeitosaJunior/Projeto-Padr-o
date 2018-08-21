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
public class PagamentoCadastro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Convidado convidado;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataGeracao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorCobrado;

    @Column(precision = 10, scale = 2)
    private BigDecimal valoPago;

    private TipoPagamentoEnum tipoPagamentoEnum;

    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(BigDecimal valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public BigDecimal getValoPago() {
        return valoPago;
    }

    public void setValoPago(BigDecimal valoPago) {
        this.valoPago = valoPago;
    }

    public TipoPagamentoEnum getTipoPagamentoEnum() {
        return tipoPagamentoEnum;
    }

    public void setTipoPagamentoEnum(TipoPagamentoEnum tipoPagamentoEnum) {
        this.tipoPagamentoEnum = tipoPagamentoEnum;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
