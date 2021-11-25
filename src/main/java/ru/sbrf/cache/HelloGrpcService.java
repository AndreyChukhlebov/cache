package ru.sbrf.cache;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;
import ru.sbrf.cache.service.ExampleServcie;

import javax.inject.Inject;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Inject
    ExampleServcie exampleServcie;

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {

        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
