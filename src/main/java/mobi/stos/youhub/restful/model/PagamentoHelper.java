package mobi.stos.youhub.restful.model;

import java.util.Date;
import mobi.stos.youhub.bean.Convidado;
import mobi.stos.youhub.bean.Evento;

/**
 *
 * @author feito
 */
public class PagamentoHelper {

    private Evento evento;
    private Convidado convidado;
    private long numeroCartao;
    private long codidoSegura;
    private Date dateVencimentoCarto;
    private String nomeTitularCartao;
    private long cpf;
    private double valorCompra;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Convidado getConvidado() {
        return convidado;
    }

    public void setConvidado(Convidado convidado) {
        this.convidado = convidado;
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

    public Date getDateVencimentoCarto() {
        return dateVencimentoCarto;
    }

    public void setDateVencimentoCarto(Date dateVencimentoCarto) {
        this.dateVencimentoCarto = dateVencimentoCarto;
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

}
