package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum SituacaoFechamentoEnum {

    ABERTO("Aberto"),
    ANDAMENTO("Andamento"),
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
