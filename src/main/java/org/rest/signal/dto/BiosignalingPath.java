package org.rest.signal.dto;

public class BiosignalingPath {

    private String name;
    private String organism;
    private String shortDescription;
    private String keggId;

    public BiosignalingPath() {
        this.name = null;
        this.organism = null;
        this.shortDescription = null;
        this.keggId = null;
    }

    public BiosignalingPath setName(String name) {
        this.name = name;
        return this;
    }

    public BiosignalingPath setOrganism(String organism) {
        this.organism = organism;
        return this;
    }

    public BiosignalingPath setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public BiosignalingPath setKeegReference(String keggId){
        this.keggId = keggId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getOrganism() {
        return this.organism;
    }

    public String getShortDescription(){
        return this.shortDescription;
    }

    public String getKeegReference(){
        return this.keggId;
    }

}