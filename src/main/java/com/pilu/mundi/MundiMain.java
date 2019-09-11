package com.pilu.mundi;

import com.pilu.mundi.generator.MandelGenerator;
import org.apache.commons.math3.complex.Complex;

public class MundiMain {
  public static void main(String [] args) {

    MandelGenerator mandelGenerator = new MandelGenerator();
    mandelGenerator.generate(new Complex(0, 0));
  }
}
