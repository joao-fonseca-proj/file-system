package domain.Ficheiro.Ficheiro;

import domain.Ficheiro.FicheiroBase;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Implementação do ficheiro base para a classe Ficheiro(ficheiro atómico). Tem um conteúdo.
 */
public class Ficheiro extends FicheiroBase {

    /**
     * Conteúdo do ficheiro.
     */
    private ConteudoFicheiro conteudo;

    /**
     * Construtor compelto
     * @param nome nome
     * @param read read
     * @param write write
     * @param exe executar
     * @param del delete
     * @param size tamanho
     */
    public Ficheiro(String nome, boolean read, boolean write, boolean exe, boolean del, int size) {
        super(nome, read, write, exe, del, size);
        this.conteudo = new ConteudoFicheiro("--Conteúdo do FicheiroBase--");
    }

    /**
     * Construtor default
     * @param nome nome
     * @param size size
     */
    public Ficheiro(String nome, int size) {
        super(nome,size);
        this.conteudo = new ConteudoFicheiro("--Conteúdo do FicheiroBase--");
    }

    /**
     * Devolve os conteudos detalhados do ficheiro - nome, data, tamanho, permissoes
     * @return string
     */
    @Override
    public String devolveConteudosDetalhados() {
        return nome() + " " + ultimaModificacao() + " " + tamanho() + "read: " + podeLer() + " write: " + podeEscrever() + " execute: " + podeExecutar() + "\n";
    }

    /**
     * Devolve true se for diretorio.
     * @return false
     */
    @Override
    public boolean isDiretorio() {
        return false;
    }
    /**
     * Devolve true se for file.
     * @return true
     */
    @Override
    public boolean isFile() {
        return true;
    }

    /**
     * Edita os conteúdos do ficheiro se tiver permissão para escrever.
     * @param cont conteudo
     * @throws NoPermissionsException
     */
    public void editaConteudos(String cont) throws NoPermissionsException {
        if(this.podeEscrever()) {
            this.conteudo = new ConteudoFicheiro(cont);
            this.atualizarMudanca();
        } else {
            throw new NoPermissionsException(ConfigurationMessages.NO_WRITE_PERM);
        }
    }

    /**
     * Devolve true se tiver vazio.
     * @return boolean
     */
    public boolean temConteudos() {
        return conteudo.isEmpty();
    }

    /**
     * Get conteudos do ficheiro se tiver permissão de leitura.
     * @return conteudo
     * @throws NoPermissionsException
     */
    public String devolveConteudos() throws NoPermissionsException {
        if(this.podeLer()) {
            return this.conteudo.conteudos();
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_READ_PERM);
    }
}


