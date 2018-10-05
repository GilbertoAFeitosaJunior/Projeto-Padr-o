package mobi.stos.bepro.interfaces;

/**
 *
 * @author feito
 */

public interface IFutureCallback {

    void onSuccess();

    void onError(Exception exception);
}
