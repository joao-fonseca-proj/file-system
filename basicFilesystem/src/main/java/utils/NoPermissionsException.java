package utils;

/**
 * Exceção usada para erros de permissão.
 */
public class NoPermissionsException extends Exception {

    public NoPermissionsException(String message) {
        super(message);
    }
}
