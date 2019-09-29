package com.pilu.mundi.entity;

import org.apache.commons.math3.complex.Complex;

public class ComplexSequenceMatrix {
  private final ComplexSequence [][] matrix;

  public ComplexSequenceMatrix(int width, int height) {
    matrix = new ComplexSequence[width][height];
  }

  public void set(int x, int y, ComplexSequence complexSequence) {
    matrix[x][y] = complexSequence;
  }

  public void add(int x, int y, Complex p)
  {
    if(x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      return;
    }

    ComplexSequence complexSequence = matrix[x][y];

    if(complexSequence == null) {
      complexSequence = new ComplexSequence(p);
      matrix[x][y] = complexSequence;
    }
    else {
      complexSequence.getSequence().add(p);
    }
  }

  public ComplexSequence get(int x, int y) {
    return matrix[x][y];
  }

  public ComplexSequence[][] getMatrix() {
    return matrix;
  }

  public int getWidth() {
    return matrix.length;
  }

  public int getHeight() {
    return matrix[0].length;
  }

  public int getMaxSize() {
    int maxSize = 0;
    for(int j = 0; j < getHeight(); j++) {
      for(int i = 0; i < getWidth(); i++) {
        if(matrix[i][j] != null) {
          int size = matrix[i][j].size();
          if(size > maxSize) {
            maxSize = size;
          }
        }
      }
    }

    return maxSize;
  }

}
