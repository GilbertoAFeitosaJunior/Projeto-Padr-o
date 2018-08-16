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

/**
 *
 * @author Weibson
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class Questionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Convidado convidado;

    @Column(nullable = false, length = 100)
    private String sonho1;

    @Column(nullable = false, length = 100)
    private String sonho2;

    @Column(nullable = false, length = 100)
    private String sonho3;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal renda;

    @Column(nullable = false)
    private int filhos;

    @Column(nullable = false)
    private boolean trabalha;

    @Column(length = 100)
    private String cargo;

    @Column(nullable = false)
    private SituacaoFechamentoEnum situacaoFechamentoEnum;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataQuestionario;

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

    public String getSonho1() {
        return sonho1;
    }

    public void setSonho1(String sonho1) {
        this.sonho1 = sonho1;
    }

    public String getSonho2() {
        return sonho2;
    }

    public void setSonho2(String sonho2) {
        this.sonho2 = sonho2;
    }

    public String getSonho3() {
        return sonho3;
    }

    public void setSonho3(String sonho3) {
        this.sonho3 = sonho3;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public int getFilhos() {
        return filhos;
    }

    public void setFilhos(int filhos) {
        this.filhos = filhos;
    }

    public boolean isTrabalha() {
        return trabalha;
    }

    public void setTrabalha(boolean trabalha) {
        this.trabalha = trabalha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public SituacaoFechamentoEnum getSituacaoFechamentoEnum() {
        return situacaoFechamentoEnum;
    }

    public void setSituacaoFechamentoEnum(SituacaoFechamentoEnum situacaoFechamentoEnum) {
        this.situacaoFechamentoEnum = situacaoFechamentoEnum;
    }

    public Date getDataQuestionario() {
        return dataQuestionario;
    }

    public void setDataQuestionario(Date dataQuestionario) {
        this.dataQuestionario = dataQuestionario;
    }

}
