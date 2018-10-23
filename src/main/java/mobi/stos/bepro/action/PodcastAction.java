package mobi.stos.bepro.action;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.bepro.bean.Evento;
import mobi.stos.bepro.bean.Podcast;
import mobi.stos.bepro.bo.IPodcastBo;
import mobi.stos.bepro.common.GenericAction;
import static mobi.stos.bepro.common.GenericAction.request;
import mobi.stos.bepro.exception.LoginExpiradoException;
import mobi.stos.bepro.util.ConstantsType;
import mobi.stos.bepro.util.Util;
import mobi.stos.bepro.util.consulta.Consulta;
import mobi.stos.bepro.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

public class PodcastAction extends GenericAction {

    private File upload;
    private String uploadContentType;
    private String uploadFileName;

    private List<Podcast> podcasts;

    private Podcast podcast;

    @Autowired
    private IPodcastBo podCastBo;

    @Action(value = "preparePodcast",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/podcast/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (podcast != null && podcast.getId() != null) {
                podcast = this.podCastBo.load(this.podcast.getId());
            }
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistPodcast",
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
            Podcast entity = null;

            if (podcast != null && podcast.getId() != null) {
                entity = this.podCastBo.load(podcast.getId());
                podcast.setFile(entity.getFile());
                podcast.setContentType(entity.getContentType());
                podcast.setFileName(entity.getFileName());
                podcast.setDataCriacao(entity.getDataCriacao());
            }

            if (upload != null) {

                if (entity != null && entity.getId() != null) {
                    ServletContext context = request.getServletContext();
                    File file = new File(context.getRealPath("/") + entity.getFile());

                    if (file.exists()) {
                        file.delete();
                    }
                }

                String ark = Util.uploadFile(upload, uploadContentType,
                        "repo/bepro/podcast/",
                        ConstantsType.AUDIO_VIDEO.getTypes(),
                        request, uploadFileName);
                podcast.setFile(ark);
                podcast.setContentType(uploadContentType);
                podcast.setFileName(uploadFileName);
            }

            if (podcast != null && podcast.getId() == null) {
                podcast.setDataCriacao(new Date());
            }

            podCastBo.persist(podcast);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listPodcast");
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
        }
        return SUCCESS;
    }

    @Action(value = "deletePodcast",
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
            Podcast entity = this.podCastBo.load(podcast.getId());
            if (entity != null && entity.getFile() != null) {
                ServletContext context = request.getServletContext();
                File file = new File(context.getRealPath("/") + entity.getFile());

                if (file.exists()) {
                    file.delete();
                }

            }

            podCastBo.delete(podcast.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listPodcast");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "listPodcast",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/podcast/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            podcasts = podCastBo.list(getConsulta());
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

    public List<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(List<Podcast> podcasts) {
        this.podcasts = podcasts;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }

    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("titulo", "Título"));
        return list;
    }

    @Override
    public void prepare() throws Exception {
        setMenu(Podcast.class.getSimpleName());
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
