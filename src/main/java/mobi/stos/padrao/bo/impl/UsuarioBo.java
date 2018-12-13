package mobi.stos.padrao.bo.impl;

import java.util.Date;
import java.util.List;
import mobi.stos.padrao.bean.Usuario;
import mobi.stos.padrao.bo.IUsuarioBo;
import mobi.stos.padrao.common.AbstractService;
import mobi.stos.padrao.common.IOperations;
import mobi.stos.padrao.dao.IUsuarioDao;
import mobi.stos.padrao.exception.AvoidDuplicationEmailException;
import mobi.stos.padrao.exception.LoginException;
import mobi.stos.padrao.exception.SenhaException;
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
        this.persist(usuario);
        return usuario;
    }

    @Override
    public Usuario byHash(String hash) {
        return dao.byHash(hash);
    }

    @Override
    public Usuario cadastrar(Usuario usuario) throws AvoidDuplicationEmailException {
        if (dao.byEmail(usuario.getEmail()) != null) {
            throw new AvoidDuplicationEmailException();
        }
        return dao.persist(usuario);
    }

    @Override
    public Usuario byEmail(String email) {
        return dao.byEmail(email);
    }

}
