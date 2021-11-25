package ru.sbrf.cache.service.impl.Imitation;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;

import javax.enterprise.inject.spi.Prioritized;
import java.util.function.Supplier;


public class TestInterceptor implements ServerInterceptor, Prioritized {

    private Supplier<String> supplier;
    private int priority;

    public TestInterceptor(Supplier<String> supplier, int priority) {
        this.supplier = supplier;
        this.priority = priority;
    }

    public TestInterceptor(){
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String s = supplier.get();
        System.out.println(s);
        return next.startCall(call, headers);
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
