package mobi.stos.padrao.exception;

public class AvoidDuplicationEmailException extends Exception {

    public AvoidDuplicationEmailException() {
        super("Email já está cadastrado");
    }

}
