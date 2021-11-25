package ru.sbrf.cache.service.impl;

import ru.sbrf.cache.service.ExampleServcie;
import ru.sbrf.cache.service.ServicrReqScope;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ExampleServcieImpl implements ExampleServcie {

    @Inject
    ServicrReqScope servicrReqScope;

    @Override
    public String get(String key) {
        System.out.println(servicrReqScope.toString());
        System.out.println(this.toString());
        return servicrReqScope.get(key);
    }
}
