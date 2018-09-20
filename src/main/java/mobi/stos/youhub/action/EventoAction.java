package mobi.stos.youhub.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.youhub.bean.DiretorSala;
import mobi.stos.youhub.bean.Evento;
import mobi.stos.youhub.bean.TipoEvento;
import mobi.stos.youhub.bo.IDiretorSalaBo;
import mobi.stos.youhub.bo.IEventoBo;
import mobi.stos.youhub.bo.ITipoEventoBo;
import mobi.stos.youhub.common.GenericAction;
import static mobi.stos.youhub.common.GenericAction.request;
import mobi.stos.youhub.enumm.SituacaoFechamentoEnum;
import mobi.stos.youhub.exception.LoginExpiradoException;
import mobi.stos.youhub.util.Util;
import mobi.stos.youhub.util.consulta.Consulta;
import mobi.stos.youhub.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

public class EventoAction extends GenericAction {
    
    private File upload;
    private String uploadContentType;
    private String uploadFileName;
    
    private Evento evento;
    private List<Evento> eventos;
    private List<TipoEvento> tipoEventos;
    private List<DiretorSala> diretorSalas;
    @Autowired
    private IEventoBo eventoBo;
    
    @Autowired
    private ITipoEventoBo tipoEventoBo;
    
    @Autowired
    private IDiretorSalaBo diretorSalaBo;
    
    @Action(value = "prepareEvento",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/evento/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (evento != null && evento.getId() != null) {
                evento = this.eventoBo.load(this.evento.getId());
            }
            
            this.diretorSalas = this.diretorSalaBo.listall();
            this.tipoEventos = this.tipoEventoBo.listall();
            
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }
    
    @Action(value = "persistEvento",
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
            
            if (evento != null && evento.getId() != null) {
                Evento entity = this.eventoBo.load(evento.getId());
                evento.setFoto(entity.getFoto());
                
                ServletContext context = request.getServletContext();
                File file = new File(context.getRealPath("/") + entity.getFoto());
                
                if (file.exists()) {
                    file.delete();
                }
                
            }
            
            if (upload != null) {
                String ark = Util.uploadFile(upload, uploadContentType,
                        "repo/youhub/fotos/",
                        new String[]{
                            "image/png",
                            "image/jpeg",
                            "image/gif"
                        },
                        request, uploadFileName);
                
                evento.setFoto(ark);
            }
            
            if (evento != null && evento.getId() == null) {
                evento.setSituacaoFechamentoEnum(SituacaoFechamentoEnum.ABERTO);
            }
            
            eventoBo.persist(evento);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listEvento");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    @Action(value = "deleteEvento",
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
            Evento entity = this.eventoBo.load(evento.getId());
            if (entity != null && entity.getFoto() != null) {
                ServletContext context = request.getServletContext();
                File file = new File(context.getRealPath("/") + entity.getFoto());
                
                if (file.exists()) {
                    file.delete();
                }
                
            }
            
            eventoBo.delete(evento.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listEvento");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }
    
    @Action(value = "listEvento",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/evento/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            eventos = eventoBo.list(getConsulta());
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
    
    public List<DiretorSala> getDiretorSalas() {
        return diretorSalas;
    }
    
    public void setDiretorSalas(List<DiretorSala> diretorSalas) {
        this.diretorSalas = diretorSalas;
    }
    
    public List<TipoEvento> getTipoEventos() {
        return tipoEventos;
    }
    
    public void setTipoEventos(List<TipoEvento> tipoEventos) {
        this.tipoEventos = tipoEventos;
    }
    
    public Evento getEvento() {
        return evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public List<Evento> getEventos() {
        return eventos;
    }
    
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("titulo", "Título"));
        return list;
    }
    
    @Override
    public void prepare() throws Exception {
        setMenu(Evento.class.getSimpleName());
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
