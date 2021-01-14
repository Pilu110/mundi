package com.pilu.mundi.generator;

import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

public class Generator {

    private Transformer transformer;
    private EndCondition endCondition;

    public Generator(Transformer transformer, EndCondition endCondition) {
        this.transformer = transformer;
        this.endCondition = endCondition;
    }

    public ComplexSequence generate(Complex base) {
        ComplexSequence sequence = new ComplexSequence(base);

        Complex current = base;
        while(!endCondition.isEnded(sequence)) {
            current = transformer.transform(current, sequence);
            sequence.add(current);
        }

        return sequence;
    }
}
