package mobi.stos.bepro.exception;

public class DeleteDeniedException extends Exception {

    public DeleteDeniedException() {
        super("Exclusão não permitida.");
    }

}
