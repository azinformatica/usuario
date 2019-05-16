package br.com.azinformatica.usuario.utils;

import br.com.azinformatica.usuario.domain.port.utils.TemplateResolver;
import br.com.azinformatica.usuario.domain.entity.ModeloEmail;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TemplateResolverImpl implements TemplateResolver {

    @Override
    public void resolve(ModeloEmail modeloEmail, Map<String, String> variables) {
        // mock
    }
}
