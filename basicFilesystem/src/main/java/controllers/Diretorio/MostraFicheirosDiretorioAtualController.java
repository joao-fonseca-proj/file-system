package controllers.Diretorio;

import domain.Ficheiro.Diretorio.Diretorio;
import service.DiretorioAtualService;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo mostrar o nome dos ficheiros de um diretório no filesystem(lista de ficheiros). Tem o serviço de localização e lista os conteudos do ficheiro atual.
 */
public class MostraFicheirosDiretorioAtualController {

    private DiretorioAtualService sv;

    public MostraFicheirosDiretorioAtualController(DiretorioAtualService sv) {
        this.sv = sv;
    }

    public String mostraConteudos() {
        Diretorio diretorioAtual = sv.diretorioAtual;
        try {
            return diretorioAtual.devolveConteudos();
        } catch (
                NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
