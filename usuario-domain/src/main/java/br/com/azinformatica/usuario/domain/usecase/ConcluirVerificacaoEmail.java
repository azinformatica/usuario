package br.com.azinformatica.usuario.domain.usecase;

import br.com.azinformatica.usuario.domain.port.dataprovider.VerificacaoEmailDataProvider;
import br.com.azinformatica.usuario.domain.port.entrypoint.exception.TokenConfirmacaoInvalidoException;
import br.com.azinformatica.usuario.domain.port.entrypoint.exception.VerificacaoEmailExpiradaException;
import br.com.azinformatica.usuario.domain.port.entrypoint.exception.VerificacaoEmailJaFoiUsadaException;
import br.com.azinformatica.usuario.domain.port.entrypoint.exception.VerificacaoEmailNaoEncontradaException;
import br.com.azinformatica.usuario.domain.port.entrypoint.usecase.ConcluirVerificacaoEmailUseCase;
import br.com.azinformatica.usuario.domain.entity.VerificacaoEmail;
import br.com.azinformatica.usuario.domain.port.entrypoint.dto.ConcluirVerificacaoEmailRequest;

import java.util.Objects;

public class ConcluirVerificacaoEmail implements ConcluirVerificacaoEmailUseCase {
    private VerificacaoEmailDataProvider verificacaoEmailDataProvider;

    public ConcluirVerificacaoEmail(VerificacaoEmailDataProvider verificacaoEmailDataProvider) {
        this.verificacaoEmailDataProvider = verificacaoEmailDataProvider;
    }

    @Override
    public void execute(ConcluirVerificacaoEmailRequest request) {
        VerificacaoEmail verificacaoEmail = this.verificacaoEmailDataProvider.findOne(request.getId());

        falharSeVerificacaoEmailNaoForEncontrada(verificacaoEmail);
        falharSeTokenConfirmacaoForInvalido(verificacaoEmail, request.getTokenConfirmacao());
        falharSeVerificacaoEmailJaFoiUsadaOuJaFoiExpirada(verificacaoEmail);
        falharSeVerificacaoEmailJaFoiUsada(verificacaoEmail);

        verificacaoEmail.setConcluida(true);
        this.verificacaoEmailDataProvider.update(verificacaoEmail);
    }

    private void falharSeVerificacaoEmailNaoForEncontrada(VerificacaoEmail verificacaoEmail) {
        if (Objects.isNull(verificacaoEmail)) {
            throw new VerificacaoEmailNaoEncontradaException();
        }
    }

    private void falharSeTokenConfirmacaoForInvalido(VerificacaoEmail verificacaoEmail, String tokenConfirmacao) {
        if (! verificacaoEmail.getTokenConfirmacao().equals(tokenConfirmacao)) {
            throw new TokenConfirmacaoInvalidoException();
        }
    }

    private void falharSeVerificacaoEmailJaFoiUsadaOuJaFoiExpirada(VerificacaoEmail verificacaoEmail) {
        if (verificacaoEmail.isExpirada()) {
            throw new VerificacaoEmailExpiradaException();
        }
    }

    private void falharSeVerificacaoEmailJaFoiUsada(VerificacaoEmail verificacaoEmail) {
        if (verificacaoEmail.isConcluida()) {
            throw new VerificacaoEmailJaFoiUsadaException();
        }
    }
}
