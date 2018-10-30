package mobi.stos.educador.exception;

public class AvoidDuplicationEmailException extends Exception {

    public AvoidDuplicationEmailException() {
        super("Email já está cadastrado");
    }

}
