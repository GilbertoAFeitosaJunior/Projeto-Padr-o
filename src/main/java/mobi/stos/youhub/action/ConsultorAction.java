package mobi.stos.youhub.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.Consultor;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IConsultorBo;
import mobi.stos.youhub.bo.IUsuarioBo;
import mobi.stos.youhub.common.GenericAction;
import static mobi.stos.youhub.common.GenericAction.request;
import mobi.stos.youhub.util.JsonReturn;
import mobi.stos.youhub.util.Util;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsultorAction extends GenericAction {

    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    private String ark;

    private Consultor consultor;
    private Usuario usuario;
    private List<Consultor> consultors;
    private List<Usuario> usuarios;

    @Autowired
    private IConsultorBo consultorBo;
    @Autowired
    private IUsuarioBo usuarioBo;

    @Action(value = "prepareConsultor",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String prepareConsultor() {
        try {
            GenericAction.isLogged(request);
            if (consultor != null && consultor.getId() != null) {
                this.usuario = this.usuarioBo.loadByConsultor(consultor.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistConsultor",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persist() {
        try {
            GenericAction.isLogged(request);

            boolean hasUpload = false;
            if (upload != null) {
                ark = Util.uploadFile(upload, uploadContentType,
                        "repo/youhub/fotos/",
                        new String[]{
                            "image/png",
                            "image/jpeg",
                            "image/gif"
                        },
                        request, uploadFileName);
                hasUpload = true;
            }

            if (usuario != null && usuario.getConsultor().getId() == null) {
                usuario.getConsultor().setFoto(ark);
                usuario.setConsultor(this.consultorBo.persist(usuario.getConsultor()));
            } else {
                if (hasUpload) {
                    Consultor entity = this.consultorBo.load(usuario.getConsultor().getId());
                    
                    if (entity != null && entity.getFoto() != null) {
                        ServletContext context = request.getServletContext();
                        File file = new File(context.getRealPath("/") + entity.getFoto());

                        if (file.exists()) {
                            file.delete();
                        }
                    }

                    usuario.getConsultor().setFoto(ark);
                    usuario.setConsultor(this.consultorBo.persist(usuario.getConsultor()));

                } else {
                    Consultor entity = this.consultorBo.load(usuario.getConsultor().getId());
                    usuario.getConsultor().setFoto(entity.getFoto());
                    this.consultorBo.persist(usuario.getConsultor());
                }
            }

            this.usuarioBo.persist(usuario);
            this.jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    @Action(value = "listConsultor",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String listConsultor() {
        try {
            GenericAction.isLogged(request);
            this.usuarios = this.usuarioBo.listConsultorByManager(consultor.getManager().getId());
            //this.consultors = consultorBo.listByConsultor(consultor.getManager().getId());
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    @Action(value = "deleteConsultor",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String deleteConsultor() {
        try {
            GenericAction.isLogged(request);
            Usuario entity = this.usuarioBo.loadByConsultor(consultor.getId());

            this.usuarioBo.delete(entity.getId());

            Consultor c = this.consultorBo.load(consultor.getId());
            if (c != null && c.getFoto() != null) {
                ServletContext context = request.getServletContext();
                File file = new File(context.getRealPath("/") + c.getFoto());

                if (file.exists()) {
                    file.delete();
                }
            }

            this.consultorBo.delete(consultor.getId());
            jsonReturn = new JsonReturn(true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonReturn = new JsonReturn(false);
        }
        return SUCCESS;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Consultor> getConsultors() {
        return consultors;
    }

    public void setConsultors(List<Consultor> consultors) {
        this.consultors = consultors;
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

    public Consultor getConsultor() {
        return consultor;
    }

    public void setConsultor(Consultor consultor) {
        this.consultor = consultor;
    }

    @Override
    public JsonReturn getJsonReturn() {
        return super.getJsonReturn(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Consultor.class.getSimpleName());
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
