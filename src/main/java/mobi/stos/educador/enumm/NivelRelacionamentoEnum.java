
package mobi.stos.educador.enumm;

/**
 *
 * @author Matheus Monteiro
 */
public enum NivelRelacionamentoEnum {
    
    ALTO("Alto"),
    BAIXO("Baixo");

    private final String name;
    
    private NivelRelacionamentoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public static NivelRelacionamentoEnum retornaEnumNaPosicao (int posicao){
        return NivelRelacionamentoEnum.values()[posicao];
    }

}
