package com.pilu.mundi.generator;

import org.apache.commons.math3.complex.Complex;

public class ZetaGenerator extends Generator {
    public ZetaGenerator() {
        super(
            (value, sequence) -> sequence.getLast().add(Complex.ONE.divide(Complex.valueOf(sequence.size()).pow(sequence.getBase()))),
            (sequence) -> (sequence.size() > 1 && sequence.getFromLast(1).subtract(sequence.getLast()).abs() < 0.1) || sequence.size() > 100
        );
    }
}
