package com.pilu.mundi.component;

import com.pilu.mundi.entity.ComplexSequenceMatrix;
import com.pilu.mundi.component.generator.Generator;
import org.apache.commons.math3.complex.Complex;

public class Navigator {

    private final Generator generator;
    private double ox;
    private double oy;
    private int width;
    private int height;
    private double scale;

    public Navigator(Generator generator, double ox, double oy, double scale, int width, int height) {
        this.generator = generator;
        this.ox = ox;
        this.oy = oy;
        this.scale = scale;
        this.width = width;
        this.height = height;
    }

    public ComplexSequenceMatrix navigate() {

        ComplexSequenceMatrix matrix = new ComplexSequenceMatrix(width, height);

        for(int j = 0; j < height; j++) {
            for(int i = 0; i < width; i++) {

                double x = scale * (i - width / 2.0) + ox;
                double y = scale * (j - height / 2.0) + oy;

                matrix.set(i, j, generator.generate(new Complex(x, y)));
            }
        }

        return matrix;
    }
}
