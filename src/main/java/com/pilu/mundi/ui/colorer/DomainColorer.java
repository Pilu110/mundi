package com.pilu.mundi.ui.colorer;

import java.awt.Color;

import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

public class DomainColorer implements Colorer {

    private final double lightScale;
    private final double lightOffset;

    public DomainColorer(double lightScale, double lightOffset) {
        this.lightScale = lightScale;
        this.lightOffset = lightOffset;
    }

    @Override
    public int getColor(ComplexSequence sequence, int maxSize) {
        return getDomainColor(sequence.size() > 0 ? sequence.getLast() : sequence.getBase(), sequence.size() == maxSize);
    }

    private int getDomainColor(Complex complex, boolean hasMaxSize) {
        double im = complex.getImaginary();
        double re = complex.getReal();
        double r = Math.sqrt(re*re + im*im);
        return Color.getHSBColor((float)(Math.atan2(im, re) / (2 * Math.PI)),1.0f, hasMaxSize ? 1.0f : ((float)((r / lightScale + lightOffset) % 1.0))).getRGB();
    }

}
