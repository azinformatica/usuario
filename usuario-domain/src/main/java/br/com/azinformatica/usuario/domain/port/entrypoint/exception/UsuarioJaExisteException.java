package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class UsuarioJaExisteException extends RuntimeException {
    public UsuarioJaExisteException() {
        super("Não é possível insert um usuário com um email que já foi cadastrado anteriormente");
    }

    public UsuarioJaExisteException(String message) {
        super(message);
    }

    public UsuarioJaExisteException(String message, Throwable cause) {
        super(message, cause);
    }
}
