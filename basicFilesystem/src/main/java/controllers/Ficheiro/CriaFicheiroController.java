package controllers.Ficheiro;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.Ficheiro.Ficheiro;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo criar um ficheiro no diretório do filesystem. Tem o serviço de localização e cria o ficheiro no diretório atual através do seu nome.
 */
public class CriaFicheiroController {

    private DiretorioAtualService sv;

    public CriaFicheiroController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String criaFicheiro(String nomeFicheiro) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            Ficheiro f = new Ficheiro(nomeFicheiro, 15);
            if (diretorioAtual.adicionarFicheiro(f)) {
                return ConfigurationMessages.FILE_ADDED + diretorioAtual.nome();
            }
            return ConfigurationMessages.FILE_ERROR_ADD;
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        } catch (NoPermissionsException ex2) {
            return ex2.getMessage();
        }
    }
}
