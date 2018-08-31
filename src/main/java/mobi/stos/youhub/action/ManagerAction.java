package mobi.stos.youhub.action;

import com.google.api.client.repackaged.com.google.common.base.Strings;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IManagerBo;
import mobi.stos.youhub.bo.IUsuarioBo;
import mobi.stos.youhub.common.GenericAction;
import static mobi.stos.youhub.common.GenericAction.request;
import mobi.stos.youhub.exception.LoginExpiradoException;
import mobi.stos.youhub.util.Util;
import mobi.stos.youhub.util.consulta.Consulta;
import mobi.stos.youhub.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerAction extends GenericAction {

    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private String ark;
    private Usuario usuario;

    private List<Usuario> usuarios;

    private Manager manager;
    private List<Manager> managers;
    @Autowired
    private IManagerBo managerBo;

    @Autowired
    private IUsuarioBo usuarioBo;

    @Action(value = "prepareManager",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/manager/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (usuario != null && usuario.getId() != null) {
                usuario = usuarioBo.load(usuario.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistManager",
            interceptorRefs = {
                @InterceptorRef(value = "fileUploadStack")
                ,
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
                ,
                @Result(name = ERROR, location = "/app/notify/")

            })
    public String persist() {
        try {
            GenericAction.isLogged(request);
            boolean hasUpload = false;
            if (upload != null) {
                ark = Util.uploadFile(upload, uploadContentType,
                        "repo/youhube/fotos/",
                        new String[]{
                            "image/png",
                            "image/jpeg",
                            "image/gif"
                        },
                        request, uploadFileName);
                hasUpload = true;
            }

            if (usuario != null && usuario.getId() == null) {
                Manager entity = this.managerBo.persist(usuario.getManager());
                if (hasUpload) {
                    entity.setFoto(ark);
                    this.managerBo.persist(entity);
                }
                usuario.setManager(entity);
                this.usuarioBo.cadastrar(usuario);
            } else {
                Usuario entityUsu = this.usuarioBo.load(usuario.getId());
                usuario.setEmail(entityUsu.getEmail());
                if (Strings.isNullOrEmpty(usuario.getSenha())) {
                    usuario.setSenha(entityUsu.getSenha());
                }
                Manager entity = this.managerBo.load(usuario.getManager().getId());

                if (hasUpload) {
                    ServletContext context = request.getServletContext();
                    File file = new File(context.getRealPath("/") + entity.getFoto());

                    if (file.exists()) {
                        file.delete();
                    }
                    entity = this.usuario.getManager();
                    entity.setFoto(ark);
                    usuario.getManager().setFoto(entity.getFoto());
                } else {
                    usuario.getManager().setFoto(entity.getFoto());
                }
                this.managerBo.persist(usuario.getManager());
                this.usuarioBo.persist(usuario);
            }

            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listManager");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteManager",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
                ,
                @Result(name = ERROR, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);

            this.usuario = this.usuarioBo.load(usuario.getId());
            this.usuarioBo.delete(usuario.getId());
            managerBo.delete(usuario.getManager().getId());

            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listManager");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listManager",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/manager/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            Consulta consulta = getConsulta();
            consulta.addAliasTable("manager", "manager");
            usuarios = usuarioBo.list(getConsulta());
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("manager.nome", "Nome"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Manager.class.getSimpleName());
    }

    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        GenericAction.request = hsr;
    }

    @Override
    public void setServletResponse(HttpServletResponse hsr) {
        GenericAction.response = hsr;
    }

}
