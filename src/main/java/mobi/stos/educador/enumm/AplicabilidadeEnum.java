package mobi.stos.educador.enumm;

/**
 *
 * @author DEV-JAVA
 */
public enum AplicabilidadeEnum {
    
    HIGIENE("Higiene"),
    SEGURANÇA("Segurança"),
    SAUDE("Saúde"),
    ALFABETIZACAO("Alfabetização");
    
     private final String name;

    private AplicabilidadeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
