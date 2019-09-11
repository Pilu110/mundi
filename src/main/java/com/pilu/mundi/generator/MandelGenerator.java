package com.pilu.mundi.generator;

import com.pilu.mundi.behaviour.EndCondition;
import com.pilu.mundi.behaviour.Transformer;
import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

public class MandelGenerator extends Generator {
    public MandelGenerator() {
        super(new Transformer() {
            public Complex transform(Complex value, ComplexSequence sequence) {
                return value.pow(2).add(sequence.get(0));
            }
        }, new EndCondition() {
            public boolean isEnded(Complex value, ComplexSequence sequence) {
                return value.abs() > 2.0 || sequence.size() > 500;
            }
        });
    }
}
