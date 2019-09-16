package com.pilu.mundi.entity;

import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.List;

public class ComplexSequence {

    private final List<Complex> sequence = new ArrayList<Complex>();

    public ComplexSequence(Complex base) {
        sequence.add(base);
    }

    public void add(Complex value) {
        sequence.add(value);
    }

    public Complex getBase() {
        return sequence.get(0);
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
