package mobi.stos.padrao.bo;

import mobi.stos.padrao.bean.Usuario;
import mobi.stos.padrao.common.IOperations;
import mobi.stos.padrao.exception.AvoidDuplicationEmailException;
import mobi.stos.padrao.exception.LoginException;
import mobi.stos.padrao.exception.SenhaException;

public interface IUsuarioBo extends IOperations<Usuario> {

    Usuario login(String email, String senha) throws LoginException, SenhaException;

    Usuario byHash(String hash);

    Usuario cadastrar(Usuario usuario) throws AvoidDuplicationEmailException;

    Usuario byEmail(String email);

}
