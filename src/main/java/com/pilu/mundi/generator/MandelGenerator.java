package com.pilu.mundi.generator;

public class MandelGenerator extends Generator {
    public MandelGenerator(int power) {
        super(
            (value, sequence) -> value.pow(power).add(sequence.getBase()),
            (value, sequence) -> value.abs() > 2.0 || sequence.size() > 200
        );
    }
}
