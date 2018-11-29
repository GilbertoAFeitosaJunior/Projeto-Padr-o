package mobi.stos.educador.action;
/**
 *
 * @author Rafael Bloise
 */
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mobi.stos.educador.bean.CoordenadorPedagogico;
import mobi.stos.educador.bean.GestorDoTerritorio;
import mobi.stos.educador.bean.Secretaria;
import mobi.stos.educador.bo.ICoordenadorPedagogicoBo;
import mobi.stos.educador.bo.IGestorDoTerritorioBo;
import mobi.stos.educador.bo.ISecretariaBo;
import mobi.stos.educador.enumm.NivelSecretariaEnum;
import mobi.stos.educador.common.GenericAction;
import static mobi.stos.educador.common.GenericAction.request;
import mobi.stos.educador.exception.LoginExpiradoException;
import mobi.stos.educador.util.consulta.Consulta;
import mobi.stos.educador.util.consulta.Keys;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class SecretariaAction extends GenericAction {

    private Secretaria secretaria;

    private List<Secretaria> secretarias;
    
    private List<GestorDoTerritorio> gestorDoTerritorios;
    
    private List<CoordenadorPedagogico> coordenadorPedagogicos;

    @Autowired
    private ISecretariaBo secretariaBo;
    
    @Autowired
    private ICoordenadorPedagogicoBo coordenadorPedagogicoBo;
    
    @Autowired
    private IGestorDoTerritorioBo gestorDoTerritorioBo;

    @Action(value = "prepareSecretaria",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/secretaria/formulario.jsp")
            })
    public String preparar() {
        try {
            GenericAction.isLogged(request);
            if (secretaria != null && secretaria.getId() != null) {
                secretaria = this.secretariaBo.load(this.secretaria.getId());
            }
            
            this.coordenadorPedagogicos = coordenadorPedagogicoBo.listall();
            this.gestorDoTerritorios = gestorDoTerritorioBo.listall();
            
            
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
    }

    @Action(value = "persistSecretaria",
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
            Secretaria entity = null;
            if (secretaria != null && secretaria.getId() != null) {
                 entity = secretariaBo.load(secretaria.getId());
                }
            
            String ufMaiusculo = secretaria.getUf().toUpperCase();
            secretaria.setUf(ufMaiusculo);
            
            this.secretariaBo.persist(secretaria);
            addActionMessage("Registro salvo com sucesso.");
            setRedirectURL("listSecretaria");
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            return ERROR;
        }
        return SUCCESS;
    }

    @Action(value = "deleteSecretaria",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = SUCCESS, location = "/app/notify/")
            })
    public String delete() {
        try {
            GenericAction.isLogged(request);
            secretariaBo.delete(secretaria.getId());
            addActionMessage("Registro excluído com sucesso.");
            setRedirectURL("listSecretaria");
        } catch (LoginExpiradoException e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
        }
        return SUCCESS;
    }

    @Action(value = "listSecretaria",
            interceptorRefs = {
                @InterceptorRef(value = "basicStack")},
            results = {
                @Result(name = ERROR, location = "/app/notify/")
                ,
                @Result(name = SUCCESS, location = "/app/secretaria/")
            })
    public String list() {
        try {
            GenericAction.isLogged(request);
            if (getConsulta() == null) {
                String field = (String) getCamposConsultaEnum().get(0).getKey();
                setConsulta(new Consulta(field));
            }
            
            Consulta consulta = getConsulta();
            consulta.addOrder(Order.desc("id"));
            secretarias = secretariaBo.list(consulta);
            return SUCCESS;
        } catch (Exception e) {
            addActionError("Erro ao processar a informação. Erro: " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
    }

    @JSON(serialize = false)
    public List<Secretaria> getSecretarias() {
        return secretarias;
    }
    
    @JSON(serialize = false)
    public List<Keys> getCamposConsultaEnum() {
        List<Keys> list = new ArrayList<>();
        list.add(new Keys("nome", "Nome"));
        return list;
    }
    
    
    @JSON(serialize = false)
    public List getNivelSecretariaEnums() {
        return Arrays.asList(NivelSecretariaEnum.values());
    }
    

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public List<GestorDoTerritorio> getGestorDoTerritorios() {
        return gestorDoTerritorios;
    }

    public void setGestorDoTerritorios(List<GestorDoTerritorio> gestorDoTerritorios) {
        this.gestorDoTerritorios = gestorDoTerritorios;
    }

    public List<CoordenadorPedagogico> getCoordenadorPedagogicos() {
        return coordenadorPedagogicos;
    }

    public void setCoordenadorPedagogicos(List<CoordenadorPedagogico> coordenadorPedagogicos) {
        this.coordenadorPedagogicos = coordenadorPedagogicos;
    }
    
    
    

    @Override
    public void prepare() throws Exception {
        setMenu(Secretaria.class.getSimpleName());
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
