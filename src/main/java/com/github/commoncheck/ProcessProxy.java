package com.github.commoncheck;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProcessProxy<T extends CommonProcess<P, Q>, P, Q> implements DynamicProxy<T, P, Q>, InvocationHandler {
    T target;

    public ProcessProxy(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        return result;
    }

    @Override
    public Q process(P p) {
        Q q = target.check(p);
        if (q != null) {
            return q;
        }
        q = target.process(p);
        return q;
    }
}