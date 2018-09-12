package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum AtividadeAtualEnum {

    EMPREGADO("Empregado"),
    DESEMPREGADO("Desempregado"),
    AUTONOMO("Autônomo"),
    EMPRESARIO("Empresário"),
    INVESTIDOR("Investidor");
    

    private final String name;

    private AtividadeAtualEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
