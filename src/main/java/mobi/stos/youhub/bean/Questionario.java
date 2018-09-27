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
import mobi.stos.youhub.enumm.AtividadeAtualEnum;
import mobi.stos.youhub.enumm.RendaMediaEnum;
import mobi.stos.youhub.enumm.SexoEnum;
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

    private int idade;

    private SexoEnum sexoEnum;

    private AtividadeAtualEnum atividadeAtualEnum;

    private String cargaHoraria;

    private RendaMediaEnum rendaMediaEnum;

    private boolean possuiRendaResidual;

    private boolean temPlanoSaude;

    private boolean temFilhos;

    private int qtdFilhos;

    private boolean escolaParticular;

    @Column(length = 100)
    private String sonho1;

    @Column(length = 100)
    private String sonho2;

    @Column(length = 100)
    private String sonho3;

    @Column(length = 100)
    private String objecao1;

    @Column(length = 100)
    private String objecao2;

    @Column(length = 100)
    private String objecao3;

    @Column(length = 100)
    private String opcaoInvestimento1;

    @Column(length = 100)
    private String opcaoInvestimento2;

    @Column(length = 100)
    private String opcaoInvestimento3;

    @Temporal(TemporalType.TIMESTAMP)
    private Date acompanhamentoAgendado;// progamar push...

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataQuestionario;

  
    private SituacaoFechamentoEnum situacaoFechamentoEnum;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public SexoEnum getSexoEnum() {
        return sexoEnum;
    }

    public void setSexoEnum(SexoEnum sexoEnum) {
        this.sexoEnum = sexoEnum;
    }

    public AtividadeAtualEnum getAtividadeAtualEnum() {
        return atividadeAtualEnum;
    }

    public void setAtividadeAtualEnum(AtividadeAtualEnum atividadeAtualEnum) {
        this.atividadeAtualEnum = atividadeAtualEnum;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public RendaMediaEnum getRendaMediaEnum() {
        return rendaMediaEnum;
    }

    public void setRendaMediaEnum(RendaMediaEnum rendaMediaEnum) {
        this.rendaMediaEnum = rendaMediaEnum;
    }

    public boolean isPossuiRendaResidual() {
        return possuiRendaResidual;
    }

    public void setPossuiRendaResidual(boolean possuiRendaResidual) {
        this.possuiRendaResidual = possuiRendaResidual;
    }

    public boolean isTemPlanoSaude() {
        return temPlanoSaude;
    }

    public void setTemPlanoSaude(boolean temPlanoSaude) {
        this.temPlanoSaude = temPlanoSaude;
    }

    public boolean isTemFilhos() {
        return temFilhos;
    }

    public void setTemFilhos(boolean temFilhos) {
        this.temFilhos = temFilhos;
    }

    public int getQtdFilhos() {
        return qtdFilhos;
    }

    public void setQtdFilhos(int qtdFilhos) {
        this.qtdFilhos = qtdFilhos;
    }

    public boolean isEscolaParticular() {
        return escolaParticular;
    }

    public void setEscolaParticular(boolean escolaParticular) {
        this.escolaParticular = escolaParticular;
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

    public String getObjecao1() {
        return objecao1;
    }

    public void setObjecao1(String objecao1) {
        this.objecao1 = objecao1;
    }

    public String getObjecao2() {
        return objecao2;
    }

    public void setObjecao2(String objecao2) {
        this.objecao2 = objecao2;
    }

    public String getObjecao3() {
        return objecao3;
    }

    public void setObjecao3(String objecao3) {
        this.objecao3 = objecao3;
    }

    public String getOpcaoInvestimento1() {
        return opcaoInvestimento1;
    }

    public void setOpcaoInvestimento1(String opcaoInvestimento1) {
        this.opcaoInvestimento1 = opcaoInvestimento1;
    }

    public String getOpcaoInvestimento2() {
        return opcaoInvestimento2;
    }

    public void setOpcaoInvestimento2(String opcaoInvestimento2) {
        this.opcaoInvestimento2 = opcaoInvestimento2;
    }

    public String getOpcaoInvestimento3() {
        return opcaoInvestimento3;
    }

    public void setOpcaoInvestimento3(String opcaoInvestimento3) {
        this.opcaoInvestimento3 = opcaoInvestimento3;
    }

    public Date getAcompanhamentoAgendado() {
        return acompanhamentoAgendado;
    }

    public void setAcompanhamentoAgendado(Date acompanhamentoAgendado) {
        this.acompanhamentoAgendado = acompanhamentoAgendado;
    }

    public Date getDataQuestionario() {
        return dataQuestionario;
    }

    public void setDataQuestionario(Date dataQuestionario) {
        this.dataQuestionario = dataQuestionario;
    }

    public SituacaoFechamentoEnum getSituacaoFechamentoEnum() {
        return situacaoFechamentoEnum;
    }

    public void setSituacaoFechamentoEnum(SituacaoFechamentoEnum situacaoFechamentoEnum) {
        this.situacaoFechamentoEnum = situacaoFechamentoEnum;
    }

}
