package com.pilu.mundi.navigator;

import com.pilu.mundi.generator.Generator;
import org.apache.commons.math3.complex.Complex;

public abstract class Navigator {

    private final Generator generator;
    private Complex center;
    private int width;
    private int height;
    private double scale;

    public Navigator(Generator generator, Complex center, double scale, int width, int height) {
        this.generator = generator;
        this.center = center;
        this.scale = scale;
        this.width = width;
        this.height = height;
    }

    public void navigate() {
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < height; i++) {
                //double y = center.getImaginary() - height / 2.0
            }
        }
    }
}
