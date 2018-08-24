package mobi.stos.youhub.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Weibson
 */
@Entity
@DynamicInsert
@DynamicUpdate
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String razaoSocial;

    @Column(nullable = false, length = 100)
    private String nomeFantasia;

    @Column(nullable = false, length = 18)
    private String cnpj;

    @Column(length = 2)
    private String dddCelular;

    @Column(length = 10)
    private String celular;

    @Column(length = 2)
    private String dddTelefone;

    @Column(length = 10)
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(String dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
