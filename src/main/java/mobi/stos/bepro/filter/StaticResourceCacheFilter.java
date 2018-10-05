package mobi.stos.bepro.filter;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Weibson
 */
public class StaticResourceCacheFilter implements Filter {

    private FilterConfig _filterConfig;

    /**
     *
     * @param req
     * @param res
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;

        for (Enumeration<?> e = _filterConfig.getInitParameterNames(); e.hasMoreElements();) {
            String header = (String) e.nextElement();
            response.setHeader(header, _filterConfig.getInitParameter(header));
        }

        response.setDateHeader("Expires", System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 7));
        filterChain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this._filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        this._filterConfig = null;
    }
}
