package com.pilu.mundi.generator;

import org.apache.commons.math3.complex.Complex;

public class ZetaGenerator extends Generator {
    public ZetaGenerator() {
        super(
            (value, sequence) -> sequence.getBase().getReal() > 0 ? (sequence.size() > 0 ? sequence.getLast() : Complex.ZERO).add(Complex.ONE.divide(Complex.valueOf(sequence.size() + 1).pow(sequence.getBase()))) : Complex.ZERO,
            (sequence) -> sequence.getBase().getReal() <= 0 || sequence.size() > 100 //(sequence.size() > 2 && sequence.getFromLast(1).subtract(sequence.getLast()).abs() > 100) || sequence.size() > 100
        );
    }
}
