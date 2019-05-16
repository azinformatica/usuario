package br.com.azinformatica.usuario.dataprovider.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@EqualsAndHashCode
public class UsuarioJpa {
    @Id
    private Long id;
    private String nome;
    private String email;
    private String senha;
}
