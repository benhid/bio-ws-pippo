# JAX-WS Web Service

## Requisitos

Para poder ejecutar el servidor es necesario disponer de:

* Java 8 JDK,
* Maven >3.5,
* [Docker](https://get.docker.com/)/[Docker-compose](https://docs.docker.com/compose/install/#install-compose) para el despliegue en Wildfly (opcional),
* [Postman](https://www.getpostman.com/) para probar la API (opcional).
 
## Compilación
 
En la carpeta _rest-ws_ o _soap-ws_, ejecutar

```
$ mvn clean install
```

Esto generará el archivo **_helloworld-ws.war_** en _~/target/_.

## Despliegue

Iniciaremos el contenedor de Docker posicionándonos en la carpeta _docker-wildfly_ usando

```bash
$ docker-compose build
$ docker-compose up -d
```

Esto descargará (si es necesario) e iniciará la imagen de Wildfly usando Docker. A través de la dirección

```
http://localhost:8090/
```

podremos acceder al panel de control usando el nombre y contraseña especificados en el archivo _~/docker-wildfly/wildfly/Dockerfile_ (por defecto, admin:12345).

En la pestaña superior _Deployments_ podemos añadir nuestro archivo _.war_ (pinchando en el botón azul _Add_).

![wildly](https://raw.githubusercontent.com/benhid/soap-ws/master/resources/wildfly-deploy.png)

Si todo va bien, podremos acceder a nuestro endpoint a través de la dirección

```
http://localhost:8080/helloworld-ws/server?wsdl
```

O, si hemos desplegado un servidor *rest*,

```
http://localhost:8080/helloworld-ws/server/school/
```