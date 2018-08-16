package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum SituacaoConvidadoEnum {

    RELACIONADO("Relacionado"),
    NAO_RELACIONADO("Não Relacionado"),
    PRE_CADASTRO("Pre Cadastro"),
    CADASTRO("Cadastro"),
    CANCELADO("Cancelado");

    private final String name;

    private SituacaoConvidadoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
