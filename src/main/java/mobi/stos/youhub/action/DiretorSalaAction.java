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
import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.bean.Usuario;
import mobi.stos.youhub.bo.IDiretorSalaBo;
import mobi.stos.youhub.bo.IUsuarioBo;
import mobi.stos.youhub.common.GenericAction;
import static mobi.stos.youhub.common.GenericAction.request;
import mobi.stos.youhub.util.Util;
import mobi.stos.youhub.util.consulta.Consulta;
import mobi.stos.youhub.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class DiretorSalaAction extends GenericAction {

    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    private String ark;

    private DiretorSala diretorSala;
    private Usuario usuario;

    private List<Usuario> usuarios;
    @Autowired
    private IDiretorSalaBo diretorSalaBo;
    @Autowired
    private IUsuarioBo usuarioBo;

    @Action(value = "prepareDiretorSala",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/diretor_sala/formulario.jsp")
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

    @Action(value = "persistDiretorSala",
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
                        "repo/youhub/fotos/",
                        new String[]{
                            "image/png",
                            "image/jpeg",
                            "image/gif"
                        },
                        request, uploadFileName);
                usuario.getDiretorSala().setFoto(ark);
                hasUpload = true;
            }

            if (usuario != null && usuario.getId() == null) {
                DiretorSala entity = this.diretorSalaBo.persist(usuario.getDiretorSala());
                usuario.setDiretorSala(entity);
                this.usuarioBo.cadastrar(usuario);
            } else {

                Usuario entity = this.usuarioBo.load(usuario.getId());

                if (!hasUpload) {
                    usuario.getDiretorSala().setFoto(entity.getDiretorSala().getFoto());
                } else {
                    DiretorSala d = this.diretorSalaBo.load(entity.getDiretorSala().getId());
                    ServletContext context = request.getServletContext();
                    File file = new File(context.getRealPath("/") + d.getFoto());

                    if (file.exists()) {
                        file.delete();
                    }
                }

                usuario.setEmail(entity.getEmail());

                if (Strings.isNullOrEmpty(usuario.getSenha())) {
                    usuario.setSenha(entity.getSenha());
                }

                this.usuarioBo.persist(usuario);
                this.diretorSalaBo.persist(usuario.getDiretorSala());
            }

            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listDiretorSala");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteDiretorSala",
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

            DiretorSala entity = this.diretorSalaBo.load(usuario.getDiretorSala().getId());
            ServletContext context = request.getServletContext();
            File file = new File(context.getRealPath("/") + entity.getFoto());

            if (file.exists()) {
                file.delete();
            }

            this.diretorSalaBo.delete(entity.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listDiretorSala");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "listDiretorSala",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/diretor_sala/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            Consulta consulta = getConsulta();
            consulta.addAliasTable("diretorSala", "diretorSala");
            consulta.addCriterion(Restrictions.isNotNull("diretorSala"));
            usuarios = usuarioBo.list(consulta);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
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

    public String getArk() {
        return ark;
    }

    public void setArk(String ark) {
        this.ark = ark;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public DiretorSala getDiretorSala() {
        return diretorSala;
    }

    public void setDiretorSala(DiretorSala diretorSala) {
        this.diretorSala = diretorSala;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("diretorSala.nome", "Nome"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(DiretorSala.class.getSimpleName());
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
