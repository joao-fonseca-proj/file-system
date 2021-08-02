package service;

import domain.Ficheiro.Diretorio.Diretorio;

/**
 * Serviço usado para localizar o utilizador no filesystem.
 */
public class DiretorioAtualService {
    /**
     * Diretorio atual.
     */
    public Diretorio diretorioAtual;
    /**
     * Path atual.
     */
    public String oldPath = "";

    /**
     * Muda para o diretório pertencente ao antigo.
     * @param dir diretorio
     */
    public void mudarDiretorioSeguinte(Diretorio dir) {
        this.diretorioAtual = dir;
        createOldPathSeguinte(dir);
    }

    /**
     * Muda para o diretório precedente ao antigo.
     * @param dir diretorio
     */
    public void mudarDiretorioAnterior(Diretorio dir) {
        createOldPathAnterior();
        this.diretorioAtual = dir;
    }

    /**
     * Atualiza o path com mudança de movimento seguinte.
     * @param dir
     */
    private void createOldPathSeguinte(Diretorio dir) {
        this.oldPath = this.oldPath + "/" + dir.nome();
    }

    /**
     * Atualiza o path com mudança de movimento anterior.
     */
    private void createOldPathAnterior() {
        int length = diretorioAtual.nome().length();
        this.oldPath = this.oldPath.substring(0, this.oldPath.length() - 1 - length);
    }


}
