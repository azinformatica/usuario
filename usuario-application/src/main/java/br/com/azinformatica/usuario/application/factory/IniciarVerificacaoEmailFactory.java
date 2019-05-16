package br.com.azinformatica.usuario.application.factory;

import br.com.azinformatica.usuario.domain.port.dataprovider.ModeloEmailDataProvider;
import br.com.azinformatica.usuario.domain.port.dataprovider.UsuarioDataProvider;
import br.com.azinformatica.usuario.domain.port.dataprovider.VerificacaoEmailDataProvider;
import br.com.azinformatica.usuario.domain.port.entrypoint.usecase.IniciarVerificacaoEmailUseCase;
import br.com.azinformatica.usuario.domain.port.utils.EmailSender;
import br.com.azinformatica.usuario.domain.port.utils.Encriptador;
import br.com.azinformatica.usuario.domain.port.utils.TemplateResolver;
import br.com.azinformatica.usuario.domain.usecase.IniciarVerificacaoEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IniciarVerificacaoEmailFactory {

    @Autowired
    private VerificacaoEmailDataProvider verificacaoEmailDataProvider;
    @Autowired
    private UsuarioDataProvider usuarioDataProvider;
    @Autowired
    private ModeloEmailDataProvider modeloEmailDataProvider;
    @Autowired
    private Encriptador encriptador;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private TemplateResolver templateResolver;

    @Bean
    public IniciarVerificacaoEmailUseCase criarIniciarVerificacaoEmailUseCase() {
        return new IniciarVerificacaoEmail(verificacaoEmailDataProvider,
                usuarioDataProvider, modeloEmailDataProvider, encriptador, emailSender, templateResolver);
    }
}
