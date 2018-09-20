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
import mobi.stos.youhub.enumm.SituacaoFechamentoEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

/**
 *
 * @author Gilberto Feitosa
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoEvento tipoEvento;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataDoEvento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Type(type = "text")
    private String descricao;

    @Column(length = 100)
    private String palestrante;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String numero;

    private String complemento;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 50)
    private String pais;

    @Type(type = "text")
    private String pontoReferencia;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLimiteCompra;

    @ManyToOne
    private DiretorSala diretorSala;

    @Column(length = 100)
    private String foto;

    @Column(nullable = false)
    private SituacaoFechamentoEnum situacaoFechamentoEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataDoEvento() {
        return dataDoEvento;
    }

    public void setDataDoEvento(Date dataDoEvento) {
        this.dataDoEvento = dataDoEvento;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public Date getDataLimiteCompra() {
        return dataLimiteCompra;
    }

    public void setDataLimiteCompra(Date dataLimiteCompra) {
        this.dataLimiteCompra = dataLimiteCompra;
    }

    public DiretorSala getDiretorSala() {
        return diretorSala;
    }

    public void setDiretorSala(DiretorSala diretorSala) {
        this.diretorSala = diretorSala;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public SituacaoFechamentoEnum getSituacaoFechamentoEnum() {
        return situacaoFechamentoEnum;
    }

    public void setSituacaoFechamentoEnum(SituacaoFechamentoEnum situacaoFechamentoEnum) {
        this.situacaoFechamentoEnum = situacaoFechamentoEnum;
    }

}
