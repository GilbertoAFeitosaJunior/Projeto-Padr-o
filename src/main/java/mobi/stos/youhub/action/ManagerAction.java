package mobi.stos.youhub.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.Manager;
import mobi.stos.youhub.bo.IManagerBo;
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

    private Manager manager;
    private List<Manager> managers;
    @Autowired
    private IManagerBo managerBo;

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
            if (manager != null && manager.getId() != null) {
                manager = this.managerBo.load(this.manager.getId());
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
            })
    public String persist() {
        try {
            GenericAction.isLogged(request);

            if (manager != null && manager.getId() != null) {
                Manager entity = this.managerBo.load(manager.getId());
                manager.setFoto(entity.getFoto());
            }
                       
            if (upload != null) {
                String ark = Util.uploadFile(upload, uploadContentType,
                        "repo/youhube/fotos/",
                        new String[]{
                            "image/png",
                            "image/jpeg",
                            "image/gif"
                        },
                        request, uploadFileName);
                manager.setFoto(ark);
            }

           // managerBo.cadastrar(manager);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listManager");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "deleteManager",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            managerBo.delete(manager.getId());
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
            managers = managerBo.list(getConsulta());
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
        list.add(new Keys("nome", "Nome"));
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
