package br.com.azinformatica.usuario.dataprovider;

import br.com.azinformatica.usuario.dataprovider.repository.VerificacaoEmailRepository;
import br.com.azinformatica.usuario.dataprovider.entity.VerificacaoEmailJpa;
import br.com.azinformatica.usuario.domain.entity.VerificacaoEmail;
import br.com.azinformatica.usuario.domain.port.dataprovider.VerificacaoEmailDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VerificacaoEmailDataProviderImpl implements VerificacaoEmailDataProvider {

    @Autowired
    private VerificacaoEmailRepository repository;

    @Override
    public VerificacaoEmail findOne(Long id) {
        VerificacaoEmailJpa found = repository.getOne(id);
        return (Objects.nonNull(found)) ? found.to() : null;
    }

    @Override
    public VerificacaoEmail insert(VerificacaoEmail entity) {
        VerificacaoEmailJpa unsaved = new VerificacaoEmailJpa();
        unsaved.from(entity);

        VerificacaoEmailJpa saved = repository.save(unsaved);
        return saved.to();
    }

    @Override
    public VerificacaoEmail update(VerificacaoEmail entity) {
        return insert(entity);
    }

}
