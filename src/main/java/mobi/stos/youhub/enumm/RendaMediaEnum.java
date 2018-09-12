package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum RendaMediaEnum {

    ATE_2_MIL("Até 2 mil"),
    DE_2_E_5_MIL("De 2 5 mil"),
    DE_5_10_MIL("De 5 a 10 mil"),
    ACIMA_DE_10_MIL("Acima de 10 mil");
    

    private final String name;

    private RendaMediaEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
