package br.com.azinformatica.usuario.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloEmail {
    private String chave;
    private String remetente;
    private String destinatarios;
    private String assunto;
    private String corpo;

    private ModeloEmail(String chave, String remetente, String destinatarios, String assunto, String corpo) {
        this.chave = chave;
        this.remetente = remetente;
        this.destinatarios = destinatarios;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public Email criarEmailDesteModelo() {
        return Email.creator()
                .remetente(this.remetente)
                .destinatarios(this.destinatarios)
                .assunto(this.assunto)
                .corpo(this.corpo)
                .create();
    }

    public static ModeloEmailCreator creator() {
        return new ModeloEmailCreator();
    }

    public static class ModeloEmailCreator {
        private String chave;
        private String remetente;
        private String destinatarios;
        private String assunto;
        private String corpo;

        public ModeloEmailCreator chave(final String chave) {
            this.chave = chave;
            return this;
        }

        public ModeloEmailCreator remetente(final String remetente) {
            this.remetente = remetente;
            return this;
        }

        public ModeloEmailCreator destinatarios(final String destinatarios) {
            this.destinatarios = destinatarios;
            return this;
        }

        public ModeloEmailCreator assunto(final String assunto) {
            this.assunto = assunto;
            return this;
        }

        public ModeloEmailCreator corpo(final String corpo) {
            this.corpo = corpo;
            return this;
        }

        public ModeloEmail create() {
            return new ModeloEmail(chave, remetente, destinatarios, assunto, corpo);
        }
    }
}
