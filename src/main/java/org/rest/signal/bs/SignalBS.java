package org.rest.signal.bs;

import org.rest.signal.dto.BiosignalingPath;

import java.util.ArrayList;
import java.util.List;

public class SignalBS {

    private static SignalBS instance;

    private SignalBS(){
        BiosignalingPath p1 = new BiosignalingPath()
                .setName("p53")
                .setOrganism("Homo sapiens (human)")
                .setShortDescription("p53 activation is induced by a number of stress signals, including DNA damage, " +
                        "oxidative stress and activated oncogenes. The p53 protein is employed as a transcriptional " +
                        "activator of p53-regulated genes. This results in three major outputs; cell cycle arrest, " +
                        "cellular senescence or apoptosis. Other p53-regulated gene functions communicate with " +
                        "adjacent cells, repair the damaged DNA or set up positive and negative feedback loops that " +
                        "enhance or attenuate the functions of the p53 protein and integrate these stress responses " +
                        "with other signal transduction pathways.")
                .setKeegReference("hsa04115");
        BiosignalingPath p2 = new BiosignalingPath()
                .setName("MAPK")
                .setOrganism("yeast")
                .setShortDescription("The S. cerevisiae genome encodes multiple MAP kinase orthologs. One (Fus3) " +
                        "mediates cellular response to peptide pheromones. Another (Kss1) permits adjustment to " +
                        "nutrient limiting conditions. A third (Hog1) is necessary for survival under hyperosmotic " +
                        "conditions. A fourth (Slt2/Mpk1) is required for repair of injuries to the cell wall. As in " +
                        "mammalian cells, these pathways consist of a conserved module in which three kinases " +
                        "phosphorylate each other in sequence. The MAPK is phosphorylated by the MAPK/ERK kinase " +
                        "(MAPKK/MEK), which is itself phosphorylated by a MEK kinase (MAPKKK/MEKK).")
                .setKeegReference("map04011");
        BiosignalingPath p3 = new BiosignalingPath()
                .setName("PPAR")
                .setOrganism("Homo sapiens (human)")
                .setShortDescription("Peroxisome proliferator-activated receptors (PPARs) are nuclear hormone " +
                        "receptors that are activated by fatty acids and their derivatives. PPAR has three subtypes " +
                        "(PPARalpha, beta/delta, and gamma) showing different expression patterns in vertebrates. " +
                        "Each of them is encoded in a separate gene and binds fatty acids and eicosanoids. PPARalpha " +
                        "plays a role in the clearance of circulating or cellular lipids via the regulation of gene " +
                        "expression involved in lipid metabolism in liver and skeletal muscle. PPARbeta/delta is " +
                        "involved in lipid oxidation and cell proliferation. PPARgamma promotes adipocyte " +
                        "differentiation to enhance blood glucose uptake.")
                .setKeegReference("map03320");

        addPathway(p1);
        addPathway(p2);
        addPathway(p3);
    }

    public static SignalBS getInstance() {
        if(instance == null) {
            instance = new SignalBS();
        }
        return instance;
    }

    private static final List<BiosignalingPath> PATHWAYS = new ArrayList<>();

    public List<BiosignalingPath> getPathwayList(){
        return PATHWAYS;
    }

    private void addPathway(BiosignalingPath pathway){
        PATHWAYS.add(pathway);
    }

    public BiosignalingPath getPathway(String name){
        for(BiosignalingPath pathway : PATHWAYS){
            if(pathway.getName().equalsIgnoreCase(name)) return pathway;
        }
        return null;
    }

    public List<BiosignalingPath> filterByOrganism(String organism){
        List<BiosignalingPath> filtered = new ArrayList<>();

        for(BiosignalingPath pathway : PATHWAYS){
            if(pathway.getOrganism().contains(organism)){
                filtered.add(pathway);
            }
        }

        return filtered;
    }

    public boolean hasPathway(String name){
        for(BiosignalingPath pathway : PATHWAYS){
            if(pathway.getName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

}
