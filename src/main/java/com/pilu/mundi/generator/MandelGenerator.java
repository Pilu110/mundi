package com.pilu.mundi.generator;

public class MandelGenerator extends Generator {
    public MandelGenerator(int power) {
        super(
            (value, sequence) -> value.pow(power).add(sequence.getBase()),
            (value, sequence) -> value.abs() > 1.5 || sequence.size() > 100
        );
    }
}
