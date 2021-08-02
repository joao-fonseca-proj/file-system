package controllers;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo mostrar o nome dos ficheiros de um diretório no filesystem(lista de ficheiros). Tem o serviço de localização e procura o diretório através do seu nome.
 */
public class MostraConteudosController {

    private DiretorioAtualService service;

    public MostraConteudosController(DiretorioAtualService sv) {
        this.service = sv;
    }

    public String mostraConteudosFicheiro(String nomeFicheiro) {
        Diretorio diretorioAtual = this.service.diretorioAtual;
        try {
            FicheiroBase f = diretorioAtual.devolveFicheiroBase(nomeFicheiro);
            if (f == null) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }
            if (f.isFile()) {
                return f.devolveConteudos();
            }
            return ConfigurationMessages.NOT_A_FILE;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }

    public String mostraConteudosDiretorio(String nomeFicheiro) {
        Diretorio diretorioAtual = this.service.diretorioAtual;
        try {
            FicheiroBase f = diretorioAtual.devolveFicheiroBase(nomeFicheiro);
            if (f == null) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }
            if (f.isDiretorio()) {
                return f.devolveConteudos();
            }
            return nomeFicheiro + ConfigurationMessages.NOT_A_DIR;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
