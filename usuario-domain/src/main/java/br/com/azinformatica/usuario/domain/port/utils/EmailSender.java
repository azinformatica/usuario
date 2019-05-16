package br.com.azinformatica.usuario.domain.port.utils;

import br.com.azinformatica.usuario.domain.entity.Email;

public interface EmailSender {

    void send(Email email);

}
