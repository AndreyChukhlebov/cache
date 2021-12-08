package ru.sbrf.cache;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;
import ru.sbrf.cache.service.impl.Imitation.ServiceExample;
import ru.sbrf.cache.service.impl.Imitation.interceptor.Logging;

import javax.inject.Inject;

@GrpcService
public class HelloGrpcService implements HelloGrpc {


    @Inject
    ServiceExample serviceExample;

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        serviceExample.get("qwerty");
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
