package mobi.stos.bepro.dao;

import mobi.stos.bepro.bean.Usuario;
import mobi.stos.bepro.common.IOperations;

public interface IUsuarioDao extends IOperations<Usuario> {

    Usuario byEmail(String email);

    Usuario byHash(String hash);


}
