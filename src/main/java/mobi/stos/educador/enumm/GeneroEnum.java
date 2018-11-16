

package mobi.stos.educador.enumm;

/**
 *
 * @author Matheus Monteiro 
 */

public enum GeneroEnum {
    
    HOMEM("Homem"),
    MULHER("Mulher"),
    OUTRO("Outro");
    
    private final String name;

    private GeneroEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
