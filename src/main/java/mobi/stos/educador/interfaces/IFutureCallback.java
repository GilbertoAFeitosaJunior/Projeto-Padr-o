package mobi.stos.educador.interfaces;

/**
 *
 * @author feito
 */

public interface IFutureCallback {

    void onSuccess();

    void onError(Exception exception);
}
