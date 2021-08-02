package controllers.Ficheiro;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo apagar o ficheiro de um diretório do filesystem. Tem o serviço de localização e apaga o ficheiro através do seu nome.
 */
public class ApagarFicheiroController {

    private DiretorioAtualService sv;

    public ApagarFicheiroController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String apagaFicheiro(String nomeFicheiro) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase f = diretorioAtual.devolveFicheiroBase(nomeFicheiro);
            if (f == null) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }
            if (f.isFile()) {
                if (diretorioAtual.removerFicheiro(f)) {
                    return ConfigurationMessages.FILE_REMOVED;
                }
                return ConfigurationMessages.ERROR_FILE_REMOVED;
            }
            return f.nome() + ConfigurationMessages.NOT_A_FILE;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }


    }
}
