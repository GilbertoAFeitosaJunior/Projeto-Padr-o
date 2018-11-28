package mobi.stos.educador.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import mobi.stos.educador.enumm.DependenciaAdministrativaEnum;
import mobi.stos.educador.enumm.RedeEnum;
import mobi.stos.educador.enumm.SituacaoProjetoEnum;
import mobi.stos.educador.enumm.TipoDeAtuacaoEnum;
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

    @Column(length = 100)
    private String responsavel;

    @Type(type = "text")
    private String responsavelContato;

    @Column(nullable = false)
    private SituacaoProjetoEnum situacaoEnum;

    @Column(length = 50)
    private String inep;
    
    @Column(nullable=false)
    private RedeEnum redeEnum;
    
    @Column(nullable=false)
    private TipoDeAtuacaoEnum tipoDeAtuacaoEnum;
    
    @Column
    private DependenciaAdministrativaEnum depedenciaAdministrativaEnum;
    
    @Column
    private int responsavelTelefone;
    
    @Column(nullable=false)
    private String diretorResponsavel;
    
    @Column
    private int diretorContato;

    public Escola(Long id) {
        this.id = id;
    }

    public Escola() {
    }
    
    public String getCepStringMask() {
        return Util.format("#####-###", Util.zeroFill(this.cep, 8));
    }
    public void setCepStringMask(String cep) {
        this.cep = Integer.parseInt(Util.onlyNumber(cep));
    }
    
    
     public String getResponsavelTelefoneStringMask() {
        return Util.format("######-####", Util.zeroFill(this.responsavelTelefone, 9));

    }
    public void setResponsavelTelefoneStringMask(String responsavelTelefone) {
        this.responsavelTelefone = Integer.parseInt(Util.onlyNumber(responsavelTelefone));
    }
    
    
     public String getDiretorContatoStringMask() {
        return Util.format("######-####", Util.zeroFill(this.diretorContato, 9));

    }
    public void setDiretorContatoStringMask(String diretorContato) {
        this.diretorContato = Integer.parseInt(Util.onlyNumber(diretorContato));
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

    public RedeEnum getRedeEnum() {
        return redeEnum;
    }

    public void setRedeEnum(RedeEnum redeEnum) {
        this.redeEnum = redeEnum;
    }

    public TipoDeAtuacaoEnum getTipoDeAtuacaoEnum() {
        return tipoDeAtuacaoEnum;
    }

    public void setTipoDeAtuacaoEnum(TipoDeAtuacaoEnum tipoDeAtuacaoEnum) {
        this.tipoDeAtuacaoEnum = tipoDeAtuacaoEnum;
    }

    public DependenciaAdministrativaEnum getDepedenciaAdministrativaEnum() {
        return depedenciaAdministrativaEnum;
    }

    public void setDepedenciaAdministrativaEnum(DependenciaAdministrativaEnum depedenciaAdministrativaEnum) {
        this.depedenciaAdministrativaEnum = depedenciaAdministrativaEnum;
    }

    public int getResponsavelTelefone() {
        return responsavelTelefone;
    }

    public void setResponsavelTelefone(int responsavelTelefone) {
        this.responsavelTelefone = responsavelTelefone;
    }

    public String getDiretorResponsavel() {
        return diretorResponsavel;
    }

    public void setDiretorResponsavel(String diretorResponsavel) {
        this.diretorResponsavel = diretorResponsavel;
    }

    public int getDiretorContato() {
        return diretorContato;
    }

    public void setDiretorContato(int diretorContato) {
        this.diretorContato = diretorContato;
    }
    
    
    
    

}
