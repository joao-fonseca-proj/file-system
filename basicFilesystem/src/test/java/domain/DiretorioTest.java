package domain;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.Ficheiro.Ficheiro;
import org.junit.Test;
import utils.NoPermissionsException;

import static org.junit.Assert.*;

public class DiretorioTest {

    Diretorio root;
    Diretorio dirTest;
    Ficheiro ficheiroAdd;

    public DiretorioTest() {
        root = new Diretorio("folder", null);
        dirTest = new Diretorio("folder2", root);
        ficheiroAdd = new Ficheiro("teste.txt", 15);
    }

    @Test
    public void ensureIsRootTrueWhenDirRoot() {
        assertTrue(root.isRoot());
    }

    @Test
    public void ensureIsDiretorioTrue() {
        assertTrue(root.isDiretorio());
    }
    @Test
    public void ensureIsFileFalse() {
        assertFalse(root.isFile());
    }

    @Test
    public void ensureListaSubFicheirosVaziaQuandoCria() {
        assertFalse(dirTest.temConteudos());
    }

    @Test(expected = NoPermissionsException.class)
    public void ensureNaoAdicionaSemPermissoes() throws NoPermissionsException {
        dirTest.mudarPermissoesRWX(false, false,false);
        dirTest.adicionarFicheiro(ficheiroAdd);
    }
    @Test(expected = NoPermissionsException.class)
    public void ensureNaoRemoveSemPermissoes() throws NoPermissionsException {
        dirTest.mudarPermissoesRWX(false, false,false);
        dirTest.adicionarFicheiro(ficheiroAdd);
    }

    @Test
    public void ensureAdicionaFicheiro() throws NoPermissionsException {
        dirTest.mudarPermissoesRWX(true, true, true);
        dirTest.adicionarFicheiro(ficheiroAdd);
        assertNotNull(dirTest.devolveFicheiroBase("teste.txt"));
    }
    @Test
    public void ensureRemoveFicheiro() throws NoPermissionsException {
        dirTest.removerFicheiro(ficheiroAdd);
        assertNull(dirTest.devolveFicheiroBase("teste.txt"));
    }
    @Test
    public void ensureTamanhoAumentaQuandoAdicionaFicheiro() throws NoPermissionsException {
        int tamanho = dirTest.tamanho();
        int tamanhoFinal = tamanho + ficheiroAdd.tamanho();
        dirTest.adicionarFicheiro(ficheiroAdd);
        assertEquals(tamanhoFinal, dirTest.tamanho());
    }

}
