package org.rest.pathway.server;

import org.rest.pathway.bs.PathwayBS;
import org.rest.pathway.dto.PathDTO;
import ro.pippo.core.Application;
import ro.pippo.core.util.IoUtils;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebServiceServer extends Application {

    @Override
    protected void onInit() {
        getRouter().ignorePaths("/favicon.ico");

        // before filter that create a PathwayBS instance
        ANY("/.*", routeContext -> {
            routeContext.setLocal("pathwayBS", PathwayBS.getInstance());
            routeContext.next(); // we MUST call routeContext.next() to jump to the next route/filter from the chain
        });

        // Add routes (serve an html)
        GET("/", routeContext -> {
            try {
                routeContext.send(IoUtils.toString(WebServiceServer.class.getResourceAsStream("/index.html")));
            } catch (IOException ex) {
                Logger.getLogger(WebServiceServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Send 'Hello World' as response
        GET("/hello/{world}", routeContext -> {
            String message = routeContext.getParameter("world").toString();

            routeContext.send("Hello " + message);
        });

        // Get a specific pathway
        GET("/get/{name}", routeContext -> {
            String name = routeContext.getParameter("name").toString();
            PathwayBS pathwayBS = routeContext.getLocal("pathwayBS");
            PathDTO p = pathwayBS.getPathway(name);

            routeContext.json().send(p);
        });

        // Get all pathways
        GET("/debug/all", routeContext -> {
            PathwayBS pathwayBS = routeContext.getLocal("pathwayBS");
            List<PathDTO> allP = pathwayBS.getPathwayList();

            routeContext.json().send(allP);
        });
    }

}