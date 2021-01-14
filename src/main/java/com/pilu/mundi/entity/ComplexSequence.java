package com.pilu.mundi.entity;

import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.List;

public class ComplexSequence {

    private final Complex base;
    private final List<Complex> sequence = new ArrayList<Complex>();

    public ComplexSequence(Complex base) {
        this.base = base;
    }

    public void add(Complex value) {
        sequence.add(value);
    }

    public Complex getBase() {
        return base;
    }

    public Complex getLast() {
        return getFromLast(0);
    }

    public Complex getFromLast(int i) {
        return sequence.get(sequence.size() - 1 - i);
    }

    public Complex get(int index) {
        return sequence.get(index);
    }

    public List<Complex> getSequence() {
        return sequence;
    }

    public int size() {
        return sequence.size();
    }
}
