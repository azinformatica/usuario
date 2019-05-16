package br.com.azinformatica.usuario.entrypoint;

import br.com.azinformatica.usuario.domain.port.entrypoint.dto.ConcluirVerificacaoEmailRequest;
import br.com.azinformatica.usuario.domain.port.entrypoint.dto.IniciarVerificacaoEmailRequest;
import br.com.azinformatica.usuario.domain.port.entrypoint.usecase.ConcluirVerificacaoEmailUseCase;
import br.com.azinformatica.usuario.domain.port.entrypoint.usecase.IniciarVerificacaoEmailUseCase;
import br.com.azinformatica.usuario.entrypoint.factory.ConcluirVerificacaoEmailRequestFactory;
import br.com.azinformatica.usuario.entrypoint.factory.IniciarVerificacaoEmailRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/emails/verificacao")
public class VerificacaoEmailController {

    @Autowired
    private IniciarVerificacaoEmailUseCase iniciarVerificacaoEmailUseCase;

    @Autowired
    private IniciarVerificacaoEmailRequestFactory iniciarVerificacaoEmailRequestFactory;

    @Autowired
    private ConcluirVerificacaoEmailUseCase concluirVerificacaoEmailUseCase;

    @Autowired
    private ConcluirVerificacaoEmailRequestFactory concluirVerificacaoEmailRequestFactory;

    @PostMapping
    public ResponseEntity<?> iniciar(@RequestBody Map<String, Object> body) {
        IniciarVerificacaoEmailRequest request = iniciarVerificacaoEmailRequestFactory.create(body);
        iniciarVerificacaoEmailUseCase.execute(request);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> concluir(@RequestBody Map<String, Object> body) {
        ConcluirVerificacaoEmailRequest request = concluirVerificacaoEmailRequestFactory.create(body);
        concluirVerificacaoEmailUseCase.execute(request);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
