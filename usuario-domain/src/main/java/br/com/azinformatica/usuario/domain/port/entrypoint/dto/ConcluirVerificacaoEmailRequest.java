package br.com.azinformatica.usuario.domain.port.entrypoint.dto;

import br.com.azinformatica.usuario.domain.port.entrypoint.dto.base.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConcluirVerificacaoEmailRequest implements Request {
    private Long id;
    private String tokenConfirmacao;
}
