package mobi.stos.youhub.exception;

public class AccessDeniedException extends Exception {

    public AccessDeniedException() {
        super("Acesso não autorizado!");
    }
}
