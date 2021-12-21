package com.github.commoncheck;

public interface CommonProcess<T, V> {
    V process(T t);

    V check(T t);
}
