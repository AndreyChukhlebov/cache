package ru.sbrf.cache.service.impl.Imitation;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import ru.sbrf.cache.service.impl.TestRequestScopedBean;

import javax.enterprise.inject.spi.Prioritized;
import javax.inject.Singleton;


@Singleton
public class TestInterceptor implements ServerInterceptor, Prioritized {

    final TestRequestScopedBean testRequestScopedBean;

    public TestInterceptor(
            TestRequestScopedBean testRequestScopedBean
    ) {
        this.testRequestScopedBean = testRequestScopedBean;
    }

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
        String str = testRequestScopedBean.get();
        System.out.println(str);
        return next.startCall(call, headers);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
