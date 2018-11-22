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
import mobi.stos.educador.enumm.NivelSecretariaEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import mobi.stos.educador.bean.CoordenadorPedagogico;
import mobi.stos.educador.bean.GestorDoTerritorio;
import mobi.stos.educador.util.Util;

/**
 *
 * @author DEV-JAVA
 */

@Entity
@DynamicInsert
@DynamicUpdate
public class Secretaria implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false)
    private NivelSecretariaEnum nivelSecretariaEnum;
    
    @Column(nullable = false, length = 2)
    private String uf;
    
    @Column(nullable = false)
    private String municipio;
    
    @Column(nullable = false, length = 100)
    private String responsavel;
    
    @Column(nullable = false)
    private int responsavelContato;
    
    @Column(nullable = false)
    private GestorDoTerritorio gestorDoTerritorio;
    
    @Column(nullable = false)
    private CoordenadorPedagogico coordenadorPedagogico;
    
    
    
    

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

    public NivelSecretariaEnum getNivelSecretariaEnum() {
        return nivelSecretariaEnum;
    }

    public void setNivelSecretariaEnum(NivelSecretariaEnum nivelSecretariaEnum) {
        this.nivelSecretariaEnum = nivelSecretariaEnum;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getResponsavelContato() {
        return responsavelContato;
    }

    public void setResponsavelContato(int responsavelContato) {
        this.responsavelContato = responsavelContato;
    }
    
    
    public String getResponsavelContatoStringMask() {
        return Util.format("######-####", Util.zeroFill(this.responsavelContato, 9));

    }
    public void setResponsavelContatoStringMask(String responsavelContato) {
        this.responsavelContato = Integer.parseInt(Util.onlyNumber(responsavelContato));
    }
    

    public GestorDoTerritorio getGestorDoTerritorio() {
        return gestorDoTerritorio;
    }

    public void setGestorDoTerritorio(GestorDoTerritorio gestorDoTerritorio) {
        this.gestorDoTerritorio = gestorDoTerritorio;
    }

    public CoordenadorPedagogico getCoordenadorPedagogico() {
        return coordenadorPedagogico;
    }

    public void setCoordenadorPedagogico(CoordenadorPedagogico coordenadorPedagogico) {
        this.coordenadorPedagogico = coordenadorPedagogico;
    }
    
    
    
    
    
    
}
