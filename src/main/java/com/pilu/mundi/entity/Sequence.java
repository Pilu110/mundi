package com.pilu.mundi.entity;

import java.util.List;

public class Sequence {
    private List<Complex> sequence;

    public Sequence(List<Complex> sequence) {
        this.sequence = sequence;
    }

    public List<Complex> getSequence() {
        return sequence;
    }
}
