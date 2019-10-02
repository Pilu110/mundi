package com.pilu.mundi;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.pilu.mundi.generator.M2Generator;
import com.pilu.mundi.ui.ViewPort;
import com.pilu.mundi.ui.colorer.AvgColorer;
import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.ui.colorer.SequenceSizeColorer;
import com.pilu.mundi.generator.MandelGenerator;

import com.pilu.mundi.ui.GraphicUI;

public class MundiMain {
  public static void main(String [] args) {
    M2Generator mandelGenerator = new M2Generator(3,2);
    ViewPort viewPort = new ViewPort(mandelGenerator, new Point2D.Double(0,0), 4.0 / 800, 600, 600);
    //Colorer colorer = new SequenceSizeColorer(0.15f, 0.9f);
    Colorer colorer = new AvgColorer(0.15f, 0.9f);
    GraphicUI graphicUI = new GraphicUI(viewPort, colorer);
    graphicUI.display();
  }
}
