package domain.Ficheiro;


import utils.DDD.ValueObject;

/**
 * Classe auxiliar que vai guardar as várias permissões para as várias ações - write,read,execute,del
 */
public class Permissoes implements ValueObject {

    /**
     * Read
     */
    private Permissao read;
    /**
     * Write
     */
    private Permissao write;
    /**
     * Execute
     */
    private Permissao execute;
    /**
     * Delete
     */
    private Permissao delete;

    public Permissoes(boolean read, boolean write, boolean execute, boolean del) {
        this.read = new Permissao(PermissoesEnum.Read,read);
        this.write = new Permissao(PermissoesEnum.Write, write);
        this.execute = new Permissao(PermissoesEnum.Execute, execute);
        this.delete = new Permissao(PermissoesEnum.Delete, del);
    }
    // Default
    public Permissoes() {
        this.read = new Permissao(PermissoesEnum.Read,true);
        this.write = new Permissao(PermissoesEnum.Write, true);
        this.execute = new Permissao(PermissoesEnum.Execute, false);
        this.delete = new Permissao(PermissoesEnum.Delete, true);
    }
    /**
     * Devolve true se tiver permissões de leitura
     * @return boolean
     */
    public boolean permissoesRead() {
        return read.autorizacao();
    }
    /**
     * Devolve true se tiver permissões de escrita
     * @return boolean
     */
    public boolean permissoesWrite() {
        return write.autorizacao();
    }
    /**
     * Devolve true se tiver permissões de executar
     * @return boolean
     */
    public boolean permissoesExecute() {
        return execute.autorizacao();
    }
    /**
     * Devolve true se tiver permissões de apagar
     * @return boolean
     */
    public boolean permissoesDelete() {
        return delete.autorizacao();
    }

    /**
     * ENUM permissões
     */
    public enum PermissoesEnum {
        Read,
        Write,
        Execute,
        Delete
    }

    /**
     * Muda as permissões de read,write e execute
     * @param read bool
     * @param write bool
     * @param execute bool
     */
    public void mudarPermissoes(boolean read, boolean write, boolean execute) {
        this.read = new Permissao(PermissoesEnum.Read, read);
        this.write = new Permissao(PermissoesEnum.Write, write);
        this.delete = new Permissao(PermissoesEnum.Execute, execute);
    }
}
