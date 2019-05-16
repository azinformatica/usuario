package br.com.azinformatica.usuario.domain.port.dataprovider;

import br.com.azinformatica.usuario.domain.entity.ModeloEmail;

public interface ModeloEmailDataProvider {
    ModeloEmail findOne(String chave);
}
