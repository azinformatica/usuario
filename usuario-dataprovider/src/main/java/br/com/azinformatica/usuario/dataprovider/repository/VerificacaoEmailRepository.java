package br.com.azinformatica.usuario.dataprovider.repository;

import br.com.azinformatica.usuario.dataprovider.entity.VerificacaoEmailJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificacaoEmailRepository extends JpaRepository<VerificacaoEmailJpa, Long> {
}
