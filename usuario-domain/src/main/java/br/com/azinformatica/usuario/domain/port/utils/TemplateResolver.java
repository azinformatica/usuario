package br.com.azinformatica.usuario.domain.port.utils;

import br.com.azinformatica.usuario.domain.entity.ModeloEmail;

import java.util.Map;

public interface TemplateResolver {

    void resolve(ModeloEmail modeloEmail, Map<String, String> variables);

}
