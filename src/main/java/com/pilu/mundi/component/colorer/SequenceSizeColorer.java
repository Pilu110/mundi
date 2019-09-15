package com.pilu.mundi.component.colorer;

import com.pilu.mundi.entity.ComplexSequence;

public class SequenceSizeColorer implements Colorer {
    @Override
    public int getColor(ComplexSequence sequence) {
        int s = sequence.size() * 10000;
        int b = s % 256;
        int g = s / 256 % 256;
        int r = s / 256 / 256 % 256;
        return r * 256*256 + g*256 + b;
    }
}
