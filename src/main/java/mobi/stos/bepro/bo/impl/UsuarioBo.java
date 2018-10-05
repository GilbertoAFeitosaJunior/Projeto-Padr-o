package mobi.stos.bepro.bo.impl;

import java.util.Date;
import mobi.stos.bepro.bean.Usuario;
import mobi.stos.bepro.bo.IUsuarioBo;
import mobi.stos.bepro.common.AbstractService;
import mobi.stos.bepro.common.IOperations;
import mobi.stos.bepro.dao.IUsuarioDao;
import mobi.stos.bepro.exception.AvoidDuplicationEmailException;
import mobi.stos.bepro.exception.LoginException;
import mobi.stos.bepro.exception.SenhaException;
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
        System.out.println("chegou aqui...");
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
