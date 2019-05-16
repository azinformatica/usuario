package br.com.azinformatica.usuario.entrypoint.factory;

import br.com.azinformatica.usuario.domain.port.entrypoint.dto.ConcluirVerificacaoEmailRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConcluirVerificacaoEmailRequestFactory implements RequestFactory<ConcluirVerificacaoEmailRequest> {

    @Override
    public ConcluirVerificacaoEmailRequest create(Map<String, Object> body) {
        ConcluirVerificacaoEmailRequest request = new ConcluirVerificacaoEmailRequest();
        request.setId(Long.parseLong((String) body.get("id")));
        request.setTokenConfirmacao((String) body.get("tokenConfirmacao"));
        return request;
    }
}
