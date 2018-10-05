package mobi.stos.bepro.exception;

public class RegistroNotFoundException extends Exception {

    public RegistroNotFoundException() {
        super("Registro não encontrato. Verifique os dados digitados.");
    }

}
