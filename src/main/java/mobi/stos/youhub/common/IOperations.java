package mobi.stos.youhub.common;

import java.io.Serializable;
import java.util.List;
import mobi.stos.youhub.util.consulta.Consulta;

public interface IOperations<T extends Serializable> {

    T load(Long id);

    List<T> listall();

    List<T> listall(String[] order);

    List<T> list(Consulta consulta);

    T persist(final T entity);
    
    List<T> persist(final List<T> entities);

    void delete(final long entityId);
}
