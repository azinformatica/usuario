package br.com.azinformatica.usuario.dataprovider.repository;

import br.com.azinformatica.usuario.dataprovider.entity.ModeloEmailJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloEmailRepository extends JpaRepository<ModeloEmailJpa, Long> {

    ModeloEmailJpa findByChave(String chave);
}
