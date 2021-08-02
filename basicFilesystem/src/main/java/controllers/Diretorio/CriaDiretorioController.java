package controllers.Diretorio;

import domain.Ficheiro.Diretorio.Diretorio;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo criar um diretório no filesystem. Tem o serviço de localização e cria o diretório através do seu nome.
 */
public class CriaDiretorioController {

    private DiretorioAtualService sv;

    public CriaDiretorioController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String criaDiretorio(String nomeDiretorio) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            Diretorio f = new Diretorio(nomeDiretorio, diretorioAtual);
            if (diretorioAtual.adicionarFicheiro(f)) {
                return ConfigurationMessages.DIR_ADDED + diretorioAtual.nome();
            }
            return ConfigurationMessages.DIR_ERROR_ADD;
        } catch(IllegalArgumentException ex) {
            return ex.getMessage();
        } catch(NoPermissionsException ex2) {
            return ex2.getMessage();
        }
    }
}
