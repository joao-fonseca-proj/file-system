package domain.Filesystem;

import domain.Ficheiro.Diretorio.Diretorio;
import utils.DDD.AggregateRoot;

public class Filesystem implements AggregateRoot {

    private static int SIZE_FILESYSTEM = 100;

    private Diretorio root;

    public Filesystem() {
        this.root = new Diretorio("root", true, true, true, false, null);
    }

    public Diretorio root() {
        return this.root;
    }

}
