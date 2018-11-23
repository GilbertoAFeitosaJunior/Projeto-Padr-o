package mobi.stos.educador.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Anexo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Oficina oficina;

    @Type(type = "text")
    private String descricao;

    @Type(type = "text")
    @Column(nullable = false)
    private String arquivo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPublicacao;

    private int download;
    
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getDownload() {
        return download;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setDownload(int download) {
        this.download = download;
    }
    
     public String getTipoMine() {
        return tipoMine(this.tipo);
    }

    public String tipoMine(String tipo) {
        String tipoR = "";
        if (tipo != null) {

            switch (this.tipo) {
                case "image/jpeg":
                    tipoR = "Imagem";
                    break;
                case "application/octet-stream":
                    tipoR = "Aplicativo";
                    break;
                case "application/x-msdownload":
                    tipoR = "Executável Android";
                    break;
                case "application/pdf":
                    tipoR = "PDF";
                    break;
                case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                    tipoR = "Documento Word";
                    break;
                case "text/plain":
                    tipoR = "Arquivo Texto";
                    break;
                case "audio/mpeg":
                    tipoR = "Audio";
                    break;
                default:
                    tipoR = tipo;
                    break;
            }
        }
        return tipoR;
    }
    
}
