package mobi.stos.youhub.enumm;

/**
 *
 * @author Weibson
 */
public enum SituacaoAcompanhamentoEnum {

    EM_ANDAMENTO("Em Andamento"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    CADASTRO("Cadastro");

    private final String name;

    private SituacaoAcompanhamentoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
