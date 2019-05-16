package br.com.azinformatica.usuario.application.factory;

import br.com.azinformatica.usuario.domain.port.dataprovider.VerificacaoEmailDataProvider;
import br.com.azinformatica.usuario.domain.port.entrypoint.usecase.ConcluirVerificacaoEmailUseCase;
import br.com.azinformatica.usuario.domain.usecase.ConcluirVerificacaoEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcluirVerificacaoEmailFactory {

    @Autowired
    private VerificacaoEmailDataProvider verificacaoEmailDataProvider;

    @Bean
    public ConcluirVerificacaoEmailUseCase criarConcluirVerificacaoEmailUseCase() {
        return new ConcluirVerificacaoEmail(verificacaoEmailDataProvider);
    }
}
