package mobi.stos.youhub.restful.model;

import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.bean.Ingresso;
import mobi.stos.youhub.enumm.TipoPagamentoEnum;

/**
 *
 * @author feito
 */
public class PagamentoHelper {

    /*
    1 - numeroCartao
2 - codidoSegura
3 - dateVencimentoCarto - Formato: 00/0000
4 - nomeTitularCartao
5 - cpf - Obs.: Dono do cartão 
6 - valorCompra
7 - convidado
8 - evento

     */
    private Long idEvento;
    private Long idConvidado;
    private Long idIngresso;
    private long numeroCartao;
    private long codidoSegura;
    private String dateVencimentoCartao;
    private String nomeTitularCartao;
    private long cpf; // dono do cartão
    private double valorCompra;
    private TipoPagamentoEnum tipoPagamentoEnum;

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdConvidado() {
        return idConvidado;
    }

    public void setIdConvidado(Long idConvidado) {
        this.idConvidado = idConvidado;
    }

    public Long getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(Long idIngresso) {
        this.idIngresso = idIngresso;
    }

    public long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public long getCodidoSegura() {
        return codidoSegura;
    }

    public void setCodidoSegura(long codidoSegura) {
        this.codidoSegura = codidoSegura;
    }

    public String getDateVencimentoCartao() {
        return dateVencimentoCartao;
    }

    public void setDateVencimentoCartao(String dateVencimentoCartao) {
        this.dateVencimentoCartao = dateVencimentoCartao;
    }

    public String getNomeTitularCartao() {
        return nomeTitularCartao;
    }

    public void setNomeTitularCartao(String nomeTitularCartao) {
        this.nomeTitularCartao = nomeTitularCartao;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public TipoPagamentoEnum getTipoPagamentoEnum() {
        return tipoPagamentoEnum;
    }

    public void setTipoPagamentoEnum(TipoPagamentoEnum tipoPagamentoEnum) {
        this.tipoPagamentoEnum = tipoPagamentoEnum;
    }

}
