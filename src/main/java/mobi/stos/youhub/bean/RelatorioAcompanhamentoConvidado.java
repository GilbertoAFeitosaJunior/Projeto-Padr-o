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
public class RelatorioAcompanhamentoConvidado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AcompanhamentoConvidado acompanhamentoConvidado;

    @Type(type = "text")
    private String observacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataRetorno;

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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

}
