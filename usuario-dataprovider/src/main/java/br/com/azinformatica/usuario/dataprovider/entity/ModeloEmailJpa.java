package br.com.azinformatica.usuario.dataprovider.entity;

import br.com.azinformatica.usuario.domain.entity.ModeloEmail;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "MODELO_EMAIL")
@SequenceGenerator(name = "SEQ_MODELO_EMAIL", sequenceName = "SEQ_MODELO_EMAIL")
public class ModeloEmailJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODELO_EMAIL")
    private Long id;
    private String chave;
    private String remetente;
    private String assunto;
    private String corpo;

    public ModeloEmail to() {
        return ModeloEmail.creator()
                .chave(this.chave)
                .remetente(this.remetente)
                .assunto(this.assunto)
                .corpo(this.corpo)
                .create();
    }
}
