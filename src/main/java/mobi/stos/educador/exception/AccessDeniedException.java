package mobi.stos.educador.exception;

public class AccessDeniedException extends Exception {

    public AccessDeniedException() {
        super("Acesso não autorizado!");
    }
}
