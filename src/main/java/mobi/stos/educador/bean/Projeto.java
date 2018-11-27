package mobi.stos.educador.bean;
/**
 *
 * @author Rafael Bloise
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import mobi.stos.educador.enumm.ModoDeImplementacaoEnum;
import mobi.stos.educador.enumm.SituacaoProjetoEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

@Entity
@DynamicUpdate
@DynamicInsert
public class Projeto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false)
    private SituacaoProjetoEnum situacaoProjetoEnum;
    
    @Column(length = 100)
    private String responsavel;
    
    @ManyToOne(optional = false)
    private Secretaria secretaria;
    
    @Type (type = "text")
    private String dadosContato;
    
    @Column(nullable=false)
    private ModoDeImplementacaoEnum modoDeImplementacaoEnum;
    
    @ManyToOne (optional=false)
    private CoordenadorDeProjeto coordenadorDeProjeto;
    
    @ManyToOne(optional=true)
    private Parceira parceira;
    
    public Projeto() {

    }

    public Projeto(long id) {
        this.id = id;
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

    public SituacaoProjetoEnum getSituacaoProjetoEnum() {
        return situacaoProjetoEnum;
    }

    public void setSituacaoProjetoEnum(SituacaoProjetoEnum situacaoProjetoEnum) {
        this.situacaoProjetoEnum = situacaoProjetoEnum;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public String getDadosContato() {
        return dadosContato;
    }

    public void setDadosContato(String dadosContato) {
        this.dadosContato = dadosContato;
    }

    public ModoDeImplementacaoEnum getModoDeImplementacaoEnum() {
        return modoDeImplementacaoEnum;
    }

    public void setModoDeImplementacaoEnum(ModoDeImplementacaoEnum modoDeImplementacaoEnum) {
        this.modoDeImplementacaoEnum = modoDeImplementacaoEnum;
    }

    public CoordenadorDeProjeto getCoordenadorDeProjeto() {
        return coordenadorDeProjeto;
    }

    public void setCoordenadorDeProjeto(CoordenadorDeProjeto coordenadorDeProjeto) {
        this.coordenadorDeProjeto = coordenadorDeProjeto;
    }

    public Parceira getParceira() {
        return parceira;
    }

    public void setParceira(Parceira parceira) {
        this.parceira = parceira;
    }

  
    
    
    
    
}
