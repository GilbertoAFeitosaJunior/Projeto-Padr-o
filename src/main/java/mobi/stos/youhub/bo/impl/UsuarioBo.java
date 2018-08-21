package mobi.stos.youhub.bo.impl;

import java.util.Date;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IUsuarioBo;
import mobi.stos.youhub.common.AbstractService;
import mobi.stos.youhub.common.IOperations;
import mobi.stos.youhub.dao.IUsuarioDao;
import mobi.stos.youhub.exception.LoginException;
import mobi.stos.youhub.exception.SenhaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBo extends AbstractService<Usuario> implements IUsuarioBo {

    @Autowired
    private IUsuarioDao dao;

    @Override
    protected IOperations<Usuario> getDao() {
        return dao;
    }

    @Override
    public Usuario login(String login, String senha) throws LoginException, SenhaException {
        Usuario usuario = dao.byEmail(login);
        if (usuario == null) {
            return null;
        }
        if (!usuario.getSenha().equals(senha)) {
            return null;
        }
        usuario.setUltimoAcesso(new Date());
        return usuario;
    }

    @Override
    public Usuario byHash(String hash) {
        return dao.byHash(hash);
    }

}
