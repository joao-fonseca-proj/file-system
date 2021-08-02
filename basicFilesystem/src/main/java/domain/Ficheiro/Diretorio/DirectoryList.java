package domain.Ficheiro.Diretorio;

import domain.Ficheiro.FicheiroBase;
import domain.Ficheiro.NomeFicheiro;
import utils.DDD.ValueObject;

import java.util.List;

/**
 * Classe auxiliar que vai guardar as referências aos ficheiros filhos.
 */
public class DirectoryList implements ValueObject {
    /**
     * Lista de ficheiros.
     */
    private List<FicheiroBase> subFicheiros;

    /**
     * Construtor inicial - lista.
     * @param list lista
     */
    public DirectoryList(List<FicheiroBase> list) {
        this.subFicheiros = list;
    }

    /**
     * Adiciona ficheiro à lista.
     * @param f ficheiro
     * @return true se adicionado
     */
    public boolean addFicheiroToSubFicheiros(FicheiroBase f) {
        return this.subFicheiros.add(f);
    }

    /**
     * Devolve lista de subficheiros - o nome de cada um.
     * @return mensagem
     */
    public String descricaoConteudos() {
        String s = "";
        for (FicheiroBase f : this.subFicheiros) {
            if (f.isDiretorio()) {
                s = s + "Dir- " + f.nome() + " ";
            } else {
                s = s + "F- " + f.nome() + " ";
            }
        }
        return s;
    }
    /**
     * Devolve lista de subficheiros detalhados- o nome, data criacao, data modificao e permissoes.
     * @return mensagem
     */
    public String descricaoConteudosDetalhados() {
        String s = "";
        for (FicheiroBase f : this.subFicheiros) {
            if (f.isDiretorio()) {
                s = s + "Diretório - " + f.nome() + " criado em: " + f.dataCriacao() + " modificado em: " + f.ultimaModificacao() + " size: " + f.tamanho() + " read: " + f.podeLer() + " write: " + f.podeEscrever() + " execute: " + f.podeExecutar() + "\n";
            } else {
                s = s + "Ficheiro - " + f.nome() + " criado em: " + f.dataCriacao() + " modificado em: " + f.ultimaModificacao() + " size: " + f.tamanho() + " read: " + f.podeLer() + " write: " + f.podeEscrever() + " execute: " + f.podeExecutar() + "\n";
            }
        }
        return s;
    }

    /**
     * Devolve ficheiro através do nome.
     * @param nomeFicheiro nome
     * @return ficheiro se encontrar - null senão.
     */
    public FicheiroBase getFicheiroBase(NomeFicheiro nomeFicheiro) {
        for (FicheiroBase f : this.subFicheiros) {
            if (f.temMesmoNome(nomeFicheiro)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Devolve true se a lista tiver vazia.
     * @return lista
     */
    public boolean isEmpty() {
        return this.subFicheiros.isEmpty();
    }

    /**
     * Remove ficheiro da lista.
     * @param f ficheiro
     * @return true se removido.
     */
    public boolean removerFicheiro(FicheiroBase f) {
        return this.subFicheiros.remove(f);
    }

    /**
     * Verifica se o ficheiro existe - boolean version.
     * @param nomeFicheiro nome ficheiro
     * @return true se existe
     */
    public boolean temFicheiro(NomeFicheiro nomeFicheiro) {
        for (FicheiroBase f : this.subFicheiros) {
            if (f.temMesmoNome(nomeFicheiro)) {
                return true;
            }
        }
        return false;
    }


}
