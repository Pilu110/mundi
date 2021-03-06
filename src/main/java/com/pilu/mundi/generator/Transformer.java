package com.pilu.mundi.generator;

import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

public interface Transformer {
    Complex transform(Complex value, ComplexSequence sequence);
}
