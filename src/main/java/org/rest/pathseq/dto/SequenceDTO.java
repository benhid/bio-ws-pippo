package org.rest.pathseq.dto;

public class SequenceDTO {

    private String id;
    private String sequence;
    private String type;

    public SequenceDTO() {}

    public SequenceDTO(String id, String sequence) {
        this.id = id;
        this.sequence = sequence;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
