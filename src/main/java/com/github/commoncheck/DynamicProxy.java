package com.github.commoncheck;

public interface DynamicProxy<T, P, Q> {
    Q process(P p);
}
