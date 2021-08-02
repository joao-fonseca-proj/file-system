package controllers.Diretorio;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo mudar de diretório no filesystem. Tem o serviço de localização e procura o diretório seguinte através do seu nome.
 */
public class MudaDiretorioController {

    private DiretorioAtualService sv;

    public MudaDiretorioController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String mudaDiretorio(String nomeDir) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase novoDiretorio = diretorioAtual.devolveFicheiroBase(nomeDir);
            if (novoDiretorio == null) {
                return ConfigurationMessages.DIR_NOT_FOUND;
            }
            if (novoDiretorio.isDiretorio()) {
                Diretorio d = (Diretorio) novoDiretorio;
                this.sv.mudarDiretorioSeguinte(d);
                return ConfigurationMessages.DIR_CHANGE;
            }
            return novoDiretorio.nome() + ConfigurationMessages.NOT_A_DIR;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }

}
