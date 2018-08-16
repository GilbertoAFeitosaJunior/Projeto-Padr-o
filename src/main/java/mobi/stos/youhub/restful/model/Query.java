package mobi.stos.youhub.restful.model;

/**
 *
 * @author feito
 */
public class Query {

    private long id;
    private String query;
    private int page;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
