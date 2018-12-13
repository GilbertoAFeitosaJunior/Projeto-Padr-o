package mobi.stos.padrao.exception;

public class DeleteDeniedException extends Exception {

    public DeleteDeniedException() {
        super("Exclusão não permitida.");
    }

}
