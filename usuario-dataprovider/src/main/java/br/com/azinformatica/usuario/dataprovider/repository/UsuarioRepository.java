package br.com.azinformatica.usuario.dataprovider.repository;

import br.com.azinformatica.usuario.dataprovider.entity.UsuarioJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioJpa, Long> {
    int countByEmail(String email);
}
