package domain;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.Ficheiro.Ficheiro;
import domain.Ficheiro.NomeFicheiro;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FicheiroBaseTest {

    Ficheiro fileTest;

    public FicheiroBaseTest() {
        fileTest = new Ficheiro("test.txt", 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureNomeFicheiroNaoPodeSerVazio() {
        NomeFicheiro f = new NomeFicheiro("");
    }

    @Test
    public void ensureFicheiroDefaultTemReadTrue() {
        assertTrue(fileTest.podeLer());
    }
    @Test
    public void ensureFicheiroDefaultTemWriteTrue() {
        assertTrue(fileTest.podeEscrever());
    }
    @Test
    public void ensureFicheiroDefaultTemExecuteFalse() {
        assertFalse(fileTest.podeExecutar());
    }
    @Test
    public void ensureMudaPermissoesMuda() {
        fileTest.mudarPermissoesRWX(false, false, false);
        assertFalse(fileTest.podeApagar());
        assertFalse(fileTest.podeEscrever());
        assertFalse(fileTest.podeExecutar());
    }
    @Test
    public void ensureMesmoNomeEqual() {
        NomeFicheiro n = new NomeFicheiro("test.txt");
        assertTrue(fileTest.temMesmoNome(n));
    }
    @Test
    public void ensureNaoApagaSemPermissoes() {

    }
    @Test
    public void ensureNaoAdicionaSemPermissoes() {

    }
}
