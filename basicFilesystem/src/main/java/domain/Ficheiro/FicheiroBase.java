package domain.Ficheiro;

import utils.DDD.Entity;
import utils.NoPermissionsException;

/**
 * Classe Base das entradas de filesystem.
 */
public abstract class FicheiroBase implements Entity {

    /**
     * Nome do Ficheiro.
     */
    private NomeFicheiro nome;
    /**
     * Data de modificação
     */
    private DataFicheiro dataModificacao;
    /**
     * Data de criação.
     */
    private DataFicheiro dataCriacao;

    /**
     * Lista de Permissões.
     */
    private Permissoes listaPermissoes;
    /**
     * Tamanho do ficheiro.
     */
    private Tamanho tamanhoFicheiro;

    /**
     * Construtor completo com permissoes
     * @param nome nome
     * @param read permissao read
     * @param write permissao write
     * @param exe permissao executar
     * @param del permissao delete
     * @param size tamanho
     */
    public FicheiroBase(String nome, boolean read, boolean write, boolean exe, boolean del, int size) {
        this.nome = new NomeFicheiro(nome);
        this.dataModificacao = new DataFicheiro();
        this.dataCriacao = new DataFicheiro();
        this.listaPermissoes = new Permissoes(read, write, exe, del);
        this.tamanhoFicheiro = new Tamanho(size);
    }

    /**
     * Construtor default
     * @param nome nome
     * @param size tamanho
     */
    public FicheiroBase(String nome, int size) {
        this.nome = new NomeFicheiro(nome);
        this.dataModificacao = new DataFicheiro();
        this.dataCriacao = new DataFicheiro();
        this.listaPermissoes = new Permissoes();
        this.tamanhoFicheiro = new Tamanho(size);
    }

    /**
     * Devolve o nome
     * @return string
     */
    public String nome() {
        return nome.nomeFicheiro();
    }

    /**
     * Devolve a ultima data de modificação.
     * @return data
     */
    public String ultimaModificacao() {
        return dataModificacao.dataFormatada();
    }

    /**
     * Devolve a data de criação
     * @return data
     */
    public String dataCriacao() {
        return dataCriacao.dataFormatada();
    }

    /**
     * Devolve o tamanho do ficheiro
     * @return tamanho
     */
    public int tamanho() {
        return tamanhoFicheiro.tamanho();
    }

    /**
     * Devolve se pode escrever.
     * @return boolean
     */
    public boolean podeEscrever() {
        return listaPermissoes.permissoesWrite();
    }
    /**
     * Devolve se pode ler.
     * @return boolean
     */
    public boolean podeLer() {
        return listaPermissoes.permissoesRead();
    }
    /**
     * Devolve se pode executar.
     * @return boolean
     */
    public boolean podeExecutar() {
        return listaPermissoes.permissoesExecute();
    }

    /**
     * Devolve se pode apagar.
     * @return boolean
     */
    public boolean podeApagar() {
        return listaPermissoes.permissoesDelete();
    }

    /**
     * Devolve true se tem o mesmo nome.
     * @param f nome
     * @return boolean
     */
    public boolean temMesmoNome(NomeFicheiro f) {
        return this.nome.equals(f);
    }

    /**
     * Muda as permissões do ficheiro,
     * @param read leitura
     * @param write escrita
     * @param execute executar
     */
    public void mudarPermissoesRWX(boolean read,boolean write, boolean execute) {
        this.listaPermissoes.mudarPermissoes(read, write, execute);
    }

    /**
     * Atualiza data de mudança para atual.
     */
    public void atualizarMudanca() {
        this.dataModificacao = new DataFicheiro();
    }

    /**
     * Devolve true se for diretório.
     * @return boolean
     */
    public abstract boolean isDiretorio();
    /**
     * Devolve true se for ficheiro.
     * @return boolean
     */
    public abstract boolean isFile();
    /**
     * Devolve true se tiver conteudos.
     * @return boolean
     */
    public abstract boolean temConteudos();
    /**
     * Devolve conteudos.
     * @return boolean
     */
    public abstract String devolveConteudos() throws NoPermissionsException;

    /**
     * Devolve conteudos detalhados
     * @return
     */
    public abstract String devolveConteudosDetalhados()throws NoPermissionsException;

    /**
     * Atualiza o tamanho do ficheiro, somando o passado por parametro
     * @param tamanho tamanho
     */
    public void atualizarTamanho(int tamanho) {
        this.tamanhoFicheiro = new Tamanho(tamanho + this.tamanho());
    }
}
