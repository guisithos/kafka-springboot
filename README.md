# Consumer Kafka - Projeto Atualizado

Este projeto é um consumidor Kafka desenvolvido em Spring Boot que processa mensagens de estudantes. Utilizei como base um artigo do Linkedin e incluí persistência de dados com PostgreSQL e Flyway para migrations, sistema de logs estruturados em JSON, monitoramento através do Actuator e Prometheus, e documentação via OpenAPI.

A arquitetura foi reestruturada implementando camadas de serviço e repositório, com tratamento de exceções e circuit breaker usando Resilience4j. O processamento de mensagens Kafka foi fortalecido com confirmações manuais e configuração de DLQ para mensagens com falha.

A aplicação agora possui testes de integração utilizando Kafka embarcado, healthchecks para monitoramento da conectividade com Kafka, e métricas detalhadas do processamento de mensagens. A configuração foi externalizada usando variáveis de ambiente para maior segurança e flexibilidade em diferentes ambientes.

O projeto está containerizado com Docker, incluindo pool de conexões com banco de dados através do HikariCP e múltiplas instâncias de consumidores Kafka para melhor throughput.

Para executar o projeto, é necessário configurar as variáveis de ambiente para conexão com PostgreSQL e Kafka, e utilizar o Docker ou Maven para build e execução. A documentação da API está disponível através do Swagger UI após a inicialização da aplicação. 
