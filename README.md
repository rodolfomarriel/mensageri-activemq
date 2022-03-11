# Mensageria ActiveMQ
Mini projeto usando activeMQ para estudar mensageria

## Dependencias usadas
H2<br/>
ActiveMQ<br/>
Java 14.0.2

## Imagem do activeMQ docker
````
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
````
Link de acesso ao activeMQ [http://localhost:8161](http://localhost:8161/index.html)

Link de acesso ao banco local h2 http://localhost:8080/h2-console/

Link de acesso a pagina de cadastro de informacoes http://localhost:8081

As informacoes seguem o seguinte estilo:
````
{
"name":"Teste",
"age":30
}
````