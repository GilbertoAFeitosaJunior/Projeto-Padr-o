package mobi.stos.bepro.bo;

import mobi.stos.bepro.bean.Usuario;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.exception.AvoidDuplicationEmailException;
import mobi.stos.bepro.exception.LoginException;
import mobi.stos.bepro.exception.SenhaException;

public interface IUsuarioBo extends IOperations<Usuario> {

    Usuario login(String email, String senha) throws LoginException, SenhaException;

    Usuario byHash(String hash);

    Usuario cadastrar(Usuario usuario) throws AvoidDuplicationEmailException;

    Usuario byEmail(String email);
}
