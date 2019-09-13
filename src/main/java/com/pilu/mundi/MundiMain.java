package com.pilu.mundi;

import com.pilu.mundi.component.ConsoleDisplayer;
import com.pilu.mundi.component.MandelGenerator;
import com.pilu.mundi.component.Navigator;

import org.apache.commons.math3.complex.Complex;

public class MundiMain {
  public static void main(String [] args) {

    MandelGenerator mandelGenerator = new MandelGenerator();
    mandelGenerator.generate(Complex.ZERO);

    Navigator navigator = new Navigator(mandelGenerator, 0,0, 2.0 / 50, 100, 100);

    ConsoleDisplayer consoleDisplayer = new ConsoleDisplayer();

    consoleDisplayer.display(navigator.navigate());
  }
}
