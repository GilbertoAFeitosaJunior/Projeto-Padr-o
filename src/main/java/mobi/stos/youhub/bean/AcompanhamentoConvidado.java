package mobi.stos.youhub.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mobi.stos.youhub.enumm.SituacaoAcompanhamentoEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Weibson
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class AcompanhamentoConvidado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Convidado convidado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date inicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;

    private SituacaoAcompanhamentoEnum situacaoAcompanhamentoEnum;

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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public SituacaoAcompanhamentoEnum getSituacaoAcompanhamentoEnum() {
        return situacaoAcompanhamentoEnum;
    }

    public void setSituacaoAcompanhamentoEnum(SituacaoAcompanhamentoEnum situacaoAcompanhamentoEnum) {
        this.situacaoAcompanhamentoEnum = situacaoAcompanhamentoEnum;
    }

}
