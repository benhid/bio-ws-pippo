## Pruebas de la API

Usando `curl` haremos una llamada a los métodos de _WSS_ a través de la siguiente dirección:

```
http://localhost:8080/helloworld-ws/server/school/
```

Así, por ejemplo, tenemos:

```bash
$ curl http://localhost:8080/helloworld-ws/server/school/helloworld
Hello World!

$ curl http://localhost:8080/helloworld-ws/server/school/hello/Marco
Hello Marco

$ curl -H "Accept: application/json" http://localhost:8080/helloworld-ws/server/school/get/students
[{"id":1,"name":"Pedro"},{"id":2,"name":"Alicia"}]

$ curl -H "Accept: application/xml" http://localhost:8080/helloworld-ws/server/school/get/students

$ curl -H "Accept: application/json" http://localhost:8080/helloworld-ws/server/school/get/student/1
{"id":1,"name":"Pedro"}
$ curl -H "Accept: application/xml" http://localhost:8080/helloworld-ws/server/school/get/student/1
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><student><id>1</id><name>Pedro</name></student>

```