package mobi.stos.educador.exception;

public class DeleteDeniedException extends Exception {

    public DeleteDeniedException() {
        super("Exclusão não permitida.");
    }

}
