package com.pilu.mundi;

import com.pilu.mundi.generator.MandelGenerator;
import com.pilu.mundi.navigator.Navigator;

import org.apache.commons.math3.complex.Complex;

public class MundiMain {
  public static void main(String [] args) {

    MandelGenerator mandelGenerator = new MandelGenerator();
    mandelGenerator.generate(Complex.ZERO);

    Navigator navigator = new Navigator(mandelGenerator, Complex.ZERO, 2.0 / 500, 500, 500);


  }
}
