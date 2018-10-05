package mobi.stos.bepro.exception;

public class AccessDeniedException extends Exception {

    public AccessDeniedException() {
        super("Acesso não autorizado!");
    }
}
