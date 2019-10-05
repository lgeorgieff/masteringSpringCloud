1. docker run --detach --name rabbit --publish 5672:5672 --publish 15672:15672 rabbitmq:management
2. firefox http://localhost:15672/#/exchanges/%2F/springCloudBus
3.1. cd discovery-first-bootstrap/discovery-service
3.2. TERM=xterm-color ./gradlew bootRun
4.1. cd discovery-first-bootstrap/config-service
4.2. TERM=xterm-color ./gradlew bootRun
5.1. cd discovery-first-bootstrap/echo-service
6.2. TERM=xterm-color ./gradlew bootRun
7. change config (e.g. config-repo/echo-service-dev.yml)
8. curl -X POST http://localhost:8888/actuator/bus-refresh
