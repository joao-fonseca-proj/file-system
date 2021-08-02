package domain.Ficheiro;


import utils.DDD.ValueObject;

/**
 * Classe auxiliar usada para guarda o nome do ficheiro
 */
public class NomeFicheiro implements ValueObject {

    /**
     * Nome Ficheiro
     */
    private String nome;

    // ORM
    private NomeFicheiro() {

    }

    /**
     * Construtor completo - throws exception se o nome não tiver contéudo.
     * @param name nome
     */
    public NomeFicheiro(String name) {
        if(isNameValid(name)) {
            this.nome = name;
        } else {
            throw new IllegalArgumentException("Nome inválido - é necessário ter 1 ou mais carateres.");
        }
    }

    /**
     * Verifica se o nome tem conteudos.
     * @param nome nome
     * @return true se length > 0
     */
    private static boolean isNameValid(String nome) {
        if(nome.length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Devolve nome do ficheiro.
     * @return nome
     */
    public String nomeFicheiro() {
        return this.nome;
    }

    /**
     * Equals do nome com outro objeto.
     * @param o objeto
     * @return true se iguais.
     */
    @Override
    public boolean equals(Object o) {
        if(o!=null){
            if(o instanceof NomeFicheiro){
                NomeFicheiro temp = (NomeFicheiro)o;
                return this.nome.equals(temp.nome);
            }
        }
        return false;
    }
}
