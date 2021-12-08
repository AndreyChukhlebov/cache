package ru.sbrf.cache.service.impl.Imitation;

import ru.sbrf.cache.service.impl.Imitation.interceptor.Logging;

import javax.inject.Singleton;

@Singleton
public class ServiceExampleImpl implements ServiceExample {

    @Override
    @Logging
    public String get(String str) {
        System.out.println("ServiceExampleImpl work");
        return str + str;
    }
}
