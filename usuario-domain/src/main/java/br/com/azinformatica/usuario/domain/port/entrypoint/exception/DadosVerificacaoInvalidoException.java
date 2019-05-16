package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class DadosVerificacaoInvalidoException extends RuntimeException {
    public DadosVerificacaoInvalidoException(String message) {
        super(message);
    }

    public DadosVerificacaoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
