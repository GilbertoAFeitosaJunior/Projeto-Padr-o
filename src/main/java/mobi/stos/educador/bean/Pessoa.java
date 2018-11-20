package mobi.stos.educador.bean;

import freemarker.template.utility.StringUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import mobi.stos.educador.enumm.GeneroEnum;
import mobi.stos.educador.enumm.SexoEnum;
import mobi.stos.educador.util.AES;
import static mobi.stos.educador.util.AES.decrypt;
import static mobi.stos.educador.util.AES.encrypt;
import org.apache.commons.lang.StringUtils;
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
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Type(type = "text")
    private String nome;

    @Column(nullable = false)
    private SexoEnum sexoEnum;

    @Column(nullable = false)
    private GeneroEnum generoEnum;

    @Column(length = 100)
    private String pai;

    @Column(length = 100)
    private String mae;

    private Long horizion_id;

    private Long rc_id;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        
           this.nome = nomeEncriptado(nome);
        
    }

    public SexoEnum getSexoEnum() {
        return sexoEnum;
    }

    public void setSexoEnum(SexoEnum sexoEnum) {
        this.sexoEnum = sexoEnum;
    }

    public GeneroEnum getGeneroEnum() {
        return generoEnum;
    }

    public void setGeneroEnum(GeneroEnum generoEnum) {
        this.generoEnum = generoEnum;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Long getHorizion_id() {
        return horizion_id;
    }

    public void setHorizion_id(Long horizion_id) {
        this.horizion_id = horizion_id;
    }

    public Long getRc_id() {
        return rc_id;
    }

    public void setRc_id(Long rc_id) {
        this.rc_id = rc_id;
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
    
    public String nomeEncriptado(String nome) throws Exception{
        
            byte[] textoencriptado = encrypt(nome, AES.chaveencriptacao);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < textoencriptado.length; i++) {
                builder.append(new Integer(textoencriptado[i])).append(":");
            }
            
            
        return this.nome = builder.toString();
       
    }
    
//    public String nomeDecriptado(String nome) throws Exception{
//        String textoDecriptado = decrypt(nome.getBytes(), AES.chaveencriptacao);
//        return textoDecriptado;
//    }
}
