package mobi.stos.padrao.dao;

import mobi.stos.padrao.bean.Usuario;
import mobi.stos.padrao.common.IOperations;

public interface IUsuarioDao extends IOperations<Usuario> {

    Usuario byEmail(String email);

    Usuario byHash(String hash);

}
