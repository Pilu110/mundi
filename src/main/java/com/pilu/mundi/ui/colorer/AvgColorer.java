package com.pilu.mundi.ui.colorer;

import com.pilu.mundi.entity.ComplexSequence;
import org.apache.commons.math3.complex.Complex;

import java.awt.*;

public class AvgColorer implements Colorer {
    private float hue;
    private float saturation;

    public AvgColorer(float hue, float saturation) {
        this.hue = hue;
        this.saturation = saturation;
    }


    @Override
    public int getColor(ComplexSequence sequence, int max) {
        if(sequence == null) {
            return Color.BLACK.getRGB();
        }

        Complex sum = Complex.ZERO;
        for(Complex n : sequence.getSequence()) {
            sum = sum.add(n);
        }

        float brightness = (float) Math.sqrt((float)sum.sin().abs() / (float)max);

        if(brightness > 1.0) {
            brightness = 1.0f;
        }

        return Color.HSBtoRGB(hue, saturation, brightness);
    }
}
