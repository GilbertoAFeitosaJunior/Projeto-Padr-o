

package mobi.stos.educador.enumm;

/**
 *
 * @author Matheus Monteiro
 */
public enum SituacaoOficinaEnum {
    
    EM_ANALISE("Em análise"),
    APROVADO("Aprovado"),
    RECUSADO("Recusado");
    
    private final String name;

    private SituacaoOficinaEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
