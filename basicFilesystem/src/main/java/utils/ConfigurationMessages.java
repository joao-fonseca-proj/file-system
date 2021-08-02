package utils;

/**
 * Mensagens de configuração.
 */
public class ConfigurationMessages {

    // COMANDOS
    public static final String LS = "ls";
    public static final String LSDETAILS = "lsdetails";
    public static final String CHMOD = "chmod";
    public static final String MKDIR ="mkdir";
    public static final String TOUCH = "touch";
    public static final String CAT ="cat";
    public static final String CD = "cd";
    public static final String RM = "rm";
    public static final String RMDIR ="rmdir";
    public static final String COPY = "copy";
    public static final String MOVE ="move";
    public static final String EDIT_CONTENTS = "editcontent";

    // NOT FOUND
    public static final String DIR_NOT_FOUND = "Diretório não encontrado.";
    public static final String FILE_NOT_FOUND = "Ficheiro não encontrado.";
    public static final String NOT_FOUND = "Objeto não encontrado.";

    // TYPE ERROR
    public static final String NOT_A_DIR = " não é um diretório.";
    public static final String NOT_A_FILE = " não é um ficheiro.";
    public static final String IS_ROOT = "Erro - o diretório atual é a root";


    // CREATE
    public static final String DIR_ADDED = "Diretório criado em  ";
    public static final String DIR_ERROR_ADD = "Erro ao criar diretório.";
    public static final String FILE_ADDED = "Ficheiro criado em ";
    public static final String FILE_ERROR_ADD = "Erro ao criar ficheiro";
    public static final String DIR_REMOVED = "Diretório apagado";
    public static final String ERROR_DIR_REMOVED = "Erro ao apagar diretório.";
    public static final String FILE_REMOVED = "Ficheiro apagado";
    public static final String ERROR_FILE_REMOVED = "Erro ao apagar ficheiro.";
    public static final String EXISTENT_FILE = "Ficheiro já existe no diretório de destino";

    // COMMAND ERRORS
    public static final String CAT_ERROR_FILE = "cat não funciona para diretórios. Try ls $diretorio.";
    public static final String DIR_HAS_FILES ="O diretório tem ficheiros, não pode ser apagado.";

    // ON CHANGE
    public static final String DIR_CHANGE = "Diretório atual mudado.";
    public static final String PERMISSIONS_CHANGED = "Permissões do ficheiro mudadas: ";
    public static final String DIRECTORY_CHANGE = "Diretório mudado.";
    public static final String CONTENT_CHANGED = "Contéudo mudado.";

    // COPY or MOVES
    public static final String FILE_COPIED = " copiado para ";
    public static final String FILE_MOVED =  " movida para ";

    // PERMISSIONS

    public static final String NO_READ_PERM = "Não tem permissões de leitura";
    public static final String NO_WRITE_PERM ="Não tem permissões de escrita";
}
