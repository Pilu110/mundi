package com.pilu.mundi.component.generator;

public class JulieGenerator extends Generator {
  public JulieGenerator() {
    super(
        (value, sequence) -> value.pow(50).add(sequence.get(0)),
        (value, sequence) -> value.abs() > 2.0 || sequence.size() > 100
    );
  }
}
