package org.rest.pathseq.dto;

public class PathDTO {

    private String name;
    private String organism;
    private String description;
    private String keggId;
    private int reactions;

    public PathDTO() {
        this.name = null;
        this.organism = null;
        this.description = null;
        this.keggId = null;
        this.reactions = 0;
    }

    public PathDTO setName(String name) {
        this.name = name;
        return this;
    }

    public PathDTO setOrganism(String organism) {
        this.organism = organism;
        return this;
    }

    public PathDTO setReactions(int reactions) {
        this.reactions = reactions;
        return this;
    }

    public PathDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public PathDTO setKeegReference(String keggId){
        this.keggId = keggId;
        return this;
    }


    public String getName() {
        return this.name;
    }

    public String getOrganism() {
        return this.organism;
    }

    public String getDescription(){
        return this.description;
    }

    public String getKeegReference(){
        return this.keggId;
    }

    public int getReactions() {
        return this.reactions;
    }

}