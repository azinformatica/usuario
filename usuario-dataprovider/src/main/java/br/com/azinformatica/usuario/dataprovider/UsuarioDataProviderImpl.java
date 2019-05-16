package br.com.azinformatica.usuario.dataprovider;

import br.com.azinformatica.usuario.dataprovider.repository.UsuarioRepository;
import br.com.azinformatica.usuario.domain.port.dataprovider.UsuarioDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDataProviderImpl implements UsuarioDataProvider {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public boolean isExists(String username) {
        return repository.countByEmail(username) > 0;
    }
}
