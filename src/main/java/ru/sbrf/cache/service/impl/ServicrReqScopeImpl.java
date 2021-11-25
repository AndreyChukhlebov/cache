package ru.sbrf.cache.service.impl;

import ru.sbrf.cache.service.ServicrReqScope;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ServicrReqScopeImpl implements ServicrReqScope {
    @Override
    public String get(String key) {
        System.out.println("key");
        return "Я работаю";
    }
}
