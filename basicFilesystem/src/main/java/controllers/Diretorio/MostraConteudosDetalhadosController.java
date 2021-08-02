package controllers.Diretorio;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;
/**
 * Controller que tem como objetivo mostrar os contéudos detalhados de um diretório no filesystem(lista de ficheiros). Tem o serviço de localização e procura o diretório através do seu nome.
 */
public class MostraConteudosDetalhadosController {

    private DiretorioAtualService sv;

    public MostraConteudosDetalhadosController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String mostraConteudosDetalhados(String nomeFicheiro) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase f = diretorioAtual.devolveFicheiroBase(nomeFicheiro);
            if (f == null) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }
            return f.devolveConteudosDetalhados();
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }

    public String mostraConteudosDetalhadosAtual() {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            return diretorioAtual.devolveConteudosDetalhados();
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
