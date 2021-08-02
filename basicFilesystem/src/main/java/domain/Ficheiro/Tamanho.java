package domain.Ficheiro;


import utils.DDD.ValueObject;

/**
 * Classe auxiliar que vai guardar o tamanho do ficheiro.
 */
public class Tamanho implements ValueObject {
    /**
     * Inteiro Tamanho
     */
    private int tamanho;

    /**
     * Construtor completo
     * @param size tamanho
     */
    public Tamanho(int size) {
        this.tamanho = size;
    }

    /**
     * Devolve o tamanho do ficheiro
     * @return tamanho
     */
    public int tamanho() {
        return tamanho;
    }
}
