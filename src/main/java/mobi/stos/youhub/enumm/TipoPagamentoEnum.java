package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum TipoPagamentoEnum {

    BOLETO("Boleto"),
    CARTAO("Cartão"),
    DEPOSITO("Deposito"),
    CASH("CASH");

    private final String name;

    private TipoPagamentoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
