package ru.sbrf.cache.service.impl;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import ru.sbrf.cache.service.ExampleServcie;
import ru.sbrf.cache.service.ServicrReqScope;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Prioritized;
import javax.inject.Inject;

@ApplicationScoped
public class ServerInterceptorImitation implements ServerInterceptor, Prioritized {

    @Inject
    ExampleServcie exampleServcie;

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        exampleServcie.get("123");
        return next.startCall(call, headers);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
