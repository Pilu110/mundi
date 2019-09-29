package com.pilu.mundi;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.pilu.mundi.ui.ViewPort;
import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.ui.colorer.SequenceSizeColorer;
import com.pilu.mundi.generator.MandelGenerator;

import com.pilu.mundi.ui.GraphicUI;

public class MundiMain {
  public static void main(String [] args) {
    MandelGenerator mandelGenerator = new MandelGenerator(8);
    ViewPort viewPort = new ViewPort(mandelGenerator, new Point2D.Double(0,1), 2.0 / 500, 500, 500);
    Colorer colorer = new SequenceSizeColorer(0.8f, 0.2f, 100);
    GraphicUI graphicUI = new GraphicUI(viewPort, colorer);
    graphicUI.display();
  }
}
