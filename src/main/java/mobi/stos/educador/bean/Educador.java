
package mobi.stos.educador.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import mobi.stos.educador.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Matheus Monteiro
 */

@Entity
@DynamicInsert
@DynamicUpdate
public class Educador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Usuario usuario;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "educador_escola",
            joinColumns = {
                @JoinColumn(name = "educador_id", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "escola_id", nullable = false, referencedColumnName = "id")})
    private Set<Escola> escolas;
    
    @Column(length = 100, nullable = false)
    private String nome;
    
    @Column(length = 100, nullable = false)
    private String email;
    
    
    @Column(nullable = false)
    private int ddd;
    
    @Column(nullable = false)
    private int celular;
    
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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getCelular() {
        return celular;
    }
    public void setCelular(int celular) {
        this.celular = celular;
    }
    
    public String getCelularStringMask() {
        return Util.format("######-####", Util.zeroFill(this.celular, 9));

    }
    public void setCelularStringMask(String celular) {
        this.celular = Integer.parseInt(Util.onlyNumber(celular));
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

    public Set<Escola> getEscolas() {
        return escolas;
    }
    public void setEscolas(Set<Escola> escolas) {
        this.escolas = escolas;
    }

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
