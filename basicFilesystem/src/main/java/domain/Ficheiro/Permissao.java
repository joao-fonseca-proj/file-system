package domain.Ficheiro;


import utils.DDD.ValueObject;

/**
 * Classe auxiliar para guarda uma acao e o valor da autorizacão
 */
public class Permissao implements ValueObject {

    /**
     * Ação
     */
    private Permissoes.PermissoesEnum acao;

    /**
     * Autorização
     */
    private boolean autorizacao;

    private Permissao() {

    }

    /**
     * Construtor completo
     * @param modo açao
     * @param autorizacao auth
     */
    public Permissao(Permissoes.PermissoesEnum modo, boolean autorizacao) {
        this.autorizacao = autorizacao;
        this.acao = modo;
    }

    /**
     * Devolve true se autorizado
     * @return boolean
     */
    public boolean autorizacao() {
        return autorizacao;
    }
}
