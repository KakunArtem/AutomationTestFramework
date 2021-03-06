package com.automation.test.framework.api.testContext;

import java.util.HashMap;

public class DataStore {
    private HashMap<Object, Object> map = new HashMap<>();

    Object put(Object key, Object value) {
        return map.put(key, value);
    }

     <T> T get(Object key, Class<T> tClass) {
        return tClass.cast(map.get(key));
    }

    @Override
    public String toString() {
        return "DataStore{" + "map=" + map + "}";
    }
}
