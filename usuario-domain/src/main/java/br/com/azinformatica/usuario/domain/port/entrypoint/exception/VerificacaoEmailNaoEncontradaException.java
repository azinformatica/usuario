package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class VerificacaoEmailNaoEncontradaException extends RuntimeException {
    public VerificacaoEmailNaoEncontradaException() {
        super("Esta verificação não foi encontrada");
    }
}
