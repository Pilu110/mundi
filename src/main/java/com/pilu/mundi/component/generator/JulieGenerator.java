package com.pilu.mundi.component.generator;

import org.apache.commons.math3.complex.Complex;

public class JulieGenerator extends Generator {

  public JulieGenerator(Complex julieNumber) {
    super(
        (value, sequence) -> value.pow(2).add(julieNumber),
        (value, sequence) -> value.abs() > 2.0 || sequence.size() > 100
    );
  }
}
