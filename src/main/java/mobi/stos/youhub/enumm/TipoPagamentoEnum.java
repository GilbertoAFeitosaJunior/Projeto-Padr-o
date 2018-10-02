package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum TipoPagamentoEnum {
    
    CASH("CASH"),
    CARTAO("Cartão"),
    BOLETO("Boleto"),
    DEPOSITO("Deposito");

    private final String name;

    private TipoPagamentoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
