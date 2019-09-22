package com.pilu.mundi.ui.colorer;

import com.pilu.mundi.entity.ComplexSequence;

import java.awt.*;

public class SequenceSizeColorer implements Colorer {

    private float hue;
    private float saturation;
    private int max;

    public SequenceSizeColorer(float hue, float saturation, int max) {
        this.hue = hue;
        this.saturation = saturation;
        this.max = max;
    }

    @Override
    public int getColor(ComplexSequence sequence) {
        return Color.HSBtoRGB(hue, saturation, (float)sequence.size() / (float)max);
    }
}
