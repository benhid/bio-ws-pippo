package org.rest.pathseq.server;

import org.rest.pathseq.bs.PathwayBS;
import org.rest.pathseq.bs.SequenceBS;
import org.rest.pathseq.dto.PathDTO;
import org.rest.pathseq.dto.ResponseSeqOccursDTO;
import org.rest.pathseq.dto.SequenceDTO;
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
            routeContext.setLocal("sequenceBS", SequenceBS.getInstance());

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

        // Send 'Hello World' as response
        GET("/hello/{world}", routeContext -> {
            String message = routeContext.getParameter("world").toString();

            routeContext.send("Hello " + message);
        });

        // Get a specific pathway
        GET("/pathway/get/{name}", routeContext -> {
            String name = routeContext.getParameter("name").toString();
            PathwayBS pathwayBS = routeContext.getLocal("pathwayBS");
            PathDTO p = pathwayBS.getPathway(name);

            routeContext.json().send(p);
        });

        // Get a specific sequence
        GET("/sequence/get/{id}", routeContext -> {
            String id = routeContext.getParameter("id").toString();
            SequenceBS sequenceBS = routeContext.getLocal("sequenceBS");
            SequenceDTO s = sequenceBS.getSequence(id);

            routeContext.json().send(s);
        });

        // Get number of occurrences of substring
        GET("/sequence/occurs/{id}/{substring}", routeContext -> {
            String id = routeContext.getParameter("id").toString();
            String substring = routeContext.getParameter("substring").toString();

            SequenceBS sequenceBS = routeContext.getLocal("sequenceBS");
            ResponseSeqOccursDTO response = sequenceBS.getOcurrences(id, substring);

            if (response.anyOccurrences()) {
                routeContext.json().send(response);
            } else{
                routeContext.json().send("No occurrences found!");
            }
        });

        // Is a valid DNA sequence
        GET("/sequence/validate/{id}", routeContext -> {
            String id = routeContext.getParameter("id").toString();

            SequenceBS sequenceBS = routeContext.getLocal("sequenceBS");
            boolean isDNA = sequenceBS.isDNA(id);

            routeContext.json().send(isDNA);
        });

        // Get all pathways
        GET("/debug/pathway/all", routeContext -> {
            PathwayBS pathwayBS = routeContext.getLocal("pathwayBS");
            List<PathDTO> allP = pathwayBS.getPathwayList();

            routeContext.json().send(allP);
        });

        // Get all sequences
        GET("/debug/sequence/all", routeContext -> {
            SequenceBS sequenceBS = routeContext.getLocal("sequenceBS");
            List<SequenceDTO> allS = sequenceBS.getSequenceList();

            routeContext.json().send(allS);
        });
    }

}