package mobi.stos.educador.enumm;

/**
 *
 * @author DEV-JAVA
 */
public enum SituacaoProjetoEnum {
    
    ATIVO("Ativo"),
    PAUSADO("Pausado"),
    CANCELADO("Cancelado"),
    EM_NEGOCIACAO("Em negociação");

    private final String name;

    private SituacaoProjetoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static SituacaoProjetoEnum retornaEnumNaPosicao (int posicao){
        return SituacaoProjetoEnum.values()[posicao];
    }
    
}
