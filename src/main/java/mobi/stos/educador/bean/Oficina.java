

package mobi.stos.educador.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mobi.stos.educador.enumm.TurnoEnum;
import mobi.stos.educador.enumm.SituacaoOficinaEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author Matheus Monteiro
 */

@Entity
@DynamicInsert
@DynamicUpdate
public class Oficina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    private Educador educador;
    
    @ManyToOne(optional = false)
    private Escola escola;
    
   @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "oficina_atividade",
            joinColumns = {
                @JoinColumn(name = "oficina_id", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "atividade_id", nullable = false, referencedColumnName = "id")})
    private Set<Atividade> atividades;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataPlanejada;
    
    @Column(nullable = false)
    private TurnoEnum turnoEnum;
    
    @Column(nullable = false)
    private SituacaoOficinaEnum situacaoEnum;
    
    private String historico;
    
    @Temporal(TemporalType.DATE)
    private Date dataRealizada;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Educador getEducador() {
        return educador;
    }
    public void setEducador(Educador educador) {
        this.educador = educador;
    }

    public Escola getEscola() {
        return escola;
    }
    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }
    public void setAtividades(Set<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    public void addAtividade(Atividade atividade) {
        if (this.atividades == null) {
            this.atividades = new HashSet<>();
        }
        this.atividades.add(atividade);
    }
    public void removeAtividade(Atividade atividade) {
        if (this.atividades != null) {
            this.atividades.remove(atividade);
        }
    }
    
    public Date getDataPlanejada() {
        return dataPlanejada;
    }
    public void setDataPlanejada(Date dataPlanejada) {
        this.dataPlanejada = dataPlanejada;
    }

    public TurnoEnum getTurnoEnum() {
        return turnoEnum;
    }
    public void setTurnoEnum(TurnoEnum turnoEnum) {
        this.turnoEnum = turnoEnum;
    }

    public SituacaoOficinaEnum getSituacaoEnum() {
        return situacaoEnum;
    }
    public void setSituacaoEnum(SituacaoOficinaEnum situacaoEnum) {
        this.situacaoEnum = situacaoEnum;
    }

    public String getHistorico() {
        return historico;
    }
    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Date getDataRealizada() {
        return dataRealizada;
    }
    public void setDataRealizada(Date dataRealizada) {
        this.dataRealizada = dataRealizada;
    }

}
