package com.github.commoncheck;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProcessProxy<T extends CommonProcess<P, Q>, P, Q> implements DynamicProxy<T, P, Q>, MethodInterceptor {
    private T t;

    public ProcessProxy(T t) {
        this.t = t;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        method.invoke(t, objects);
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Q process(P p) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(this);
        T t = (T) enhancer.create();
        Q q = t.check(p);
        if (q != null) {
            return q;
        }
        q = t.process(p);
        return q;
    }

}
