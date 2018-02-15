package org.rest.pathseq.bs;

import org.rest.pathseq.dto.PathDTO;

import java.util.ArrayList;
import java.util.List;

public class PathwayBS {

    private static PathwayBS instance;

    private PathwayBS(){
        PathDTO p1 = new PathDTO()
                .setName("glycolysis")
                .setOrganism("Homo sapiens (human)")
                .setReactions(239)
                .setDescription("The reactions of glycolysis (e.g., van Wijk and van Solinge 2005) " +
                        "convert glucose 6-phosphate to pyruvate. The entire process is cytosolic. " +
                        "Glucose 6-phosphate is reversibly isomerized to form fructose 6-phosphate. " +
                        "Phosphofructokinase 1 catalyzes the physiologically irreversible phosphorylation " +
                        "of fructose 6-phosphate to form fructose 1,6-bisphosphate. In six reversible reactions, " +
                        "fructose 1,6-bisphosphate is converted to two molecules of phosphoenolpyruvate and two " +
                        "molecules of NAD+ are reduced to NADH + H+. Each molecule of phosphoenolpyruvate reacts " +
                        "with ADP to form ATP and pyruvate in a physiologically irreversible reaction. " +
                        "Under aerobic conditions the NADH +H+ can be reoxidized to NAD+ via electron transport " +
                        "to yield additional ATP, while under anaerobic conditions or in cells lacking mitochondria " +
                        "NAD+ can be regenerated via the reduction of pyruvate to lactate.")
                .setKeegReference("hsa00010");
        PathDTO p2 = new PathDTO()
                .setName("photosynthesis")
                .setOrganism("plants, algae, euglena, bacteria")
                .setReactions(453)
                .setDescription("Photosynthesis in green plants and specialized bacteria is the process of utilizing " +
                        "light energy to synthesize organic compounds from carbon dioxide and water. It consists of " +
                        "the light dependent part (light reaction) and the light independent part (dark reaction, " +
                        "carbon fixation). The light reaction takes place in thylakoid, a membrane-bound compartment " +
                        "inside chloroplasts and cyanobacteria. The light energy is used by photosystems I and II to " +
                        "generate proton motive force and reducing power (NADPH or NADH). The proton motive force is " +
                        "used by ATP synthase to generate ATP, essentially in the same way as the mitochondrial " +
                        "respiratory chain. The supplies of ATP and NAD(P)H are then used to fix carbon dioxide.")
                .setKeegReference("map00195");

        addPathway(p1);
        addPathway(p2);
    }

    public static PathwayBS getInstance() {
        if(instance == null) {
            instance = new PathwayBS();
        }
        return instance;
    }

    private static final List<PathDTO> PATHWAYS = new ArrayList<>();

    public List<PathDTO> getPathwayList(){
        return PATHWAYS;
    }

    private void addPathway(PathDTO pathway){
        PATHWAYS.add(pathway);
    }

    public PathDTO getPathway(String name){
        for(PathDTO pathway : PATHWAYS){
            if(pathway.getName().equalsIgnoreCase(name)) return pathway;
        }
        return null;
    }

}
