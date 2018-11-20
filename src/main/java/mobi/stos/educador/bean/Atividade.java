package mobi.stos.educador.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

/**
 *
 * @author Rafael Bloise
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class Atividade implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String nome;
    
    @Type(type = "text")
    private String descricao;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "atividade_metodologia",
            joinColumns = {
                @JoinColumn(name = "atividade_id", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "metodologia_id", nullable = false, referencedColumnName = "id")})
    private Set<Metodologia> metodologias;

    
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

    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Metodologia> getMetodologias() {
        return metodologias;
    }
    
    public void setMetodologias(Set<Metodologia> metodologias) {
        this.metodologias = metodologias;
    }
    
   // métodos para o atributo many to many
    
    public void addMetodologia(Metodologia metodologia) {
        if (this.metodologias == null) {
            this.metodologias = new HashSet<>();
        }
        this.metodologias.add(metodologia);
    }
    public void removeMetodologia(Metodologia metodologia) {
        if (this.metodologias != null) {
            this.metodologias.remove(metodologia);
        }
    }
    
    
    
    
}
