package br.com.azinformatica.usuario.utils;

import br.com.azinformatica.usuario.domain.entity.Email;
import br.com.azinformatica.usuario.domain.port.utils.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailSenderImpl implements EmailSender {

    @Autowired
    public JavaMailSender javaMailSender;

    @Async
    @Override
    public void send(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getRemetente());
        message.setTo(email.getDestinatarios());
        message.setSubject(email.getAssunto());
        message.setText(email.getCorpo());
        javaMailSender.send(message);

        log.info("Email enviado {}", email.toString());
    }
}
