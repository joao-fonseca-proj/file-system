package controllers.Diretorio;

import domain.Ficheiro.Diretorio.Diretorio;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;

/**
 * Controller que tem como objetivo mudar de diretório para o anterior no filesystem. Tem o serviço de localização e procura o diretório anterior através do diretório atual.
 */
public class MudarDiretorioAnteriorController {

    private DiretorioAtualService sv;

    public MudarDiretorioAnteriorController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String mudaDiretorioAnterior() {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        if(diretorioAtual.isRoot()) {
            return ConfigurationMessages.IS_ROOT;
        }
        this.sv.mudarDiretorioAnterior(diretorioAtual.diretorioPai());
        return ConfigurationMessages.DIRECTORY_CHANGE;
    }
}
