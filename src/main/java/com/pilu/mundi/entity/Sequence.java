package com.pilu.mundi.entity;

import java.util.List;

public class Sequence<T> {
    private List<T> sequence;

    public Sequence(List<T> sequence) {
        this.sequence = sequence;
    }

    public List<T> getSequence() {
        return sequence;
    }
}
