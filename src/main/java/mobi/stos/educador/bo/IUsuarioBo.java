package mobi.stos.educador.bo;

import java.util.List;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.common.IOperations;
import mobi.stos.educador.exception.AvoidDuplicationEmailException;
import mobi.stos.educador.exception.LoginException;
import mobi.stos.educador.exception.SenhaException;

public interface IUsuarioBo extends IOperations<Usuario> {

    Usuario login(String email, String senha) throws LoginException, SenhaException;

    Usuario byHash(String hash);

    Usuario cadastrar(Usuario usuario) throws AvoidDuplicationEmailException;

    Usuario byEmail(String email);
    
    List<Usuario> listSomenteUsuarios();
}
