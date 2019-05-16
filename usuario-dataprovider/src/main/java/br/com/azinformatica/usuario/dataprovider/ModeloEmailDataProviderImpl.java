package br.com.azinformatica.usuario.dataprovider;

import br.com.azinformatica.usuario.dataprovider.entity.ModeloEmailJpa;
import br.com.azinformatica.usuario.dataprovider.repository.ModeloEmailRepository;
import br.com.azinformatica.usuario.domain.entity.ModeloEmail;
import br.com.azinformatica.usuario.domain.port.dataprovider.ModeloEmailDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ModeloEmailDataProviderImpl implements ModeloEmailDataProvider {

    @Autowired
    private ModeloEmailRepository repository;

    @Override
    public ModeloEmail findOne(String chave) {
        ModeloEmailJpa modeloJpa = repository.findByChave(chave);
        if (Objects.nonNull(modeloJpa)) {
            return modeloJpa.to();
        }
        return null;
    }
}
