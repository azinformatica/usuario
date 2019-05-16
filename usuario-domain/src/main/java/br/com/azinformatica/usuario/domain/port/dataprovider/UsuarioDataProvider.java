package br.com.azinformatica.usuario.domain.port.dataprovider;

public interface UsuarioDataProvider {
    boolean isExists(String username);
}
