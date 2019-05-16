package br.com.azinformatica.usuario.domain.port.entrypoint.exception;

public class ModeloEmailNaoFoiEncontradoException extends RuntimeException {
    public ModeloEmailNaoFoiEncontradoException() {
        super("O modelo de email não foi encontrado");
    }
}
