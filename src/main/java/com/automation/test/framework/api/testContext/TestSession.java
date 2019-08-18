package com.automation.test.framework.api.testContext;

import com.automation.test.framework.api.dto.GeneratedUser;
import com.automation.test.framework.api.dto.Name;
import io.restassured.response.Response;

public class TestSession {
    private static ThreadLocal<DataStore> dataStore =
            InheritableThreadLocal.withInitial(DataStore::new);

    private TestSession() {
    }

    private static DataStore getDataStore() {
        return dataStore.get();
    }

    public static void storeValue(Context key, Object value) {
        getDataStore().put(key, value);
    }

    public static <T> T getValueFromSession(Context key, Class<T> tClass) {
        return getDataStore().get(key, tClass);
    }

    public static String getValueFromSession(Context key) {
        return getDataStore().get(key, String.class);
    }

}
