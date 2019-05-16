package br.com.azinformatica.usuario.entrypoint.factory;

import br.com.azinformatica.usuario.domain.port.entrypoint.dto.base.Request;

import java.util.Map;

public interface RequestFactory<R extends Request> {
    R create(Map<String, Object> body);
}
