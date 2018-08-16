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
import mobi.stos.youhub.enumm.SituacaoConvidadoEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

/**
 *
 * @author Weibson
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class FormaObterCredito implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AcompanhamentoConvidado acompanhamentoConvidado;

    @Type(type = "text")
    @Column(nullable = false)
    private String descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLimite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AcompanhamentoConvidado getAcompanhamentoConvidado() {
        return acompanhamentoConvidado;
    }

    public void setAcompanhamentoConvidado(AcompanhamentoConvidado acompanhamentoConvidado) {
        this.acompanhamentoConvidado = acompanhamentoConvidado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

}
