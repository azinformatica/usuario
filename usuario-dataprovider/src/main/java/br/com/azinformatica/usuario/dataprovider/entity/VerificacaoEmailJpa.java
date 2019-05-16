package br.com.azinformatica.usuario.dataprovider.entity;

import br.com.azinformatica.usuario.domain.entity.VerificacaoEmail;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VERIFICACAO_EMAIL")
@SequenceGenerator(name = "SEQ_VERIFICACAO_EMAIL", sequenceName = "SEQ_VERIFICACAO_EMAIL")
public class VerificacaoEmailJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_VERIFICACAO_EMAIL")
    private Long id;
    private String nomeSolicitante;
    private String emailSolicitante;
    private Long produtoId;
    private String uriDestino;
    private LocalDate dataCriacao;
    private String tokenConfirmacao;
    private Boolean concluida;

    public void from(VerificacaoEmail verificacaoEmail) {
        this.id = verificacaoEmail.getId();
        this.nomeSolicitante = verificacaoEmail.getNomeSolicitante();
        this.emailSolicitante = verificacaoEmail.getEmailSolicitante();
        this.produtoId = verificacaoEmail.getProdutoId();
        this.uriDestino = verificacaoEmail.getUriDestino();
        this.dataCriacao = verificacaoEmail.getDataCriacao();
        this.tokenConfirmacao = verificacaoEmail.getTokenConfirmacao();
        this.concluida = verificacaoEmail.getConcluida();
    }

    public VerificacaoEmail to() {
        return VerificacaoEmail.creator()
                .id(id)
                .nomeSolicitante(nomeSolicitante)
                .emailSolicitante(emailSolicitante)
                .produtoId(produtoId)
                .uriDestino(uriDestino)
                .dataCriacao(dataCriacao)
                .tokenConfirmacao(tokenConfirmacao)
                .concluida(concluida)
                .create();
    }
}
