package com.pilu.mundi;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.pilu.mundi.generator.ZetaGenerator;
import com.pilu.mundi.ui.colorer.DomainColorer;
import org.apache.commons.math3.complex.Complex;

import com.pilu.mundi.generator.JulieGenerator;
import com.pilu.mundi.ui.ViewPort;
import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.ui.colorer.SequenceSizeColorer;
import com.pilu.mundi.generator.MandelGenerator;

import com.pilu.mundi.ui.GraphicUI;

public class MundiMain {
  public static void main(String [] args) {
    //MandelGenerator mandelGenerator = new MandelGenerator(7);
    //JulieGenerator julieGenerator = new JulieGenerator(new Complex(0.5,0.4));
    ZetaGenerator zetaGenerator = new ZetaGenerator();

    ViewPort viewPort = new ViewPort(zetaGenerator, new Point2D.Double(0,0), 1, 400, 400);
    //Colorer colorer = new SequenceSizeColorer(0.15f, 0.1f);
    Colorer colorer = new DomainColorer(200, 0);
    GraphicUI graphicUI = new GraphicUI(viewPort, colorer);
    graphicUI.display();
  }
}
