package mobi.stos.educador.enumm;

/**
 *
 * @author Rafael Bloise
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
    
    
    public static AplicabilidadeEnum retornaEnumNaPosicao (int posicao){
        return AplicabilidadeEnum.values()[posicao];
    }
    
}
