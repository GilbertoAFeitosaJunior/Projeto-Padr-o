package mobi.stos.youhub.dao;

import java.util.List;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.common.IOperations;

public interface IUsuarioDao extends IOperations<Usuario> {

    Usuario byEmail(String email);

    Usuario byHash(String hash);

    List<Usuario> listConsultorByManager(Long idMananger);

    Usuario loadByConsultor(Long idConsultor);

}
