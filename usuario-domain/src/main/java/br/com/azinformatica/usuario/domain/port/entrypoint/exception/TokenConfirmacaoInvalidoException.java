package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class TokenConfirmacaoInvalidoException extends RuntimeException {
    public TokenConfirmacaoInvalidoException() {
        super("O token de confirmacao informado não é o mesmo");
    }
}
