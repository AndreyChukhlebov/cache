package ru.sbrf.cache.service.impl;

import javax.enterprise.context.RequestScoped;
import java.util.function.Supplier;

@RequestScoped
public class TestSuplier implements Supplier<String> {

    @Override
    public String get() {
        return this.toString();
    }
}
