package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum TipoIngressoEnum {

    NORMAL("Normal"),
    CORTESIA("Cortesia");

    private final String name;

    private TipoIngressoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
