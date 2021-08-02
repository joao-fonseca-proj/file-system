package controllers.Ficheiro;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo mover um ficheiro no diretório para outro do filesystem. Tem o serviço de localização e move o ficheiro no diretório destino através do atual.**/

public class MoverFicheiroController {

    private DiretorioAtualService sv;

    public MoverFicheiroController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String moverFicheiro(String nomeFicheiro, String nomeDiretorio) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase fileCopiar = diretorioAtual.devolveFicheiroBase(nomeFicheiro); // verificar se ficheiro existe e guarda-lo
            if (fileCopiar == null && fileCopiar.isFile()) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }
            diretorioAtual.removerFicheiro(fileCopiar); // existe
            FicheiroBase diretorioDestino = diretorioAtual.devolveFicheiroBase(nomeDiretorio); // verificar se o diretorio destino existe
            if (diretorioDestino == null) {
                return ConfigurationMessages.DIR_NOT_FOUND;
            }

            if (!diretorioDestino.isFile()) { // verificar se é um diretorio
                Diretorio diretorioFinal = (Diretorio) diretorioDestino;

                if (diretorioFinal.temFicheiro(nomeFicheiro)) { // verificar se o diretório destino já tem um ficheiro com o mesmo nome
                    return ConfigurationMessages.EXISTENT_FILE;
                }

                diretorioFinal.adicionarFicheiro(fileCopiar);
                return nomeFicheiro + ConfigurationMessages.FILE_MOVED + nomeDiretorio;
            }
            return nomeDiretorio + ConfigurationMessages.NOT_A_DIR;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
