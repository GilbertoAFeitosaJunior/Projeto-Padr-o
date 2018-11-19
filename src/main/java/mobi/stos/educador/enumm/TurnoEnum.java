
package mobi.stos.educador.enumm;

/**
 *
 * @author Matheus Monteiro
 */
public enum TurnoEnum {

    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite"),
    RECREIO_MANHA("Recreio - Manhã"),
    RECREIO_TARDE("Recreio - Tarde"),
    RECREIO_NOITE("Recreio - Noite");
    
    private final String name;

    private TurnoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
