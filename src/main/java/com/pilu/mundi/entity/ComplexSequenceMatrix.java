package com.pilu.mundi.entity;

public class ComplexSequenceMatrix {
  private final ComplexSequence [][] matrix;

  public ComplexSequenceMatrix(int width, int height) {
    matrix = new ComplexSequence[width][height];
  }

  public void set(int x, int y, ComplexSequence complexSequence) {
    matrix[x][y] = complexSequence;
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
}
