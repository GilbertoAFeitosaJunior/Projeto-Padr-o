package mobi.stos.youhub.exception;

public class PerfilNotFoundException extends Exception {

    public PerfilNotFoundException() {
        super("O perfil não foi encontrado, favor verifique as informações desse usuário.");
    }
}
