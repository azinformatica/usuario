package br.com.azinformatica.usuario.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class VerificacaoEmail {
    private static final Integer VALIDADE_EM_DIAS = 3;
    private Long id;
    private String nomeSolicitante;
    private String emailSolicitante;
    private Long produtoId;
    private String uriDestino;
    private LocalDate dataCriacao;
    private String tokenConfirmacao;
    private Boolean concluida;

    private VerificacaoEmail(Long id, String nomeSolicitante, String emailSolicitante, Long produtoId, String uriDestino, LocalDate dataCriacao, String tokenConfirmacao, Boolean concluida) {
        this.id = id;
        this.nomeSolicitante = nomeSolicitante;
        this.emailSolicitante = emailSolicitante;
        this.produtoId = produtoId;
        this.uriDestino = uriDestino;
        this.dataCriacao = dataCriacao;
        this.tokenConfirmacao = tokenConfirmacao;
        this.concluida = concluida;
    }

    public boolean isExpirada() {
        Period periodo = Period.between(this.dataCriacao, LocalDate.now());
        Integer diasQuePassaram = periodo.getDays();
        return (diasQuePassaram > VALIDADE_EM_DIAS);
    }

    public boolean isConcluida() {
        return (Objects.nonNull(this.concluida)) ? this.concluida : false;
    }

    public Map<String, String> toVariaveis() {
        Map<String, String> variaveis = new HashMap<>();
        variaveis.put("NOME_SOLICITANTE", nomeSolicitante);
        variaveis.put("EMAIL_SOLICITANTE", emailSolicitante);
        variaveis.put("PRODUTO_ID", Long.toString(produtoId));
        variaveis.put("URI_DESTINO", uriDestino);
        variaveis.put("DATA_CRIACAO", dataCriacao.toString());
        variaveis.put("TOKEN_CONFIRMACAO", tokenConfirmacao);
        return variaveis;
    }

    public static VerificacaoEmailCreator creator() {
        return new VerificacaoEmailCreator();
    }

    public static class VerificacaoEmailCreator {
        private Long id;
        private String nomeSolicitante;
        private String emailSolicitante;
        private Long produtoId;
        private String uriDestino;
        private LocalDate dataCriacao;
        private String tokenConfirmacao;
        private Boolean concluida;

        public VerificacaoEmailCreator id(final Long id) {
            this.id = id;
            return this;
        }

        public VerificacaoEmailCreator nomeSolicitante(final String nomeSolicitante) {
            this.nomeSolicitante = nomeSolicitante;
            return this;
        }

        public VerificacaoEmailCreator emailSolicitante(final String emailSolicitante) {
            this.emailSolicitante = emailSolicitante;
            return this;
        }

        public VerificacaoEmailCreator produtoId(final Long produtoId) {
            this.produtoId = produtoId;
            return this;
        }

        public VerificacaoEmailCreator uriDestino(final String uriDestino) {
            this.uriDestino = uriDestino;
            return this;
        }

        public VerificacaoEmailCreator dataCriacao(final LocalDate dataCriacao) {
            this.dataCriacao = dataCriacao;
            return this;
        }

        public VerificacaoEmailCreator tokenConfirmacao(final String tokenConfirmacao) {
            this.tokenConfirmacao = tokenConfirmacao;
            return this;
        }

        public VerificacaoEmailCreator concluida(final Boolean concluida) {
            this.concluida = concluida;
            return this;
        }

        public VerificacaoEmail create() {
            return new VerificacaoEmail(id, nomeSolicitante, emailSolicitante, produtoId, uriDestino, dataCriacao, tokenConfirmacao, concluida);
        }
    }
}
