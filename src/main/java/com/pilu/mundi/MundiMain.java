package com.pilu.mundi;

import com.pilu.mundi.component.colorer.SequenceSizeColorer;
import com.pilu.mundi.component.displayer.ConsoleDisplayer;
import com.pilu.mundi.component.MandelGenerator;
import com.pilu.mundi.component.Navigator;

import com.pilu.mundi.component.displayer.GraphicDisplayer;
import com.pilu.mundi.entity.ComplexSequenceMatrix;
import org.apache.commons.math3.complex.Complex;

public class MundiMain {
  public static void main(String [] args) {

    MandelGenerator mandelGenerator = new MandelGenerator();
    mandelGenerator.generate(Complex.ZERO);

    Navigator navigator = new Navigator(mandelGenerator, 0,0, 2.0 / 500, 1000, 500);

    //ConsoleDisplayer consoleDisplayer = new ConsoleDisplayer();
    GraphicDisplayer graphicDisplayer = new GraphicDisplayer(new SequenceSizeColorer());

    ComplexSequenceMatrix matrix = navigator.navigate();
    //consoleDisplayer.display(matrix);
    graphicDisplayer.display(matrix);
  }
}
