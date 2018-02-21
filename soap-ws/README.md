## Cliente

Para implementar correctamente el consumidor de la API (o cliente), hemos usado:

```
$ wsimport -d generated -extension -keep -p com.helloworld.ws -XadditionalHeaders http://127.0.0.1:8080/helloworld-ws/server?wsdl
```

## Pruebas de la API

Usando Postman haremos una llamada a los métodos de _WSS_ a través de la siguiente dirección:

```
http://localhost:8080/helloworld-ws/server?wsdl
```

El contenido del _body_ será el siguiente:

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:op="com.org.helloworld">
<soap:Body>
	<op:sayHello/>
</soap:Body>
</soap:Envelope>
```

Si todo va bien, se nos mostrará como respuesta "Hello World!":

![postman](https://raw.githubusercontent.com/benhid/soap-ws/master/resources/postman.png)

Otros ejemplos:

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:op="com.org.helloworld">
<soap:Body>
	<op:addStudent>
		<student>
			<id>1</id>
			<name>Marco</name>
		</student>
	</op:addStudent>
</soap:Body>
</soap:Envelope>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:op="com.org.helloworld">
<soap:Body>
	<op:getStudentList/>
</soap:Body>
</soap:Envelope>
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:op="com.org.helloworld">
<soap:Body>
	<op:getStudent>
		<id>1</id>
	</op:getStudent>
</soap:Body>
</soap:Envelope>
```