package ru.sbrf.cache;


import java.time.Duration;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class HelloGrpcServiceTest {

    @GrpcClient
    HelloGrpc helloGrpc;

    @Test
    public void testHello() {
        helloGrpc.sayHello(
                        HelloRequest.newBuilder().setName("Neo").build()).await()
                .atMost(Duration.ofSeconds(5));
    }

}
