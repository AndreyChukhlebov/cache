package ru.sbrf.cache.service.impl;

import ru.sbrf.cache.service.impl.Imitation.TestInterceptor;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Supplier;

@ApplicationScoped
public class TestInterceptorImitation extends TestInterceptor {


    public TestInterceptorImitation(
            Supplier<String> supplier
    ) {
        super(supplier, 3);
    }
}
