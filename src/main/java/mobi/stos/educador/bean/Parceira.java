package mobi.stos.educador.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import mobi.stos.educador.enumm.SituacaoParceiraEnum;
import mobi.stos.educador.util.Util;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Rafael Bloise
 */

@Entity
@DynamicInsert
@DynamicUpdate
public class Parceira implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false, length=255)
    private String nome;
    
    @Column(nullable=false)
    private SituacaoParceiraEnum situacaoParceiraEnum;
        
    @Column(nullable=false)
    private Long cnpj;
    
    @Column(nullable=false, length=100)
    private String logradouro;
    
    @Column(nullable=false, length=10)
    private String numero;
    
    @Column(nullable=false, length=100)
    private String complemento;
    
    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;
    
    @Column(nullable=false, length=100)
    private String responsavelLegal;
    
    @Column(nullable=false)
    private int responsavelLegalContato;
    
    @Column(nullable=false, length=100)
    private String responsavelPrincipal;
    
    @Column(nullable=false)
    private int responsavelPrincipalContato;
    
    
    
     public String getResponsavelPrincipalContatoStringMask() {
        return Util.format("######-####", Util.zeroFill(this.responsavelPrincipalContato, 9));

    }
    public void setResponsavelPrincipalContatoStringMask(String responsavelPrincipalContato) {
        this.responsavelPrincipalContato = Integer.parseInt(Util.onlyNumber(responsavelPrincipalContato));
    }
    
        
     public String getResponsavelLegalContatoStringMask() {
        return Util.format("######-####", Util.zeroFill(this.responsavelLegalContato, 9));

    }
    public void setResponsavelLegalContatoStringMask(String responsavelLegalContato) {
        this.responsavelLegalContato = Integer.parseInt(Util.onlyNumber(responsavelLegalContato));
    }
    
    public String getCnpjStringMask() {
        return Util.format("##.###.###/####-##", Util.zeroFill(this.cnpj, 14));

    }
    public void setCnpjStringMask(String cnpj) {
        this.cnpj = Long.parseLong(Util.onlyNumber(cnpj));
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SituacaoParceiraEnum getSituacaoParceiraEnum() {
        return situacaoParceiraEnum;
    }

    public void setSituacaoParceiraEnum(SituacaoParceiraEnum situacaoParceiraEnum) {
        this.situacaoParceiraEnum = situacaoParceiraEnum;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
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

    public String getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(String responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public int getResponsavelLegalContato() {
        return responsavelLegalContato;
    }

    public void setResponsavelLegalContato(int responsavelLegalContato) {
        this.responsavelLegalContato = responsavelLegalContato;
    }

    public String getResponsavelPrincipal() {
        return responsavelPrincipal;
    }

    public void setResponsavelPrincipal(String responsavelPrincipal) {
        this.responsavelPrincipal = responsavelPrincipal;
    }

    public int getResponsavelPrincipalContato() {
        return responsavelPrincipalContato;
    }

    public void setResponsavelPrincipalContato(int responsavelPrincipalContato) {
        this.responsavelPrincipalContato = responsavelPrincipalContato;
    }
    
}
