package br.com.azinformatica.usuario.utils;

import br.com.azinformatica.usuario.domain.port.utils.Encriptador;
import br.com.azinformatica.usuario.domain.port.utils.exception.ErroDuranteEncriptacaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Component
public class EncriptadorImpl implements Encriptador {
    @Override
    public String encriptar(String texto) {
        byte[] md5 = toMD5(texto);
        String result = toString(md5);

        log.info("A chave cripotografada é {}", result);

        return result;
    }

    private byte[] toMD5(String texto) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            return algorithm.digest(texto.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ErroDuranteEncriptacaoException(e);
        }
    }

    private String toString(byte[] messageDigest) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }
}
