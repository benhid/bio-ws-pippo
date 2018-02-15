package org.rest.signal.server;

import org.rest.signal.bs.SignalBS;
import org.rest.signal.dto.BiosignalingPath;

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
            routeContext.setLocal("signalBS", SignalBS.getInstance());

            // we MUST call routeContext.next() to jump to the next route/filter from the chain
            routeContext.next();
        });

        // Add routes (serve an html)
        GET("/", routeContext -> {
            try {
                routeContext.send(IoUtils.toString(WebServiceServer.class.getResourceAsStream("/index.html")));
            } catch (IOException ex) {
                Logger.getLogger(WebServiceServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Get a specific pathway
        GET("/pathway/get/{name}", routeContext -> {
            String name = routeContext.getParameter("name").toString();
            SignalBS pathwayBS = routeContext.getLocal("signalBS");
            BiosignalingPath path = pathwayBS.getPathway(name);

            routeContext.json().send(path);
        });

        // Get a map from a specific pathway
        GET("/pathway/map/{name}", routeContext -> {
            SignalBS pathwayBS = routeContext.getLocal("signalBS");
            String name = routeContext.getParameter("name").toString();

            if(pathwayBS.hasPathway(name)) {
                BiosignalingPath p = pathwayBS.getPathway(name);
                routeContext.redirect("/?map=" + p.getKeegReference());
            } else {
                routeContext.send("No signaling pathway found on server!");
            }
        });

        // Filter all pathways by organism
        GET("/pathway/filter/organism/{org}", routeContext -> {
            SignalBS pathwayBS = routeContext.getLocal("signalBS");
            String organism = routeContext.getParameter("org").toString();

            List<BiosignalingPath> filtered = pathwayBS.filterByOrganism(organism);

            routeContext.json().send(filtered);
        });

        // Get all pathways
        GET("/debug/pathway/all", routeContext -> {
            SignalBS pathwayBS = routeContext.getLocal("signalBS");
            List<BiosignalingPath> allP = pathwayBS.getPathwayList();

            routeContext.json().send(allP);
        });

    }

}