package service;

import controllers.Diretorio.ApagarDiretorioController;
import controllers.Diretorio.CriaDiretorioController;
import controllers.Diretorio.MudaDiretorioController;
import controllers.Diretorio.MudarDiretorioAnteriorController;
import controllers.Ficheiro.EditarConteudoFicheiroController;
import controllers.MostraConteudosController;
import controllers.Diretorio.MostraConteudosDetalhadosController;
import controllers.MudarPermissoesController;
import controllers.Ficheiro.*;
import controllers.Diretorio.MostraFicheirosDiretorioAtualController;
import utils.ConfigurationMessages;

/**
 * Implementação de um interpretador de comandos que transforma a informação da UI em controllers.
 */
public class InterpretadorComandos {

    private static String SPACE_DELIMITER = " ";
    /**
     * Serviço localizador.
     */
    private DiretorioAtualService service;

    /**
     * Construtor completo
     * @param sv serviço
     */
    public InterpretadorComandos(DiretorioAtualService sv) {
        this.service = sv;
    }

    /**
     * Transforma o comando numa ação com o controller - devolve mensagem de sucesso.
     * @param comando comando
     * @return mensagem de sucesso
     */
    public String comandoToAction(String comando) {
        String[] split = comando.split(SPACE_DELIMITER);

        switch(split.length) {
            case 1:
                if(split[0].equalsIgnoreCase(ConfigurationMessages.LS)) {
                    return new MostraFicheirosDiretorioAtualController(this.service).mostraConteudos();
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.LSDETAILS)) {
                    return new MostraConteudosDetalhadosController(this.service).mostraConteudosDetalhadosAtual();
                }
                break;
            case 2:
                if(split[0].equalsIgnoreCase(ConfigurationMessages.LS)) {
                    return new MostraConteudosController(this.service).mostraConteudosDiretorio(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.LSDETAILS)) {
                    return new MostraConteudosDetalhadosController(this.service).mostraConteudosDetalhados(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.TOUCH)) {
                    return new CriaFicheiroController(this.service).criaFicheiro(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.CAT)) {
                    return new MostraConteudosController(this.service).mostraConteudosFicheiro(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.MKDIR)) {
                    return new CriaDiretorioController(this.service).criaDiretorio(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.CD) && !split[1].equalsIgnoreCase("..")) {
                    return new MudaDiretorioController(this.service).mudaDiretorio(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.CD) && split[1].equalsIgnoreCase("..")) {
                    return new MudarDiretorioAnteriorController(this.service).mudaDiretorioAnterior();
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.RMDIR)) {
                    return new ApagarDiretorioController(this.service).apagarDiretorio(split[1]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.RM)) {
                    return new ApagarFicheiroController(this.service).apagaFicheiro(split[1]);
                }
                break;
            case 3:
                if(split[0].equalsIgnoreCase(ConfigurationMessages.COPY)) {
                    return new CopiarFicheiroController(this.service).copiarFicheiro(split[1], split[2]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.MOVE)) {
                    return new MoverFicheiroController(this.service).moverFicheiro(split[1], split[2]);
                }
                if(split[0].equalsIgnoreCase(ConfigurationMessages.EDIT_CONTENTS)) {
                    return new EditarConteudoFicheiroController(this.service).editarFicheiro(split[1], split[2]);
                }
                break;
            case 5:
                if(split[0].equalsIgnoreCase(ConfigurationMessages.CHMOD)) {
                    boolean readB = true;
                    boolean writeB = true;
                    boolean executeB = true;
                    String[] read = split[1].split("=");
                    if(read[0].equals("read")) {
                        readB = Boolean.parseBoolean(split[1]);
                    }
                    String[] write = split[2].split("=");
                    if(write[0].equals("write")) {
                        writeB = Boolean.parseBoolean(write[1]);
                    }
                    String[] execute = split[3].split("=");
                    if(execute[0].equals("execute")) {
                        executeB = Boolean.parseBoolean(execute[1]);
                    }
                    return new MudarPermissoesController(this.service).mudarPermissoes(readB, writeB, executeB,split[4]);
                }
        }
        return "Comando não reconhecido";
    }
}
