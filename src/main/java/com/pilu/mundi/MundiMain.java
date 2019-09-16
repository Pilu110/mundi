package com.pilu.mundi;

import com.pilu.mundi.component.colorer.SequenceSizeColorer;
import com.pilu.mundi.component.generator.JulieGenerator;
import com.pilu.mundi.component.generator.MandelGenerator;
import com.pilu.mundi.component.Navigator;

import com.pilu.mundi.component.displayer.GraphicDisplayer;
import com.pilu.mundi.entity.ComplexSequenceMatrix;
import org.apache.commons.math3.complex.Complex;

public class MundiMain {
  public static void main(String [] args) {

//    MandelGenerator mandelGenerator = new MandelGenerator();

    JulieGenerator julieGenerator = new JulieGenerator(new Complex(-0.4,0.6));

    Navigator navigator = new Navigator(julieGenerator, 0,0, 2.0 / 100, 500, 500);

    //ConsoleDisplayer consoleDisplayer = new ConsoleDisplayer();
    GraphicDisplayer graphicDisplayer = new GraphicDisplayer(new SequenceSizeColorer());

    ComplexSequenceMatrix matrix = navigator.navigate();
    //consoleDisplayer.display(matrix);
    graphicDisplayer.display(matrix);
  }
}
