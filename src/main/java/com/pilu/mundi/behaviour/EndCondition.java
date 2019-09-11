package com.pilu.mundi.behaviour;

import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

public interface EndCondition {
    boolean isEnded(Complex value, ComplexSequence sequence);
}
