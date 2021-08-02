package controllers.Ficheiro;

import domain.Ficheiro.Diretorio.Diretorio;
import domain.Ficheiro.Ficheiro.Ficheiro;
import domain.Ficheiro.FicheiroBase;
import service.DiretorioAtualService;
import utils.ConfigurationMessages;
import utils.NoPermissionsException;

/**
 * Controller que tem como objetivo editar o conteúdo de um ficheiro do filesystem. Tem o serviço de localização e muda o conteudo do ficheiro no diretório atual através do seu nome.
 */
public class EditarConteudoFicheiroController {

    private DiretorioAtualService sv;

    public EditarConteudoFicheiroController(DiretorioAtualService service) {
        this.sv = service;
    }

    public String editarFicheiro(String nomeFicheiro, String conteudos) {
        Diretorio diretorioAtual = this.sv.diretorioAtual;
        try {
            FicheiroBase f = diretorioAtual.devolveFicheiroBase(nomeFicheiro);

            if (f == null) {
                return ConfigurationMessages.FILE_NOT_FOUND;
            }

            if (f.isFile()) {
                Ficheiro ficheiroAtualizar = (Ficheiro) f;
                ficheiroAtualizar.editaConteudos(conteudos);
                return ConfigurationMessages.CONTENT_CHANGED;
            }
            return nomeFicheiro + ConfigurationMessages.NOT_A_FILE;
        } catch (NoPermissionsException ex) {
            return ex.getMessage();
        }
    }
}
