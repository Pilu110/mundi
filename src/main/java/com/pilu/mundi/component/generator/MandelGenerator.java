package com.pilu.mundi.component.generator;

import com.pilu.mundi.behaviour.EndCondition;
import com.pilu.mundi.behaviour.Transformer;
import com.pilu.mundi.component.generator.Generator;
import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

public class MandelGenerator extends Generator {
    public MandelGenerator() {
        super(
            (value, sequence) -> value.pow(2).add(sequence.get(0)),
            (value, sequence) -> value.abs() > 2.0 || sequence.size() > 100
        );
    }
}
