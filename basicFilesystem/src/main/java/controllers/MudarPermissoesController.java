package controllers;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo mudar as permissões dos ficheiros de um diretório no filesystem(lista de ficheiros). Tem o serviço de localização e procura o ficheiro através do seu nome nos subficheiros.
 */
public class MudarPermissoesController {

    private DiretorioAtualService sv;

    public MudarPermissoesController(DiretorioAtualService service) {
        this.sv = service;
    }


    public String mudarPermissoes(boolean read, boolean write, boolean execute, String nomeFicheiro) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase ficheiroAtualizar = diretorioAtual.devolveFicheiroBase(nomeFicheiro);
            if (ficheiroAtualizar == null) {
                return ConfigurationMessages.NOT_FOUND;
            }

            ficheiroAtualizar.mudarPermissoesRWX(read, write, execute);
            return ConfigurationMessages.PERMISSIONS_CHANGED + nomeFicheiro;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
