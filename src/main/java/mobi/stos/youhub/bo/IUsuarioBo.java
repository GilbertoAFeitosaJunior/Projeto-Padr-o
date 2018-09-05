package mobi.stos.youhub.bo;

import java.util.List;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.exception.AvoidDuplicationEmailException;
import mobi.stos.youhub.exception.LoginException;
import mobi.stos.youhub.exception.SenhaException;

public interface IUsuarioBo extends IOperations<Usuario> {

    Usuario login(String email, String senha) throws LoginException, SenhaException;

    Usuario byHash(String hash);

    Usuario cadastrar(Usuario usuario) throws AvoidDuplicationEmailException;

    Usuario byEmail(String email);

    List<Usuario> listConsultorByManager(Long idMananger);
    
    Usuario loadByConsultor(Long idConsultor);
}
