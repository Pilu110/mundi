package com.pilu.mundi.generator;

import com.pilu.mundi.entity.Sequence;

public interface Generator<T> {
    Sequence<T> calculate(T n);
}
