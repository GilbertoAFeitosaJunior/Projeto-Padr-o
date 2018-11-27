package mobi.stos.educador.enumm;

/**
 * @author Rafael Bloise
 */
public enum SituacaoParceiraEnum {
    
    ATIVO("Ativo"),
    PAUSADO("Pausado"),
    EM_NEGOCIACAO("Em negociação");
    
    
    private final String name;

    private SituacaoParceiraEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
}
