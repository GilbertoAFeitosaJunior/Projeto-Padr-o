package mobi.stos.youhub.restful.model;

/**
 *
 * @author feito
 */
public class QueryConvidado {

    private long idConsultor;
    private long idManager;
    private long idEvento;
    private String query;
    private int page;

    public long getIdConsultor() {
        return idConsultor;
    }

    public void setIdConsultor(long idConsultor) {
        this.idConsultor = idConsultor;
    }

    public long getIdManager() {
        return idManager;
    }

    public void setIdManager(long idManager) {
        this.idManager = idManager;
    }

    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
