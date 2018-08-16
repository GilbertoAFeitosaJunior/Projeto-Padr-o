package mobi.stos.youhub.exception;

public class DeleteDeniedException extends Exception {

    public DeleteDeniedException() {
        super("Exclusão não permitida.");
    }

}
