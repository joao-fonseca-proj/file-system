package domain.Ficheiro.Diretorio;

import domain.Ficheiro.FicheiroBase;
import domain.Ficheiro.NomeFicheiro;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

import java.util.ArrayList;

/**
 * Implementação do ficheiro base para um folder (diretório). Tem o diretório pai e uma lista de sub ficheiros.
 */
public class Diretorio extends FicheiroBase {

    private static int TAMANHO_BASE_FOLDER = 3;
    /**
     * Diretorio diretamenta acima.
     */
    private Diretorio diretorioPai;
    /**
     * Lista de subficheiros
     */
    private DirectoryList list;

    /**
     * Construtor completo
     * @param nome nome
     * @param read leitura
     * @param write escrita
     * @param exe execução
     * @param del delete
     * @param dirPai diretorio pai (null se root)
     */
    public Diretorio(String nome, boolean read, boolean write, boolean exe, boolean del, Diretorio dirPai) {
        super(nome, read, write, exe, del, TAMANHO_BASE_FOLDER);
        this.diretorioPai = dirPai;
        this.list = new DirectoryList(new ArrayList<FicheiroBase>());
    }

    /**
     * Construtor default
     * @param nome nome
     * @param dirPai diretorio pai (null se root)
     */
    public Diretorio(String nome, Diretorio dirPai) {
        super(nome, TAMANHO_BASE_FOLDER);
        this.list = new DirectoryList(new ArrayList<FicheiroBase>());
        this.diretorioPai = dirPai;
    }

    /**
     * Devolve uma mensagem com a descrição da cada ficheiro filho se tiver permissão de leitura.
     * @return mensagem descrição
     * @throws NoPermissionsException
     */
    @Override
    public String devolveConteudosDetalhados() throws NoPermissionsException {
        if(this.podeLer()) {
            return list.descricaoConteudosDetalhados();
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_READ_PERM);
    }

    /**
     * Devolve true se diretório.
     * @return boolean
     */
    @Override
    public boolean isDiretorio() {
        return true;
    }

    /**
     * Devolve true se ficheiro
     * @return boolean
     */
    @Override
    public boolean isFile() {
        return false;
    }

    /**
     * Devolve o diretório pai.
     * @return
     */
    public Diretorio diretorioPai() {
        return diretorioPai;
    }

    /**
     * Devolve true se for a root (dir pai é null).
     * @return true
     */
    public boolean isRoot() {
        if (this.diretorioPai == null) {
            return true;
        }
        return false;
    }

    /**
     * Devolve se tem sub ficheiros.
     * @return subfiles
     */
    public boolean temConteudos() {
        return !list.isEmpty();
    }

    /**
     * Devolve a lista de sub ficheiros (nome apenas) se tiver permissões de leitura
     * @return mensagem
     * @throws NoPermissionsException
     */
    public String devolveConteudos() throws NoPermissionsException {
        if(this.podeLer()) {
            return list.descricaoConteudos();
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_READ_PERM);
    }

    /**
     * Vai buscar um ficheiro na sublista através do nome se tiver permissões de leitura
     * @param nomeFicheiro nome
     * @return file se existir - null se não
     * @throws NoPermissionsException
     */
    public FicheiroBase devolveFicheiroBase(String nomeFicheiro) throws NoPermissionsException {
        if(this.podeLer()) {
            return list.getFicheiroBase(new NomeFicheiro(nomeFicheiro));
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_READ_PERM);
    }

    public boolean temFicheiro(String nomeFicheiro) throws NoPermissionsException {
        if(this.podeLer()) {
            return list.temFicheiro(new NomeFicheiro(nomeFicheiro));
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_READ_PERM);
    }

    /**
     * Adiciona um ficheiro à sub lista se tiver permissão de escrita.
     * @param f ficheiro
     * @return true se adicionado
     * @throws NoPermissionsException
     */
    public boolean adicionarFicheiro(FicheiroBase f) throws NoPermissionsException {
        if (this.podeEscrever()) {
            if (list.addFicheiroToSubFicheiros(f)) {
                this.atualizarMudanca();
                this.atualizarTamanho(f.tamanho());
                return true;
            }
            return false;
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_READ_PERM);
    }

    /**
     * Remove um ficheiro se tiver permissões de escrita e o ficheiro tiver permissões de delete.
     * @param f ficheiro
     * @return true se apagado
     * @throws NoPermissionsException
     */
    public boolean removerFicheiro(FicheiroBase f) throws NoPermissionsException {
        if (this.podeEscrever()) {
            if (list.removerFicheiro(f) && f.podeApagar()) {
                this.atualizarMudanca();
                this.atualizarTamanho(-f.tamanho());
                return true;
            }
            return false;
        }
        throw new NoPermissionsException(ConfigurationMessages.NO_WRITE_PERM);
    }

}
