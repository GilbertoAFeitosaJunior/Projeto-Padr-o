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
import mobi.stos.educador.enumm.AplicabilidadeEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

@Entity
@DynamicUpdate
@DynamicInsert
public class Metodologia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Type (type = "text")
    private String descricao;
    
    @Column(nullable = false)
    private AplicabilidadeEnum aplicabilidadeEnum;
    
    @Column(nullable = false)
    private boolean ativo;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "metodologia_escola",
            joinColumns = {
                @JoinColumn(name = "metodologia_id", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "escola_id", nullable = false, referencedColumnName = "id")})
    private Set<Escola> escolas;
   
    
    // Getters and Setters

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

    public AplicabilidadeEnum getAplicabilidadeEnum() {
        return aplicabilidadeEnum;
    }

    public void setAplicabilidadeEnum(AplicabilidadeEnum aplicabilidadeEnum) {
        this.aplicabilidadeEnum = aplicabilidadeEnum;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

   public Set<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas(Set<Escola> escolas) {
        this.escolas = escolas;
    }
    
    
    
    // métodos para o atributo many to many
    
    public void addEscola(Escola escola) {
        if (this.escolas == null) {
            this.escolas = new HashSet<>();
        }
        this.escolas.add(escola);
    }
    public void removeEscola(Escola escola) {
        if (this.escolas != null) {
            this.escolas.remove(escola);
        }

    
    }
}
    
    
    
    

