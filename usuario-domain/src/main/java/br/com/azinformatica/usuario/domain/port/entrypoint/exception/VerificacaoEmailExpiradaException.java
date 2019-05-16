package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class VerificacaoEmailExpiradaException extends RuntimeException {
    public VerificacaoEmailExpiradaException() {
        super("A verificação de email foi expirada e não pode mais ser usada");
    }
}
