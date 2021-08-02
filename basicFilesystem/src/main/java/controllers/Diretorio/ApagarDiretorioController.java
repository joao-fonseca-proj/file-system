package controllers.Diretorio;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo apagar o diretório do filesystem. Tem o serviço de localização e apaga o diretório através do seu nome.
 */
public class ApagarDiretorioController {

    private DiretorioAtualService sv;

    public ApagarDiretorioController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String apagarDiretorio(String nomeDir) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase d = diretorioAtual.devolveFicheiroBase(nomeDir);
            if (d == null) {
                return ConfigurationMessages.DIR_NOT_FOUND;
            }
            if (d.isDiretorio()) {
                if (d.temConteudos()) {
                    return ConfigurationMessages.DIR_HAS_FILES;
                }
                if (diretorioAtual.removerFicheiro(d)) {
                    return ConfigurationMessages.DIR_REMOVED;
                }
                return ConfigurationMessages.ERROR_DIR_REMOVED;
            }
            return d.nome() + ConfigurationMessages.NOT_A_DIR;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
