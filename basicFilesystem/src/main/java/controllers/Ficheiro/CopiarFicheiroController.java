package controllers.Ficheiro;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo copiar um ficheiro no diretório para outro do filesystem. Tem o serviço de localização e cria o ficheiro no diretório destino através do atual.**/
public class CopiarFicheiroController {

    private DiretorioAtualService sv;

    public CopiarFicheiroController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String copiarFicheiro(String nomeFicheiro, String nomeDiretorio) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase fileCopiar = diretorioAtual.devolveFicheiroBase(nomeFicheiro); // verificar se ficheiro existe e guarda-lo
            if (fileCopiar == null && fileCopiar.isFile()) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }
            FicheiroBase diretorioDestino = diretorioAtual.devolveFicheiroBase(nomeDiretorio); // verificar se o diretorio destino existe
            if (diretorioDestino == null) {
                return ConfigurationMessages.DIR_NOT_FOUND;
            }

            if (diretorioDestino.isDiretorio()) { // verificar se é um diretorio
                Diretorio diretorioFinal = (Diretorio) diretorioDestino; // verificar se o diretório destino já tem um ficheiro com o mesmo nome

                if (diretorioFinal.temFicheiro(nomeFicheiro)) {
                    return ConfigurationMessages.EXISTENT_FILE;
                }
                diretorioFinal.adicionarFicheiro(fileCopiar);
                return nomeFicheiro + ConfigurationMessages.FILE_COPIED + nomeDiretorio;
            }
            return nomeDiretorio + ConfigurationMessages.NOT_A_DIR;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
