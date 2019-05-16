# API de exemplo usando a Clean Architecture

Este projeto foi criado utilizando os conceitos aprendidos na arquitetura proposta pelo uncle Bob, 
mas também utiliza o Spring Boot 2 como tecnologia base.

Para funcionar, basta rodar o UsuarioMainApplication no módulo application, mas antes configurar o servidor e conta
de email no application.yml

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: <usuario>
    password: <senha>
```

