package mobi.stos.youhub.dao;

import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.common.IOperations;

public interface IUsuarioDao extends IOperations<Usuario> {

    Usuario byEmail(String email);

    Usuario byHash(String hash);

}
