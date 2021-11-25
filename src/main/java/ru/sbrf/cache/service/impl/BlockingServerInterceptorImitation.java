package ru.sbrf.cache.service.impl;

import io.vertx.core.Vertx;
import ru.sbrf.cache.service.impl.Imitation.BlockingServerInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Prioritized;

@ApplicationScoped
public class BlockingServerInterceptorImitation extends BlockingServerInterceptor implements Prioritized {

    public BlockingServerInterceptorImitation(Vertx vertx) {
        super(vertx);
    }

    @Override
    public int getPriority() {
        return 5;
    }
}
