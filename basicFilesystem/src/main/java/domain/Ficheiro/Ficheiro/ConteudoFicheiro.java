package domain.Ficheiro.Ficheiro;

/**
 * Classe auxiliar que vai armazenar o conteúdo do ficheiro.
 */
public class ConteudoFicheiro {
    /**
     * Conteudo
     */
    private String conteudo;

    // ORM
    private ConteudoFicheiro() {
    }

    /**
     * Construtor completo
     * @param conteudo conteudo
     */
    public ConteudoFicheiro(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Devolve o conteudo
     * @return conteudo
     */
    public String conteudos() {
        return this.conteudo;
    }

    /**
     * Devolve se está vazio.
     * @return true se sim
     */
    public boolean isEmpty() {
        return this.conteudo.isEmpty();
    }
}
