package com.pilu.mundi.ui;

import java.awt.Point;

import com.pilu.mundi.entity.ComplexSequenceMatrix;
import com.pilu.mundi.generator.Generator;
import org.apache.commons.math3.complex.Complex;

public class ViewPort {

    private final Generator generator;
    private Point origo;
    private int width;
    private int height;
    private double scale;

    public ViewPort(Generator generator, Point origo, double scale, int width, int height) {
        this.generator = generator;
        this.origo = origo;
        this.scale = scale;
        this.width = width;
        this.height = height;
    }

    public void center(Point point) {
        origo = new Point(point.x - width / 2, point.y - height / 2);
    }

    public ComplexSequenceMatrix render() {

        ComplexSequenceMatrix matrix = new ComplexSequenceMatrix(width, height);

        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {

                double x = scale * (i - width / 2.0 + origo.x);
                double y = scale * (j - height / 2.0 + origo.y);

                matrix.set(i, j, generator.generate(new Complex(x, y)));
            }
        }

        return matrix;
    }
}