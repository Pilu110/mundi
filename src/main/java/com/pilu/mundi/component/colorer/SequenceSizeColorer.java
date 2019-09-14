package com.pilu.mundi.component.colorer;

import com.pilu.mundi.behaviour.Colorer;
import com.pilu.mundi.entity.ComplexSequence;

public class SequenceSizeColorer implements Colorer {
    @Override
    public int getColor(ComplexSequence sequence) {
        return sequence.size();
    }
}
