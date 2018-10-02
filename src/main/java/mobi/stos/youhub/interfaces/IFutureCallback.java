package mobi.stos.youhub.interfaces;

/**
 *
 * @author feito
 */

public interface IFutureCallback {

    void onSuccess();

    void onError(Exception exception);
}
