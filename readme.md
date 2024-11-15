# Consumer Kafka

Aplicação Spring Boot que atua como consumidor Kafka, configurada para escutar mensagens JSON no tópico "student-topic". O serviço processa objetos do tipo Student (contendo id, nome, documento e courseId) e utiliza log para registrar as mensagens recebidas. A aplicação roda na porta 8082 e se conecta a um broker Kafka local na porta 9092.