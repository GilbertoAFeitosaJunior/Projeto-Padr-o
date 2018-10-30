package mobi.stos.educador.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    private Secretaria secretaria;
    
    @Type (type = "text")
    private String dadosContato;

    
    
    
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
    
    
    
    
    
}
