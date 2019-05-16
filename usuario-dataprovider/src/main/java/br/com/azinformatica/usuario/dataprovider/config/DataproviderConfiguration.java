package br.com.azinformatica.usuario.dataprovider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.azinformatica.usuario.dataprovider.repository")
public class DataproviderConfiguration {
}
