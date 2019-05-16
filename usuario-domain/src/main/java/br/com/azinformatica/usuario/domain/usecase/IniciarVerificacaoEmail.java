package br.com.azinformatica.usuario.domain.usecase;

import br.com.azinformatica.usuario.domain.entity.Email;
import br.com.azinformatica.usuario.domain.port.dataprovider.ModeloEmailDataProvider;
import br.com.azinformatica.usuario.domain.port.dataprovider.UsuarioDataProvider;
import br.com.azinformatica.usuario.domain.port.dataprovider.VerificacaoEmailDataProvider;
import br.com.azinformatica.usuario.domain.port.entrypoint.exception.ModeloEmailNaoFoiEncontradoException;
import br.com.azinformatica.usuario.domain.port.entrypoint.exception.UsuarioJaExisteException;
import br.com.azinformatica.usuario.domain.port.entrypoint.usecase.IniciarVerificacaoEmailUseCase;
import br.com.azinformatica.usuario.domain.port.utils.EmailSender;
import br.com.azinformatica.usuario.domain.port.utils.Encriptador;
import br.com.azinformatica.usuario.domain.port.utils.TemplateResolver;
import br.com.azinformatica.usuario.domain.entity.ModeloEmail;
import br.com.azinformatica.usuario.domain.entity.VerificacaoEmail;
import br.com.azinformatica.usuario.domain.port.entrypoint.dto.IniciarVerificacaoEmailRequest;

import java.time.LocalDate;
import java.util.Objects;

public class IniciarVerificacaoEmail implements IniciarVerificacaoEmailUseCase {
    private static final String NOME_MODELO_EMAIL = "CONFIRMACAO_DE_EMAIL";
    private VerificacaoEmailDataProvider verificacaoEmailDataProvider;
    private UsuarioDataProvider usuarioDataProvider;
    private ModeloEmailDataProvider modeloEmailDataProvider;
    private Encriptador encriptador;
    private EmailSender emailSender;
    private TemplateResolver templateResolver;

    public IniciarVerificacaoEmail(VerificacaoEmailDataProvider verificacaoEmailDataProvider,
                                   UsuarioDataProvider usuarioDataProvider,
                                   ModeloEmailDataProvider modeloEmailDataProvider,
                                   Encriptador encriptador,
                                   EmailSender emailSender,
                                   TemplateResolver templateResolver) {
        this.verificacaoEmailDataProvider = verificacaoEmailDataProvider;
        this.usuarioDataProvider = usuarioDataProvider;
        this.modeloEmailDataProvider = modeloEmailDataProvider;
        this.encriptador = encriptador;
        this.emailSender = emailSender;
        this.templateResolver = templateResolver;
    }

    @Override
    public void execute(IniciarVerificacaoEmailRequest request) {
        falharSeUsuarioJaExistir(request.getEmailSolicitante());

        VerificacaoEmail verificacaoEmail = VerificacaoEmail.creator().create();
        setFields(verificacaoEmail, request);
        setDefaults(verificacaoEmail);
        setTokenConfirmacao(verificacaoEmail);
        salvar(verificacaoEmail);

        ModeloEmail modeloEmail = buscarModeloEmail();
        falharSeModeloNaoFoiCadastrado(modeloEmail);
        compilarModeloEmail(modeloEmail, verificacaoEmail);

        enviarEmailConfirmacao(modeloEmail);
    }

    private void falharSeUsuarioJaExistir(String email) {
        if (usuarioDataProvider.isExists(email)) {
            throw new UsuarioJaExisteException();
        }
    }

    private void setFields(VerificacaoEmail verificacaoEmail, IniciarVerificacaoEmailRequest request) {
        verificacaoEmail.setNomeSolicitante(request.getNomeSolicitante());
        verificacaoEmail.setEmailSolicitante(request.getEmailSolicitante());
        verificacaoEmail.setProdutoId(request.getProdutoId());
        verificacaoEmail.setUriDestino(request.getUriDestino());
    }

    private void setDefaults(VerificacaoEmail verificacaoEmail) {
        verificacaoEmail.setDataCriacao(LocalDate.now());
    }

    private void setTokenConfirmacao(VerificacaoEmail verificacaoEmail) {
        String segredo = verificacaoEmail.getEmailSolicitante() + verificacaoEmail.getDataCriacao();
        verificacaoEmail.setTokenConfirmacao(encriptador.encriptar(segredo));
    }

    private void salvar(VerificacaoEmail verificacaoEmail) {
        verificacaoEmail = this.verificacaoEmailDataProvider.insert(verificacaoEmail);
    }

    private ModeloEmail buscarModeloEmail() {
        return this.modeloEmailDataProvider.findOne(NOME_MODELO_EMAIL);
    }

    private void falharSeModeloNaoFoiCadastrado(ModeloEmail modeloEmail) {
        if (Objects.isNull(modeloEmail)) {
            throw new ModeloEmailNaoFoiEncontradoException();
        }
    }

    private void compilarModeloEmail(ModeloEmail modeloEmail, VerificacaoEmail verificacaoEmail) {
        modeloEmail.setDestinatarios(verificacaoEmail.getEmailSolicitante());
        this.templateResolver.resolve(modeloEmail, verificacaoEmail.toVariaveis());
    }

    private void enviarEmailConfirmacao(ModeloEmail modeloEmail) {
        Email email = modeloEmail.criarEmailDesteModelo();
        this.emailSender.send(email);
    }

}
