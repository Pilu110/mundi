package com.pilu.mundi;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.pilu.mundi.generator.ZetaGenerator;
import com.pilu.mundi.ui.colorer.DomainColorer;
import org.apache.commons.math3.complex.Complex;

import com.pilu.mundi.generator.JulieGenerator;
import com.pilu.mundi.generator.M2Generator;
import com.pilu.mundi.ui.ViewPort;
import com.pilu.mundi.ui.colorer.AvgColorer;
import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.ui.colorer.SequenceSizeColorer;
import com.pilu.mundi.generator.MandelGenerator;

import com.pilu.mundi.ui.GraphicUI;

public class MundiMain {
  public static void main(String [] args) {
    //MandelGenerator mandelGenerator = new MandelGenerator(7);
    //JulieGenerator julieGenerator = new JulieGenerator(new Complex(0.5,0.4));
    ZetaGenerator zetaGenerator = new ZetaGenerator();

    ViewPort viewPort = new ViewPort(zetaGenerator, new Point2D.Double(0,0), 0.01, 400, 400);
    //Colorer colorer = new SequenceSizeColorer(0.15f, 0.1f);
    Colorer colorer = new DomainColorer(200, 0);
//    M2Generator mandelGenerator = new M2Generator(3,2);
//    ViewPort viewPort = new ViewPort(mandelGenerator, new Point2D.Double(0,0), 4.0 / 800, 600, 600);
    //Colorer colorer = new SequenceSizeColorer(0.15f, 0.9f);
 //   Colorer colorer = new AvgColorer(0.15f, 0.9f);
    GraphicUI graphicUI = new GraphicUI(viewPort, colorer);
    graphicUI.display();
  }
}
