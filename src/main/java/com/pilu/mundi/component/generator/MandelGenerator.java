package com.pilu.mundi.component.generator;

public class MandelGenerator extends Generator {
    public MandelGenerator() {
        super(
            (value, sequence) -> value.pow(2).add(sequence.getBase()),
            (value, sequence) -> value.abs() > 2.0 || sequence.size() > 100
        );
    }
}
