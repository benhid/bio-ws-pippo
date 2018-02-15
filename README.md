## BioSignaling (REST) Web Service

We are going to use [Pippo](http://www.pippo.ro/doc/server.html) to develop our web service (by routes approach):

> Most server-side Java applications (e.g. web or service-oriented) are intended to run within a container. The traditional way to package these apps for distribution is to bundle them as a WAR file. Of course you can use the above model for your application development or you can use the simple way. Rather than your application being deployed to a container, an embedded container is deployed within the application itself. Pippo comes with Jetty as embedded web server. You can choose another container if you want (for example Tomcat).

## Usage

Clone the repository and run `src/main/java/org/rest/signal/server/WebServiceServerStart` or, alternatively, [deploy the server](http://www.pippo.ro/doc/deployment.html) using `mvn clean package`.
This will generate a ._zip_ file in `target/`. Run `java -jar signalwss-#.#.#.jar` on the unzipped file.

Then, go to
```
localhost:8338
```

## Methods

It's possible to [enumerate all the available pathways](images/debug_pathway_all.PNG) on the server by going to

```
localhost:8338/debug/pathway/all
```

To [get a specific pathway](images/pathway_get.PNG), use

```
localhost:8338/pathway/get/{name}
```

    e.g.
     localhost:8338/pathway/get/p53

To [get all pathways from a specific organism](images/filter_organism.PNG), use

```
localhost:8338/pathway/filter/organism/{organism}
```

    e.g.
     localhost:8338/pathway/filter/organism/human

To [view a map of the pathway](images/pathway_map.PNG), use

```
localhost:8338/pathway/map/{name}
```

    e.g.
     localhost:8338/pathway/map/p53
