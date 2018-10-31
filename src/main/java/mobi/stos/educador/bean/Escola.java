package mobi.stos.educador.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import mobi.stos.educador.enumm.NivelRelacionamentoEnum;
import mobi.stos.educador.enumm.SituacaoProjetoEnum;
import mobi.stos.educador.util.Util;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

/**
 *
 * @author Matheus Monteiro
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class Escola implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Projeto projeto;

    @Column(length = 100, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private int cep;

    @Column(length = 100, nullable = false)
    private String logradouro;

    @Column(length = 10, nullable = false)
    private String numero;

    @Column(length = 100)
    private String complemento;

    @Column(length = 50, nullable = false)
    private String bairro;

    @Column(length = 50, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(nullable = false)
    private NivelRelacionamentoEnum nivelRelacionamentoEnum;

    @Column(length = 100)
    private String responsavel;

    @Type(type = "text")
    private String responsavelContato;

    @Column(nullable = false)
    private SituacaoProjetoEnum situacaoEnum;

    @Column(length = 50)
    private String inep;
    
    public String getCepStringMask() {
        return Util.format("#####-###", Util.zeroFill(this.cep, 8));
    }
    public void setCepStringMask(String cep) {
        this.cep = Integer.parseInt(Util.onlyNumber(cep));
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
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

    public NivelRelacionamentoEnum getNivelRelacionamentoEnum() {
        return nivelRelacionamentoEnum;
    }
    public void setNivelRelacionamentoEnum(NivelRelacionamentoEnum nivelRelacionamentoEnum) {
        this.nivelRelacionamentoEnum = nivelRelacionamentoEnum;
    }

    public String getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getResponsavelContato() {
        return responsavelContato;
    }
    public void setResponsavelContato(String responsavelContato) {
        this.responsavelContato = responsavelContato;
    }

    public SituacaoProjetoEnum getSituacaoEnum() {
        return situacaoEnum;
    }
    public void setSituacaoEnum(SituacaoProjetoEnum situacaoEnum) {
        this.situacaoEnum = situacaoEnum;
    }

    public String getInep() {
        return inep;
    }
    public void setInep(String inep) {
        this.inep = inep;
    }

}
