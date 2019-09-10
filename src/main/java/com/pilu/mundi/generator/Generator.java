package com.pilu.mundi.generator;

import com.pilu.mundi.entity.Complex;
import com.pilu.mundi.entity.Sequence;

public interface Generator {
    public Sequence calculate(Complex n);
}
