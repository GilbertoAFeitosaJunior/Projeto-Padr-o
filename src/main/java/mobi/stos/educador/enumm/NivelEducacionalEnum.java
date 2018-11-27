package mobi.stos.educador.enumm;

/**
 * @author Rafael Bloise
 */
public enum NivelEducacionalEnum {
    
    INFANTIL("Infantil"),
    FUNDAMENTAL("Fundamental"),
    MEDIO("Médio");
    
    private final String name;

    private NivelEducacionalEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
}
