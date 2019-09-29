package com.pilu.mundi;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.pilu.mundi.ui.ViewPort;
import com.pilu.mundi.ui.colorer.AvgColorer;
import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.ui.colorer.SequenceSizeColorer;
import com.pilu.mundi.generator.MandelGenerator;

import com.pilu.mundi.ui.GraphicUI;

public class MundiMain {
  public static void main(String [] args) {
    MandelGenerator mandelGenerator = new MandelGenerator(2);
    ViewPort viewPort = new ViewPort(mandelGenerator, new Point2D.Double(0,0), 4.0 / 800, 500, 500);
    Colorer colorer = new AvgColorer(0.15f, 0.9f);
    GraphicUI graphicUI = new GraphicUI(viewPort, colorer);
    graphicUI.display();
  }
}
