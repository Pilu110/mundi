package com.pilu.mundi.navigator;

import com.pilu.mundi.generator.Generator;
import org.apache.commons.math3.complex.Complex;

public class Navigator {

    private Complex origo;

    private final Generator generator;

    public Navigator(Generator generator) {
        this.generator = generator;
    }
}
