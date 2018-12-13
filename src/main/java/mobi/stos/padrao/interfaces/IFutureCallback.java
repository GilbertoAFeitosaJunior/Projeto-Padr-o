package mobi.stos.padrao.interfaces;

/**
 *
 * @author feito
 */

public interface IFutureCallback {

    void onSuccess();

    void onError(Exception exception);
}
