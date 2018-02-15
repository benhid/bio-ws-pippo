package org.rest.pathseq.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseSeqOccursDTO {

    private int occurrences;
    private List<Integer> pos;

    public ResponseSeqOccursDTO() {
        pos = new ArrayList<>();
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public boolean anyOccurrences(){
        return occurrences == 0;
    }

    public void addIndex(int p) {
        pos.add(p);
    }

    public int getOccurrences() {
        return occurrences;
    }

    public List<Integer> getIndexes() {
        return pos;
    }

}