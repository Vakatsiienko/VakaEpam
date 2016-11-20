package com.vaka.epam.lab1.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by iaroslav on 18.11.16.
 */
public class BeanFabric {
    private static BeanFabric instance;

    private Map<String, Bean> beans;

    private BeanFabric() {
    }

    public static BeanFabric getInstance() {
        if (instance == null) {
            synchronized (BeanFabric.class) {
                if (instance == null) {
                    instance = init();
                }
            }
        }
        return instance;
    }

    private static BeanFabric init() {
        BeanFabric fabric = new BeanFabric();
        fabric.beans = new ConcurrentHashMap<>();
        return fabric;
    }

    public Bean getBean(String name) {
        return beans.get(name);
    }

}
