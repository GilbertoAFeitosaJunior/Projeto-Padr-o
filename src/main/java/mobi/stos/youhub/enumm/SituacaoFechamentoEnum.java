package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum SituacaoFechamentoEnum {

    ABERTO("Aberto"),
    FECHADO("Fechado"),
    CANCELADO("Cancelado");

    private final String name;

    private SituacaoFechamentoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
