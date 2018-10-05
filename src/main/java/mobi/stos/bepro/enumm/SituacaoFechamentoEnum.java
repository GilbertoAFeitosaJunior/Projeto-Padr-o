package mobi.stos.bepro.enumm;


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
