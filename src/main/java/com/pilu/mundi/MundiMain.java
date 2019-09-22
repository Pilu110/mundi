package com.pilu.mundi;

import com.pilu.mundi.ui.ViewPort;
import com.pilu.mundi.ui.colorer.Colorer;
import com.pilu.mundi.ui.colorer.SequenceSizeColorer;
import com.pilu.mundi.generator.MandelGenerator;

import com.pilu.mundi.ui.GraphicUI;

public class MundiMain {
  public static void main(String [] args) {
    MandelGenerator mandelGenerator = new MandelGenerator(8);
    ViewPort viewPort = new ViewPort(mandelGenerator, 0,0, 2.0 / 100, 500, 500);
    Colorer colorer = new SequenceSizeColorer(0.5f, 0.5f, 100);
    GraphicUI graphicUI = new GraphicUI(viewPort, colorer);
    graphicUI.display();
  }
}
