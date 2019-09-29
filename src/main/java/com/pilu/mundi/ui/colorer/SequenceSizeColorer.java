package com.pilu.mundi.ui.colorer;

import com.pilu.mundi.entity.ComplexSequence;

import java.awt.*;

public class SequenceSizeColorer implements Colorer {

    private float hue;
    private float saturation;

    public SequenceSizeColorer(float hue, float saturation) {
        this.hue = hue;
        this.saturation = saturation;
    }

    @Override
    public int getColor(ComplexSequence sequence, int max) {

        if(sequence == null) {
            return Color.BLACK.getRGB();
        }

        float brightness = (float) Math.sqrt((float)sequence.size() / (float)max);

        if(brightness > 1.0) {
            brightness = 1.0f;
        }

        return Color.HSBtoRGB(hue, saturation, brightness);
    }
}
