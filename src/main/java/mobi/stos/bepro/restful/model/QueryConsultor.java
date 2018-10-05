package mobi.stos.bepro.restful.model;

/**
 *
 * @author feito
 */
public class QueryConsultor {

    private String hash;
    private String query;
    private int page;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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
