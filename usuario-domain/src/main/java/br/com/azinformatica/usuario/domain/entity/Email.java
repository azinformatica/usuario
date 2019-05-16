package br.com.azinformatica.usuario.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Email {
    private String remetente;
    private String destinatarios;
    private String assunto;
    private String corpo;

    private Email(String remetente, String destinatarios, String assunto, String corpo) {
        this.remetente = remetente;
        this.destinatarios = destinatarios;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public static EmailCreator creator() {
        return new EmailCreator();
    }

    public static class EmailCreator {
        private String remetente;
        private String destinatarios;
        private String assunto;
        private String corpo;

        public EmailCreator remetente(final String remetente) {
            this.remetente = remetente;
            return this;
        }

        public EmailCreator destinatarios(final String destinatarios) {
            this.destinatarios = destinatarios;
            return this;
        }

        public EmailCreator assunto(final String assunto) {
            this.assunto = assunto;
            return this;
        }

        public EmailCreator corpo(final String corpo) {
            this.corpo = corpo;
            return this;
        }

        public Email create() {
            return new Email(remetente, destinatarios, assunto, corpo);
        }
    }
}
