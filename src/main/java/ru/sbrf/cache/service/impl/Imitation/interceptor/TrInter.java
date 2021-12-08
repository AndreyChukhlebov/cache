package ru.sbrf.cache.service.impl.Imitation.interceptor;

import io.vertx.core.Vertx;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Logging
public class TrInter {

    @Inject
    private Vertx vertx;

    @AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        System.out.println("start");
        Object result = ctx.proceed();
        System.out.println("finish");
        return result;
    }
}
