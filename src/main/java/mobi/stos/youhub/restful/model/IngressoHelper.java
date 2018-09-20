package mobi.stos.youhub.restful.model;

import java.util.Date;

/**
 *
 * @author feito
 */
public class IngressoHelper {

    private Long idConsultor;
    private Long idManager;
    private Long idEvento;
    private Long idConvidado;
    private Date data;

    public Long getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(Long idConsultor) {
        this.idConsultor = idConsultor;
    }

    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdConvidado() {
        return idConvidado;
    }

    public void setIdConvidado(Long idConvidado) {
        this.idConvidado = idConvidado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
