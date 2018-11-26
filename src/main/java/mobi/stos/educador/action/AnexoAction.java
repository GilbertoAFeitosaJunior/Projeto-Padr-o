
package mobi.stos.educador.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.Anexo;
import mobi.stos.educador.bean.Oficina;
import mobi.stos.educador.bo.IAnexoBo;
import mobi.stos.educador.bo.IOficinaBo;
import mobi.stos.educador.common.GenericAction;
import mobi.stos.educador.util.ConstantsType;
import mobi.stos.educador.util.JsonReturn;
import mobi.stos.educador.util.Util;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Matheus Monteiro
 */
public class AnexoAction extends GenericAction{
    
    private Anexo anexo;
    private Oficina oficina;
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    
    private List<Anexo> anexos;
    
    @Autowired
    private IAnexoBo anexoBo;
    
    @Autowired
    private IOficinaBo oficinaBo;
    
    @Action(value = "persistAnexo",
            interceptorRefs = {
                @InterceptorRef(value = "fileUploadStack")
                ,
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String persist() {
        String oficina_id = request.getParameter("oficina.id");
        try {

            GenericAction.isLogged(request);

            oficina = oficinaBo.load(Long.parseLong(oficina_id));
            oficina.setEducador(null);
            oficina.setAtividades(null);

            //<editor-fold defaultstate="collapsed" desc="Função de Upload">
            if (upload != null) {
                String ark = Util.uploadFile(upload, uploadContentType,
                        "repo/educador/download/",
                        ConstantsType.ALL.getTypes(),
                        request, uploadFileName);
                anexo.setArquivo(ark);
                anexo.setTipo(uploadContentType);
                anexo.setOficina(oficina);
                anexo.setDataPublicacao(new Date());
                anexoBo.persist(anexo);
                
            }
            //</editor-fold>

            //addActionMessage("Registro salvo com sucesso.");
            //setRedirectURL("listOficina");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    @Action(value = "updateAnexo",
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String updateAnexo() {
        try {
            GenericAction.isLogged(request);

            anexo = anexoBo.load(anexo.getId());
            anexo.setDownload(anexo.getDownload() + 1);
            anexoBo.persist(anexo);
            
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return SUCCESS;
    }

    
    @Action(value = "listAnexo",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            anexos = anexoBo.byOficinaId(anexo.getOficina().getId());
            for (Anexo anexo : anexos) {
                anexo.setOficina(null);
            }
            jsonReturn = new JsonReturn(true);

            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }
    
    @Action(value = "deleteAnexo",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, type = "json")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            
//            Consulta consulta = getConsulta();
//            consulta.addCriterion(Restrictions.eq("oficina.id", oficina.getId()));
//            anexos = anexoBo.list(consulta);
            
//            for(Anexo anexo: anexos){
                
            this.anexo = this.anexoBo.load(this.anexo.getId());
            anexo.setOficina(null);

            ServletContext context = request.getServletContext();
            File file = new File(context.getRealPath("/") + anexo.getArquivo());
            if (file.exists()) {
                file.delete();
            }
            
            this.anexoBo.delete(this.anexo.getId());

            //addActionMessage("Registro excluído com sucesso.");
            //setRedirectURL("listOficina");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    @Override
    public JsonReturn getJsonReturn() {
        return super.getJsonReturn();
    }

    public Anexo getAnexo() {
        return anexo;
    }

    public void setAnexo(Anexo anexo) {
        this.anexo = anexo;
    }

    public List<Anexo> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<Anexo> anexos) {
        this.anexos = anexos;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
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
    
    
    @Override
    public void prepare() throws Exception {
        setMenu(Anexo.class.getSimpleName());
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
