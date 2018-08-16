package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum SituacaoPagamentoEnum {

    EM_ABERTO("Em aberto"),
    PAGO("Pago"),
    CANCELADO("Cancelado"),
    ABONADO("Abonado");

    private final String name;

    private SituacaoPagamentoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
