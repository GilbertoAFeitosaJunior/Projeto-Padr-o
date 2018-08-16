package mobi.stos.youhub.exception;

public class AvoidDuplicationEmailException extends Exception {

    public AvoidDuplicationEmailException() {
        super("Email já está cadastrado");
    }

}
