package br.com.azinformatica.usuario.domain.port.entrypoint.usecase.base;

import br.com.azinformatica.usuario.domain.port.entrypoint.dto.base.Request;

public interface UseCase<R extends Request> {
    void execute(R request);
}
