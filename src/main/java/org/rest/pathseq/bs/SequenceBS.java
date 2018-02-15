package org.rest.pathseq.bs;

import org.rest.pathseq.dto.ResponseSeqOccursDTO;
import org.rest.pathseq.dto.SequenceDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceBS {

    private static SequenceBS instance;

    private SequenceBS(){
        SequenceDTO newGenADN = new SequenceDTO();
        newGenADN.setId("1mrch");
        newGenADN.setSequence("AGACGAGCGATCGTACGACTGCA");
        newGenADN.setType("DNA");

        SequenceDTO newGenARN = new SequenceDTO();
        newGenARN.setId("2stban");
        newGenARN.setSequence("AGUCAUACUUAACACACA");
        newGenARN.setType("RNA");

        addSequence(newGenADN);
        addSequence(newGenARN);
    }

    public static SequenceBS getInstance() {
        if(instance == null) {
            instance = new SequenceBS();
        }
        return instance;
    }

    private static final List<SequenceDTO> SEQUENCES = new ArrayList<>();

    public List<SequenceDTO> getSequenceList(){
        return SEQUENCES;
    }

    private void addSequence(SequenceDTO seq){
        SEQUENCES.add(seq);
    }

    public SequenceDTO getSequence(String id){
        for(SequenceDTO seq : SEQUENCES){
            if(seq.getId().equalsIgnoreCase(id)) return seq;
        }
        return null;
    }

    public boolean isDNA(String id){
        return getSequence(id).getSequence().matches("^[A-C-G-T]+$");
    }

    public ResponseSeqOccursDTO getOcurrences(String id, String substring){
        ResponseSeqOccursDTO res = new ResponseSeqOccursDTO();
        String sequence = getSequence(id).getSequence();

        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(sequence);

        int count = 0;
        int pos = 0;
        while (matcher.find(pos)){
            count++;
            pos = matcher.start() + 1;

            res.addIndex(pos);
        }

        res.setOccurrences(count);

        return res;
    }

    public String clipSequence(String id, int i, int j){
        SequenceDTO seq = this.getSequence(id);
        String subSequence = "";

        if(seq != null) {
            String sequence = seq.getSequence();

            if (j > sequence.length()) j = sequence.length();
            if (i < 0) i = 0;

            subSequence = sequence.substring(i, j);
        }

        return subSequence;
    }

    public String transcribeSequence(String id){
        SequenceDTO seq = this.getSequence(id);
        String ARN = "";

        if(seq != null) {
            if(seq.getType().equalsIgnoreCase("DNA")) {
                String sequence = seq.getSequence();
                ARN = sequence
                        .replace('T', 'U').replace('A', 'e').replace('U', 'A').replace('e', 'U')
                        .replace('C', '+').replace('G', 'C').replace('+', 'G');

            }
        }

        return ARN;
    }

}