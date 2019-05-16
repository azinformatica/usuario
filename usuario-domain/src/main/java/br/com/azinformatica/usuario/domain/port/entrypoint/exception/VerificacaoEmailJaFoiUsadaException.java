package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class VerificacaoEmailJaFoiUsadaException extends RuntimeException {
    public VerificacaoEmailJaFoiUsadaException() {
        super("A verificação de email já foi usada anteriormente");
    }
}
