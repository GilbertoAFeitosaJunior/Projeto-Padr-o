package mobi.stos.educador.enumm;

/**
 *
 * @author Weibson
 */
public enum SexoEnum {

    NAO_INFORMAR("Não informar"),
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String name;

    private SexoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
