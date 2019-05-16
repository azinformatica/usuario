package br.com.azinformatica.usuario.domain.port.dataprovider;

import br.com.azinformatica.usuario.domain.entity.VerificacaoEmail;

public interface VerificacaoEmailDataProvider {

    VerificacaoEmail insert(VerificacaoEmail verificacaoEmail);

    VerificacaoEmail findOne(Long id);

    VerificacaoEmail update(VerificacaoEmail verificacaoEmail);
}
