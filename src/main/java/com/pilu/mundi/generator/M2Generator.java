package com.pilu.mundi.generator;

public class M2Generator  extends Generator {

    public M2Generator(int power, int root) {
        super(
                (value, sequence) -> value.pow(power).add(sequence.getBase()).nthRoot(root).get(0),
                (value, sequence) -> value.abs() > 3.0 || sequence.size() > 200
        );
    }
}
