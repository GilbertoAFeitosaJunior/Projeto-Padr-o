package mobi.stos.educador.dao;

import java.util.List;
import mobi.stos.educador.bean.Usuario;
import mobi.stos.educador.common.IOperations;

public interface IUsuarioDao extends IOperations<Usuario> {

    Usuario byEmail(String email);

    Usuario byHash(String hash);

    public List<Usuario> listSomenteUsuarios();
    
    
}
