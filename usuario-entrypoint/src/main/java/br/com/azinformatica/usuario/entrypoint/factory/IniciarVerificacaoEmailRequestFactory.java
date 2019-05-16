package br.com.azinformatica.usuario.entrypoint.factory;

import br.com.azinformatica.usuario.domain.port.entrypoint.dto.IniciarVerificacaoEmailRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class IniciarVerificacaoEmailRequestFactory implements RequestFactory<IniciarVerificacaoEmailRequest> {

    @Override
    public IniciarVerificacaoEmailRequest create(Map<String, Object> body) {
        IniciarVerificacaoEmailRequest request = new IniciarVerificacaoEmailRequest();
        request.setNomeSolicitante((String) body.get("nomeSolicitante"));
        request.setEmailSolicitante((String) body.get("emailSolicitante"));
        request.setProdutoId(Long.parseLong((String) body.get("produtoId")));
        request.setUriDestino((String) body.get("uriDestino"));
        return request;
    }
}
