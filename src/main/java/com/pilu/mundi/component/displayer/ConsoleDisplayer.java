package com.pilu.mundi.component.displayer;

import com.pilu.mundi.entity.ComplexSequence;
import com.pilu.mundi.entity.ComplexSequenceMatrix;

public class ConsoleDisplayer implements Displayer {
  public void display(ComplexSequenceMatrix matrix) {
    ComplexSequence[][] m = matrix.getMatrix();
    for(int j = 0; j < m.length; j++) {
      for(int i = 0; i < m[j].length; i++) {
        if(m[i][j].size() > 100) {
          System.out.print('O');
        }
        else {
          System.out.print('.');
        }
      }
      System.out.println();
    }
  }
}
