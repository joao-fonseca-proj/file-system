package domain;

import domain.Ficheiro.Ficheiro.Ficheiro;
import org.junit.Test;
import utils.NoPermissionsException;

import static org.junit.Assert.*;

public class FicheiroTest {

    Ficheiro fileTest;

    public FicheiroTest() {
        fileTest = new Ficheiro("teste.txt", 10);
    }

    @Test
    public void ensureEditaConteudosMuda() throws NoPermissionsException {
        String novoConteudo = "test";
        fileTest.editaConteudos(novoConteudo);
        assertEquals(novoConteudo, fileTest.devolveConteudos());
    }

    @Test(expected = NoPermissionsException.class)
    public void ensureNaoEditarSemPermissoes() throws NoPermissionsException {
        fileTest.mudarPermissoesRWX(true, false, false);
        fileTest.editaConteudos("");
    }

    @Test
    public void ensureIsFileReturnsTrue() {
        assertTrue(fileTest.isFile());
    }

    @Test
    public void ensureIsDiretorioReturnsFalse() {
        assertFalse(fileTest.isDiretorio());
    }

}
