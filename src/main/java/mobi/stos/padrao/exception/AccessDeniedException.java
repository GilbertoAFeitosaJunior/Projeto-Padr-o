package mobi.stos.padrao.exception;

public class AccessDeniedException extends Exception {

    public AccessDeniedException() {
        super("Acesso não autorizado!");
    }
}
