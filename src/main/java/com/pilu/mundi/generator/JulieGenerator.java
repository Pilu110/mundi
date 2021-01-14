package com.pilu.mundi.generator;

import org.apache.commons.math3.complex.Complex;

public class JulieGenerator extends Generator {

  public JulieGenerator(Complex julieNumber) {
    super(
        (value, sequence) -> value.pow(2).add(julieNumber),
        (sequence) -> sequence.getLast().abs() > 2.0 || sequence.size() > 100
    );
  }
}
